package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;

public class ProductDAO {
	private JDBCUtil jdbcUtil = null;

	public ProductDAO() {
		jdbcUtil = new JDBCUtil();
	} 
	
	// 상품 추가
	public int add(Product product) throws SQLException{
		String query = "insert into product(productId, sellerId, price, description, name, category, type) "
				+ "values(Sequence_product.nextVal, ?, ?, ?, ?, ?, ?)";
		Object[] param = new Object[] {product.getSellerId(), product.getPrice(), product.getDescription(),
				product.getName(), product.getCategory(), product.getType()};
		jdbcUtil.setSqlAndParameters(query, param);
		String key[] = {"productId"};
	
		try {
			int result = jdbcUtil.executeUpdate(key);
			ResultSet rs = jdbcUtil.getGeneratedKeys();
			if(rs.next()) {
				int generatedKey = rs.getInt(1);
				product.setProductId(generatedKey);
			}
			return result;
		} catch (Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return 0; 
	}
	
	// 상품 수정
	public int update(Product product) throws SQLException{
		String query = "update product set name = ?, price = ?, description = ?, category = ? where productId = ?";
		Object[] param = new Object[] {product.getName(), product.getPrice(), product.getDescription(),
				 product.getCategory(), product.getProductId()};
		jdbcUtil.setSqlAndParameters(query, param);
		
		try {
			int result = jdbcUtil.executeUpdate();
			return result;
		}catch(Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		}finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return 0; // 성공적으로 수행된 개수 반환
	}
	
	// 상품 삭제
	public int remove(int productId) throws SQLException{
		String query = "delete from product where productId = ?";
		jdbcUtil.setSqlAndParameters(query, new Object[] {productId});
		
		try {
			int result = jdbcUtil.executeUpdate();
			return result;
		}catch(Exception e) {
			jdbcUtil.rollback();
			e.printStackTrace();
		}finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return 0; // 성공적으로 수행된 개수 반환
	}
	
	// 이름으로 상품 검색
	public List<Product> findProductByName(String name){
		String query = "select * from product where name = ?";
		jdbcUtil.setSqlAndParameters(query, new Object[] {name});
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Product> productList = new ArrayList<>();
			
			while(rs.next()) {
				Product product = new Product(
						rs.getInt("productId"),
						name,
						rs.getInt("price"),
						rs.getString("description"),
						rs.getString("type"),
						rs.getString("category"));
				productList.add(product);
			}
			return productList;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	// 전체 상품 목록 조회(음식/꽃 구분)
	public List<Product> findProductList(String type){
		String query = "select * from product where type = ? order by productId"; // 필요한 속성만 검색하기
		jdbcUtil.setSqlAndParameters(query, new Object[] {type});
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Product> productList = new ArrayList<>();
			
			while(rs.next()) {
				Product product = new Product(
						rs.getInt("productId"),
						rs.getString("name"),
						rs.getInt("price"),
						rs.getString("description"),
						type,
						rs.getString("category"));
				productList.add(product);
			}
			return productList;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	// 상품 상세 조회
	public Product findProduct(int productId) {
		String query = "select * from product where productId = ?";
		jdbcUtil.setSqlAndParameters(query, new Object[] {productId});
		Product product = null;
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			
			if(rs.next()) {
				product = new Product(
						productId, 
						rs.getString("name"),
						rs.getInt("price"),
						rs.getString("description"),
						rs.getString("type"),
						rs.getString("category"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			jdbcUtil.close();
		}
		return product;
	}

}
