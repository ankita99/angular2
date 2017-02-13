package com.psl.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.psl.dao.CustomerDao;
import com.psl.model.Customer;

@Path("/customer")
public class CustomerService {

	@Path("/all") 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getcust() {
		List<Customer> customer=CustomerDao.getAllCustomer();
		return  Response.ok(customer).header("Access-Control-Allow-Origin", "*").build();
		
	}
	
	@POST
	@Path("/addCust")
	@Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
	public Response insertCustomer(Customer cust) {
		boolean status= false;
		Response response = null;
		status = CustomerDao.addCustomer(cust);
		if(status){
			response = Response.status(200).header("Access-Control-Allow-Origin", "*").build();
		}
		return response;
	}
}
