package model.dao;

import model.CartItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;

public class CartDAO {
	private JDBCUtil jdbcUtil = null;
		
	public CartDAO() {	// 생성자 
		jdbcUtil = new JDBCUtil();
	}
	
	// 장바구니 항목 조회(장바구니 페이지 첫 화면에 나오는 품목 리스트)
	public List<CartItem> getCartItemList(String customerId) {
		String query = "SELECT cartItemId, quantity, productId FROM CartItem where customerId = ?";
		
		Object[] param = new Object[] { customerId };		// customerId = ? 의 매개변수 설정
		jdbcUtil.setSqlAndParameters(query, param);
		
		try { 
			ResultSet rs = jdbcUtil.executeQuery();		// query 문 실행		
			List<CartItem> list = new ArrayList<CartItem>();		// list 객체 생성
			while (rs.next()) {	
				CartItem dto = new CartItem();		// 하나의 CartItem 객체 생성 후 정보 설정
				dto.setCartItemId(rs.getInt("cartItemId"));
				dto.setQuantity(rs.getInt("quantity"));
				dto.setProductId(rs.getInt("productId"));
				list.add(dto);		// list 객체에 정보를 설정한 CartItem 객체 저장
			}
			return list;		// dto 들의 목록을 반환
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}		
		return null;	
	}
	
	// 장바구니에 등록
	public int addItem(CartItem item) {
		int result = 0;
		String query = "INSERT INTO CartItem (productId, quantity) VALUES(?) ";
		
		// query 문에 사용할 매개변수 값을 갖는 매개변수 배열 생성
		Object[] param = new Object[] { item.getProductId(), item.getQuantity() };		
		jdbcUtil.setSqlAndParameters(query, param);		
		
		try {		
			result = jdbcUtil.executeUpdate();		// insert 문 실행
			System.out.println(item.getCartItemId() + " item이 장바구니에 추가되었습니다.");
		} catch (SQLException ex) {
			System.out.println("입력 오류 발생!!!");
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();
		}		
		return result;	
	}
	
	// 장바구니에서 삭제 (같은 상품이라도 다른 옵션이면 따로 표시되니까 productId 대신 cartItemId로 변경)
	public int removeItem(int itemId) {
		String query = "DELETE FROM CartItem WHERE cartItemId = ?";
		
		jdbcUtil.setSql(query);
		Object[] param = new Object[] { itemId };
		jdbcUtil.setParameters(param);
		
		try {
			int result = jdbcUtil.executeUpdate();		// delete 문 실행
			return result;						// delete 에 의해 반영된 레코드 수 반환
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();		
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return 0;
	}
	
	// 장바구니 항목 옵션 수정
	public int updateItem(CartItem item) {
		String query = "UPDATE CartItem SET quantity = ? WHERE cartItemId = ?";
		
		Object[] tempParam = new Object[2];		// update 문에 사용할 매개변수를 저장할 수 있는 임시 배열
		
		tempParam[0] = item.getQuantity();
		tempParam[1] = item.getCartItemId();

		Object[] newParam = new Object[2];
		for (int i=0; i < newParam.length; i++)		
			newParam[i] = tempParam[i];
		
		jdbcUtil.setSqlAndParameters(query, newParam);
	
		try {
			int result = jdbcUtil.executeUpdate();		// update 문 실행
			return result;			// update 에 의해 반영된 레코드 수 반환
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}		
		return 0;
	}
	
} 
