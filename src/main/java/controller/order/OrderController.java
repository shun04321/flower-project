package controller.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.product.ManageProductController;
import model.CartItem;
import model.Customer;
import model.Orders;
import model.service.CartManager;
import model.service.OrderManager;
import model.service.UserManager;


public class OrderController implements Controller{
	private static final Logger log = LoggerFactory.getLogger(OrderController.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CartManager manager = CartManager.getInstance();
		UserManager userman = UserManager.getInstance();
		OrderManager orderman = OrderManager.getInstance();
		
		//GET을 해둬
		if(request.getMethod().equals("GET")) {
			log.debug("OrderForm Request");
			
			
			String customer = request.getParameter("customerId");
			List<CartItem> cart = manager.getCartItemList(customer);
			
			Customer cus = userman.findCustomer(customer);
			request.setAttribute("CartList", cart);
			request.setAttribute("Customer", cus);
			
			return "/order/orderForm.jsp";
		}
		
		//주문자 정보 POST 해둬
		Orders order = new Orders(
				0,
				request.getParameter(null),
				request.getParameter("receiveType"),
				request.getParameter("receiveName"),
				request.getParameter("receivePhone"),
				request.getParameter("memo"),
				request.getParameter("receiveAddress"),
				0);
		
		try {
	        orderman.addOrder(order, null, null);
	        log.debug("Creat Order: " +order.toString());
	        return "/payment/paymentForm";
	     }catch(Exception e) {
	        e.printStackTrace();
	        return "/order/orderForm.jsp";
	     }
			
	}
	
}