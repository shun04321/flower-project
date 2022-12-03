package model.dao.DAOtest;

import java.sql.SQLException;
import java.util.List;

import model.Product;
import model.dao.ProductDAO;

public class ProductTest {
	public static void main(String[] args) {
		/*
		 * ProductDAO 수정
		 * add 질의문 value 매개변수 수정
		 * findProductByName 질의문 수정
		 * dao, product 변수 타입 오류 수정
		 * update 질의문 -> sellerId 빼고 category 필드 추가
		 */
		
		ProductDAO productDao = new ProductDAO();
		
		//삭제
		try {
			productDao.remove(35);
			productDao.remove(36);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("remove 입력 오류");
		}
		
		//전체 검색
		System.out.println("\n추가 전\n꽃 전체");
		productDao.findProductList("flower");
		System.out.println("음식 전체");
		productDao.findProductList("food");
				
		//추가
		Product p1 = new Product(0, "flower_1", 5000, "desc", "flower", "cat", "seller0");	
		Product prod1 = null;
		try {
			prod1 = productDao.add(p1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("add 입력 오류");
		}
		
		//전체 검색
		System.out.println("\n추가 후\n꽃 전체");
		productDao.findProductList("flower");
		System.out.println("음식 전체");
		productDao.findProductList("food");
		System.out.println();
		
		//수정
		prod1.setName("flower_5");
		
		try {
			int i = productDao.update(prod1);
			System.out.println("\n수정 결과 -> i = " + i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("update 입력 오류");
		}
		
		//전체 검색
		System.out.println("\n수정 후\n꽃 전체");
		productDao.findProductList("flower");
		
		//상품 상세 조회
		System.out.println("\n1번 제품 상세정보");
		productDao.findProduct(1);
		System.out.println();
		
		//이름으로 상품 검색
		System.out.println("\n이름으로 검색");
		List<Product> pList = productDao.findProductByName("flower");
		System.out.println("검색 결과: ");
		for (Product p : pList) {
			System.out.println(p.getName());
		}
	}
   
}