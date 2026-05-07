package com.alpha.springbootproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.springbootproject.DTO.CustomerDto;
import com.alpha.springbootproject.DTO.ResponseStructure;
import com.alpha.springbootproject.Service.CustomerService;
import com.alpha.springbootproject.entity.Customer;
//import com.sun.tools.javac.resources.compiler;

@RestController
public class CustomerController {

	
	@Autowired
	private CustomerService customerService;
	
	//=============save customer==================//
	@PostMapping("/save/customer")
	public ResponseStructure<Customer> saveCustomer(@RequestBody CustomerDto customerDto) {
	
	return	customerService.saveCustomer(customerDto);
		
	}
	
	
	//===============find customer==============//
	
	@GetMapping("/find/customer")
	public ResponseStructure<Customer> findCustomer(@RequestParam long mobileno) {
		return customerService.findCustomer(mobileno);
	}
	
	
	
	
	
	//=====================delete customer===============//
	@DeleteMapping("/delete/customer")
	public ResponseStructure<Customer> deleteCustomer(@RequestParam long mobileno) {
		return customerService.deleteCustomer(mobileno);
	}
	
	
}
