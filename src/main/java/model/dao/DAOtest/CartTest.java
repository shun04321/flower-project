package model.dao.DAOtest;

import model.CartItem;
import model.dao.CartDAO;

public class CartTest {
	public static void main(String[] args) {
		/*
		 * CartDAO 수정
		 * cartItemId -> Sequence_cartItem로 pk 자동 생성
		 * addItem -> 입력 오류 발생 문제 해결
		 * 조회 -> id 순으로 변경
		 */
		
		CartDAO cartDao = new CartDAO();
		
		//조회, 추가
		CartItem cart1 = new CartItem(0, 1, "customer0", 2);	//cartItemId, quantity, customerId, productId
		cartDao.getCartItemList("customer0");
		cartDao.addItem(cart1);
        cartDao.getCartItemList("customer0");	//customerId
        System.out.println("---------------------\n");

        /*
        CartItem cart2 = new CartItem(102, 5, "customer3", 1);
        cartDao.getCartItemList("customer3");
        cartDao.addItem(cart2);
        cartDao.getCartItemList("customer3");
        System.out.println("---------------------\n");

        CartItem cart3 = new CartItem(102, 2, "customer3", 2);
        cartDao.getCartItemList("customer3");
        cartDao.addItem(cart3);
        cartDao.getCartItemList("customer3");
        System.out.println("---------------------\n");
        */
        
        //삭제
        cartDao.getCartItemList("customer0");
        cartDao.removeItem(1);	//cartItemId
        cartDao.getCartItemList("customer0");
        System.out.println("---------------------\n");
        
        //수정
        cart1.setQuantity(50);	//cart1 수량 변경 1 -> 10
        cartDao.updateItem(cart1);
        
        cartDao.getCartItemList("customer0");
    }
   
}