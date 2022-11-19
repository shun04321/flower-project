package model.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

// Seller 구현 필요

public class UserDAO {
	private JDBCUtil jdbcUtil = null;
	
	public UserDAO() {			
		jdbcUtil = new JDBCUtil();
	}
		
	// 회원 가입
	public int create(Customer customer) throws SQLException {
		String sql = "INSERT INTO customer VALUES (?, ?, ?, ?, ?, ?)";		
		Object[] param = new Object[] {customer.getCustomerId(), customer.getPwd(), customer.getName(), 
										customer.getPhone(), customer.getEmail(), customer.getAddress()};				
		jdbcUtil.setSqlAndParameters(sql, param);
						
		try {				
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();
		}		
		return 0;			
	}

	// 회원 정보 수정
	public int update(Customer customer) throws SQLException {
		String sql = "UPDATE customer "
					+ "SET pwd=?, name=?, phone=?, email=?, address=? "
					+ "WHERE customerId=?";
		Object[] param = new Object[] {customer.getPwd(), customer.getName(), customer.getPhone(), 
										customer.getEmail(), customer.getAddress(), customer.getUserId()};				
		jdbcUtil.setSqlAndParameters(sql, param);
		
		try {				
			int result = jdbcUtil.executeUpdate();
			return result;
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

	// 로그인
	public int login(String customerId, String pwd) throws SQLException {
		String sql = "SELECT pwd FROM customer WHERE customerId=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {customerId});
		
		try {				
			int result = jdbcUtil.executeUpdate();

			if(result.next()) {
				if(customerId.equals("admin") && result.getString(1).equals(pwd))
					return 1; //관리자 로그인 성공 
				else if(result.getString(1).equals(pwd))
					return 2; //사용자 로그인 성공
				else 
					return 0; //비밀번호 불일치
			}
			return -1; //존재하지 않는 아이디
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
	
	// 회원 탈퇴
	public int remove(String customerId) throws SQLException {
		String sql = "DELETE FROM customer WHERE customerId=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {customerId});
		
		try {				
			int result = jdbcUtil.executeUpdate();
			return result;
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

	// 회원 상세 조회
	public Customer findUser(String customerId) throws SQLException {
        String sql = "SELECT * FROM customer WHERE customerId=?";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {customerId});

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				Customer customer = new Customer(
					customerId,
					rs.getString("pwd"),
					rs.getString("name"),
					rs.getString("phone"),
					rs.getString("email"),					
					rs.getString("address"));
				return customer;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	// 회원 목록 조회 - customer 테이블 전체를 List로 반환하는 함수
	public List<Customer> findUserList() throws SQLException {
        String sql = "SELECT * FROM customer ORDER BY customerId";
		jdbcUtil.setSqlAndParameters(sql, null);
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			List<Customer> customerList = new ArrayList<Customer>();
			while (rs.next()) {
				Customer customer = new Customer(
					rs.getString("customerId"),
					rs.getString("name"),
					rs.getString("phone"),
				customerList.add(customer);
			}		
			return customerList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	// 회원 목록 조회 - customer 테이블 전체를 List로 반환하는 함수 (현재 페이지, 페이지당 출력할 사용자 수)
	public List<Customer> findUserList(int currentPage, int countPerPage) throws SQLException {
		String sql = "SELECT * FROM customer ORDER BY customerId";
		jdbcUtil.setSqlAndParameters(sql, null, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			int start = ((currentPage-1) * countPerPage) + 1;
			
			if ((start >= 0) && rs.absolute(start)) {
				List<Customer> customerList = new ArrayList<Customer>();
				
				do {
					Customer customer = new Customer(
						rs.getString("customerId"),
						rs.getString("name"),
						rs.getString("phone"),
					customerList.add(customer);
				} while ((rs.next()) && (--countPerPage > 0));		
				
				return customerList;							
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}
	
	//아이디 중복체크 함수
	public boolean existingUser(String customerId) throws SQLException {
		String sql = "SELECT count(*) FROM customer WHERE customerId=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {customerId});

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return false;
	}

}
