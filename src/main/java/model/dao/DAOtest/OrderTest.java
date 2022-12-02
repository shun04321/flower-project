package model.dao.DAOtest;

import java.sql.SQLException;

import model.LineItem;
import model.Orders;
import model.dao.OrderDAO;

public class OrderTest {
	public static void main(String[] args) {
		/*
		 * findOrderList()
		 * findOrderList(cId)
		 * findOrder
		 * addOrder
		 */
		
		OrderDAO dao = new OrderDAO();
		
		Orders order = new Orders(1, "customer0", "배송", "수령인", "010-1111", "메모", "주소");
		
		//주문추가
		int[] quantity = { 1 };
		int[] pId = { 34 };
		try {
			System.out.println("add ");
			dao.addOrder(order, quantity, pId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("add 입력 오류");
		}
		
		//모든주문
		try {
			System.out.println("모든 주문 목록");
			dao.findOrderList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("find all 입력오류");
		}
		
		/*
		//고객주문내역
		try {
			System.out.println("\naaa 고객 주문 목록");
			dao.findOrderList("aaa");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("find 입력오류");
		}
		
		//주문상세
		try {
			System.out.println("orderId 1 상세정보 조회");
			dao.findOrder(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("상세정보 입력 오류");
		}
		*/
    }
   
}