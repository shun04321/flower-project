package controller.user;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.UserManager;
import model.service.UserNotFoundException;
import model.Customer;

public class ViewUserController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	// 로그인 여부 확인
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/user/login/form";		// login form 요청으로 redirect
        }
    	
		UserManager manager = UserManager.getInstance();
		String customerId = request.getParameter("customerId");
		
		Customer customer = null;
		try {
			customer = manager.findCustomer(customerId);	// 사용자 정보 검색
		} catch (UserNotFoundException e) {				
	        return "redirect:/user/list";
		}	
		
		request.setAttribute("customer", customer);		// 사용자 정보 저장				
		return "/user/view.jsp";				// 사용자 보기 화면으로 이동
    }
}
