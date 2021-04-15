package com.pafproject.customerApiProject;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/customers")              ///anotation
public class CustomerResource {
	
	
		CustomerRepository cr = new CustomerRepository();

		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<Customer> getAllStudent() {
			
			return cr.getAllCustomers();
			
			
		}
		
		@POST
		@Path("/customer")
		@Consumes(MediaType.APPLICATION_JSON)
		public Customer addCustomer(Customer c1) {
			
	
			return cr.createcustomer(c1);
		}
		
		@GET
		@Path("/customer/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public String getCities(@PathParam("id") String id) {
		Customer res = new Customer();
		res = cr.getcustomerid(Integer.parseInt(id));
		Gson test = new Gson();
		String jsonObject = test.toJson(res);
		return jsonObject;
		}
		
		@DELETE
		@Path("/customerdelete/{id}")
		@Consumes(MediaType.APPLICATION_JSON)
		public void deleteCustomer(@PathParam("id") String id){
			
			cr.deleteCustomer( Integer.parseInt(id));
		}
}
