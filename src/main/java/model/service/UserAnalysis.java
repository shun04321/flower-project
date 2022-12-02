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
	public List<Customer> recommendFriends(String customerId) throws Exception {
		Customer thisuser = dao.findCustomer(customerId);
		if (thisuser == null) {
			throw new Exception("invalid user ID!");
		}
		int m1 = customerId.indexOf('@');
		if (m1 == -1) return null;
		String mserver1 = thisuser.getEmail().substring(m1);
		
		List<Customer> friends = new ArrayList<Customer>();
		
		List<Customer> customerList = dao.findCustomerList(1, 10000);
		Iterator<Customer> userIter = customerList.iterator();		
		while (userIter.hasNext()) {
			Customer customer = (Customer)userIter.next();
			
			if (customer.getCustomerId().equals(customerId)) continue;
			int m2 = customer.getEmail().indexOf('@');
			if (m2 == -1) continue;
			String mserver2 = customer.getEmail().substring(m2);

			if (mserver1.equals(mserver2)) 
				friends.add(customer);		
		}
		return friends;
	}

}
