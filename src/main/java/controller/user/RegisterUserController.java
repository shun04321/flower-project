package controller.user;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Customer;
import model.service.ExistingUserException;
import model.service.UserManager;

public class RegisterUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(RegisterUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       	if (request.getMethod().equals("GET")) {	
    		// GET request: 회원정보 등록 form 요청	
    		log.debug("RegisterForm Request");

    		//List<Community> commList = UserManager.getInstance().findCommunityList();	// 커뮤니티 리스트 검색
			//request.setAttribute("commList", commList);	
		
			return "/user/registerForm.jsp";   // 검색한 커뮤니티 리스트를 registerForm으로 전송     	
	    }	

    	// POST request (회원정보가 parameter로 전송됨)
       	Customer customer = new Customer (
			request.getParameter("customerId"),
			request.getParameter("pwd"),
			request.getParameter("name"),
			request.getParameter("phone"),
			request.getParameter("email"),
			request.getParameter("address"));
		
        log.debug("Create User : {}", customer);

		try {
			UserManager manager = UserManager.getInstance();
			manager.createCustomer(customer);
	        return "redirect:/user/list";	// 성공 시 사용자 리스트 화면으로 redirect
	        
		} catch (ExistingUserException e) {	// 예외 발생 시 회원가입 form으로 forwarding
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("user", customer);
			return "/user/registerForm.jsp";
		}
    }
}

