package model.dao.DAOtest;

import java.sql.SQLException;
import java.util.List;

import model.Customer;
import model.Seller;
import model.dao.UserDAO;

public class UserTest {
	public static void main(String[] args) {
		/*
		 * UserDAO 수정x
		 * 
		 */
		
		UserDAO dao = new UserDAO();
		
		/*
		//고객 회원가입
		Customer c1 = new Customer("cId02", "cpwd01", "new", "010-9999-9999", "ccc@naver.com", "서울시 성북구");
		try {
			int i = dao.createCustomer(c1);
			System.out.println("고객 회원가입 결과(0이면 실패): " + i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("create Customer 입력 오류");
		}
		
		
		//아이디 중복 조회
		boolean valid = false;
		try {
			valid = dao.existingCustomer(c1.getCustomerId());
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			System.out.println("아이디 중복 조회 오류");
		}
		System.out.println("아이디 중복(true면 중복): " + valid);
		*/
		
		//고객 목록 조회
		try {
			List<Customer> cList = dao.findCustomerList();
			System.out.println("전체고객목록");
			for (Customer s : cList) {
				System.out.println("[아이디: " + s.getCustomerId() + ", 이름: " + s.getName() + "]");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("고객 목록 조회 오류");
		}
		
		/*
		//판매자 회원가입
		Seller s = new Seller("sId01", "spwd01", "승연", "010-8888-8888", "ss@naver.com");
		try {
			int i = dao.createSeller(s);
			System.out.println("판매자 회원가입 결과(0이면 실패): " + i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("create Seller 입력 오류");
			System.out.println("판매자 목록 조회 오류");
		}
		*/
		
		//아이디로 고객 정보 조회
		Customer cDetail = null;
		try {
			cDetail = dao.findCustomer("cId01");
			System.out.println("\n*" + cDetail.getCustomerId() + "고객 이름은 " + cDetail.getName() + " 변경 전 비번은 " + cDetail.getPwd());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//고객 정보 수정
		cDetail.setPwd("newpwd!!");
		try {
			int i = dao.updateCustomer(cDetail);
			System.out.println("고객 정보 수정 결과(0이면 실패): " + i);
			System.out.println("\n*" + cDetail.getCustomerId() + "고객 이름은 " + cDetail.getName() + " 변경된 비번은 " + cDetail.getPwd());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//판매자 정보 수정 -> 회원가입 되어 있으면 seller id 어떻게 가져오지
    }
   
}