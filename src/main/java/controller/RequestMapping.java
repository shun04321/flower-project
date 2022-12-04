package controller;

import java.util.HashMap;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.product.*;
import controller.classes.*;
import controller.order.*;
import controller.user.*;
import controller.cart.*;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    // 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	// 각 uri에 대응되는 controller 객체를 생성 및 저장
        mappings.put("/", new ForwardController("index.jsp"));
 
        // 상품 관련 request URI
        mappings.put("/product/search", new SearchProductController());
        mappings.put("/product/list", new ListProductController());
        mappings.put("/product/view", new ViewProductController());
        mappings.put("/product/add", new ManageProductController());
        mappings.put("/product/update", new ManageProductController());
        mappings.put("/product/delete", new ManageProductController());
       
        // 클래스 관련 request URI
        mappings.put("/class/list", new ListClassController());
        mappings.put("/class/add", new ManageClassController());
        mappings.put("/class/update", new ManageClassController());
        mappings.put("/class/delete", new ManageClassController());
        
        mappings.put("/user/login/form", new ForwardController("/user/loginForm.jsp"));
        mappings.put("/user/login", new LoginController());
        mappings.put("/user/logout", new LogoutController());
        mappings.put("/user/list", new ListUserController());
        mappings.put("/user/view", new ViewUserController());
        
        // 회원 가입 폼 요청과 가입 요청 처리 병합 (폼에 커뮤니티 선택 메뉴 추가를 위함)
//      mappings.put("/user/register/form", new ForwardController("/user/registerForm.jsp"));
//      mappings.put("/user/register", new RegisterUserController());
        mappings.put("/user/register", new RegisterUserController());

        // 사용자 정보 수정 폼 요청과 수정 요청 처리 병합
//      mappings.put("/user/update/form", new UpdateUserFormController());
//      mappings.put("/user/update", new UpdateUserController());        
        mappings.put("/user/update", new UpdateUserController());
        
        mappings.put("/user/delete", new DeleteUserController());
        
        // 커뮤니티 관련 request URI 추가
        mappings.put("/community/create/form", new ForwardController("/community/creationForm.jsp"));
        
        // 장바구니 관련
        mappings.put("/cart/add", new ManageCartController());
        mappings.put("/cart/update", new ManageCartController());
        mappings.put("/cart/view", new ViewCartController());
        mappings.put("/cart/delete", new ManageCartController());
        
        //주문 관련
        mappings.put("/order/form", new OrderController());
        mappings.put("/order/list", new ListOrderController());
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
    	// 주어진 uri에 대응되는 controller 객체를 찾아 반환
        return mappings.get(uri);
    }
}
