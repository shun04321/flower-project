package controller.cart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.service.CartManager;
import model.CartItem;
import model.Customer;

public class ViewCartController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	// 로그인 여부 확인
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/user/login/form";		// login form 요청으로 redirect
        }
    	
    	//고객 아이디 얻어오기
    	//UserManager userMan = UserManager.getInstance();
		String customerId = request.getParameter("customerId");
		
		CartManager manager = CartManager.getInstance();
		List<CartItem> cartItem = manager.getCartItemList(customerId);

		request.setAttribute("cartItem", cartItem);
		return "/order/view.jsp";
    }
}
