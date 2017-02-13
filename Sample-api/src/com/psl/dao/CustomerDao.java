package com.psl.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.psl.model.Customer;

public class CustomerDao {

	
	private static List<Customer> customer = new ArrayList();
	
	static { 
		System.out.println("In DAO...");
		customer.add(new Customer(100, "Ankita Singh", "abc"));
		customer.add(new Customer(200, "Shilpa Kedia", "xyz"));
		customer.add(new Customer(300, "Rashmi Mohod", "pqr"));
		
	}
	
	public static List<Customer> getAllCustomer() {
		return customer;
	}
	
	public static boolean addCustomer(Customer cust) {
		boolean status=	customer.add(cust);
		return status;
	}
	
}
