package controller.cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.CartItem;
import model.service.CartManager;

public class ManageCartController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(ManageCartController.class);
	public static final String USER_SESSION_KEY = "userId";
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CartManager manager = CartManager.getInstance();
		
		// 추가(product/view에서 id 넘겨주면 그걸로 추가
		if(request.getServletPath().equals("/cart/add")) {
			CartItem cartItem = new CartItem(
				Integer.parseInt(request.getParameter("cartItemId")),
				Integer.parseInt(request.getParameter("quantity")),
				request.getParameter("customerId"),
				Integer.parseInt(request.getParameter("productId")));
			
			try {
				manager.addItem(cartItem);
				log.debug("Create cart: " + cartItem.toString());
				return "redirect:/cart";
			}catch(Exception e) {
				e.printStackTrace();
				return "/product/view.jsp";
			}
		}
		
		// 수정
		else if(request.getServletPath().equals("/cart/update")) {
			int updateQuantity = Integer.parseInt(request.getParameter("quantity"));
			int cartItemId = Integer.parseInt(request.getParameter("cartItemId"));
			//Product product = manager.findProduct(updateId);
			CartItem c = manager.getCartItem(cartItemId);


			CartItem cartItem = new CartItem(
					c.getCartItemId(),
					updateQuantity,
					c.getCustomerId(),
					c.getProductId());
					
			manager.updateItem(cartItem);
			log.debug("Update Product: " + cartItem.toString());
			return "redirect:/cart/view";
		}
				
		// 삭제
		else {
			int deleteId = Integer.parseInt(request.getParameter("cartItemId"));
			
			//삭제 버튼 누르면 팝업창 뜨고 삭제되게
			manager.removeItem(deleteId);
		}
		return "redirect:/cart/view";
	}
	
}
