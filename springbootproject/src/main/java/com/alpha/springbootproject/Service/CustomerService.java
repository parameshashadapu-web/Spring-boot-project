package com.alpha.springbootproject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alpha.springbootproject.DTO.CustomerDto;
import com.alpha.springbootproject.DTO.ResponseStructure;
import com.alpha.springbootproject.Repository.CustomerRepo;
import com.alpha.springbootproject.entity.Customer;
import com.alpha.springbootproject.exception.CustomerNotFoundExcep;

@Service
public class CustomerService {

	
	@Autowired
	private CustomerRepo customerRepo;
	
	
	public ResponseStructure<Customer> saveCustomer(CustomerDto customerDto) {
		
		Customer c=new Customer();
		c.setAge(customerDto.getAge());
		c.setEmail(customerDto.getEmail());
		c.setMobilno(customerDto.getMobilno());
		c.setName(customerDto.getName());
		c.setOrders(customerDto.getOrders());
		
		Customer c1=customerRepo.findByMobilno(c.getMobilno());
		ResponseStructure<Customer> rs=new ResponseStructure<Customer>();
		
		if(c1==null) {
			customerRepo.save(c);
			rs.setData(c);
			rs.setMeaasge("data found successfully");
			rs.setStatuscode(HttpStatus.OK.value());
		}
		else {
			System.out.println("customer exists");
			throw new CustomerNotFoundExcep();
		}
		
		
		return rs;
		
	}


	public ResponseStructure<Customer> findCustomer(long mobileno) {

        //  Customer c=new Customer();
        Customer c=customerRepo.findByMobilno(mobileno);
        ResponseStructure< Customer> rs= new ResponseStructure<Customer>();
        if(c!=null) {
        	rs.setData(c);
        	rs.setMeaasge("customer found successfully");
        	rs.setStatuscode(HttpStatus.ACCEPTED.value());
        	
        	return rs;
        }
        else {
        	throw new CustomerNotFoundExcep();
        }
		
	}


	public ResponseStructure<Customer> deleteCustomer(long mobileno) {
		
		Customer c=customerRepo.findByMobilno(mobileno);
		ResponseStructure<Customer> rs=new ResponseStructure<Customer>();
		
		if(c!=null) {
			rs.setData(c);
			rs.setMeaasge("data deleted");
			rs.setStatuscode(HttpStatus.OK.value());
			customerRepo.delete(c);
			
		}
		else {
			throw new CustomerNotFoundExcep();
		}
		return rs;
	}

	

	
	
}
