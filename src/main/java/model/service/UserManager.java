package model.service;

import java.sql.SQLException;

import java.util.List;

import model.Customer;
import model.dao.UserDAO;

/**
 * 사용자 관리 API를 사용하는 개발자들이 직접 접근하게 되는 클래스.
 * UserDAO를 이용하여 데이터베이스에 데이터 조작 작업이 가능하도록 하며,
 * 데이터베이스의 데이터들을 이용하여 비지니스 로직을 수행하는 역할을 한다.
 * 비지니스 로직이 복잡한 경우에는 비지니스 로직만을 전담하는 클래스를 
 * 별도로 둘 수 있다.
 */
public class UserManager {
	private static UserManager userMan = new UserManager();
	private UserDAO userDAO;
	private UserAnalysis userAanlysis;

	private UserManager() {
		try {
			userDAO = new UserDAO();
			userAanlysis = new UserAnalysis(userDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static UserManager getInstance() {
		return userMan;
	}
	
	public int createCustomer(Customer customer) throws SQLException, ExistingUserException {
		if (userDAO.existingCustomer(customer.getCustomerId()) == true) {
			throw new ExistingUserException(customer.getCustomerId() + "는 존재하는 아이디입니다.");
		}
		return userDAO.createCustomer(customer);
	}

	public int updateCustomer(Customer customer) throws SQLException, UserNotFoundException {
		return userDAO.updateCustomer(customer);
	}	

	public int removeCustomer(String customerId) throws SQLException, UserNotFoundException {
		return userDAO.removeCustomer(customerId);
	}

	public Customer findCustomer(String customerId)
		throws SQLException, UserNotFoundException {
		Customer customer = userDAO.findCustomer(customerId);
		
		if (customer == null) {
			throw new UserNotFoundException(customerId + "는 존재하지 않는 아이디입니다.");
		}		
		return customer;
	}

	public List<Customer> findCustomerList() throws SQLException {
			return userDAO.findCustomerList();
	}
	
	public List<Customer> findCustomerList(int currentPage, int countPerPage)
		throws SQLException {
		return userDAO.findCustomerList(currentPage, countPerPage);
	}

	public boolean login(String customerId, String pwd)
		throws SQLException, UserNotFoundException, PasswordMismatchException {
		Customer customer = findCustomer(customerId);

		if (!customer.matchPassword(pwd)) {
			throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
		}
		return true;
	}

	public List<Customer> makeFriends(String customerId) throws Exception {
		return userAanlysis.recommendFriends(customerId);
	}

	public UserDAO getUserDAO() {
		return this.userDAO;
	}
}
