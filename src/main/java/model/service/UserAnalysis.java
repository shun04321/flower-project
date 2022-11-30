package model.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Customer;
import model.dao.UserDAO;

// an example business class
public class UserAnalysis {
	private UserDAO dao;
	
	public UserAnalysis() {}
	
	public UserAnalysis(UserDAO dao) {
		super();
		this.dao = dao;
	}

	// an example business method
	public List<Customer> recommendFriends(String userId) throws Exception {
		Customer thisuser = dao.findCustomer(userId);
		if (thisuser == null) {
			throw new Exception("invalid user ID!");
		}
		int m1 = userId.indexOf('@');
		if (m1 == -1) return null;
		String mserver1 = thisuser.getEmail().substring(m1);
		
		List<Customer> friends = new ArrayList<Customer>();
		
		List<Customer> userList = dao.findCustomerList(1, 10000);
		Iterator<Customer> userIter = userList.iterator();		
		while (userIter.hasNext()) {
			Customer user = (Customer)userIter.next();
			
			if (user.getCustomerId().equals(userId)) continue;
			int m2 = user.getEmail().indexOf('@');
			if (m2 == -1) continue;
			String mserver2 = user.getEmail().substring(m2);

			if (mserver1.equals(mserver2)) 
				friends.add(user);		
		}
		return friends;
	}

}
