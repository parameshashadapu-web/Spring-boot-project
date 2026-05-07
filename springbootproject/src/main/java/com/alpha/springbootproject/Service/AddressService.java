package com.alpha.springbootproject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alpha.springbootproject.DTO.ResponseStructure;
import com.alpha.springbootproject.DTO.SaveAddressDto;
import com.alpha.springbootproject.DTO.SaveDriverDto;
import com.alpha.springbootproject.Repository.AddressRepo;
import com.alpha.springbootproject.entity.Address;
import com.alpha.springbootproject.entity.Driver;
import com.alpha.springbootproject.exception.AddressAlreadyExists;
import com.alpha.springbootproject.exception.AddressNotFound;
import com.alpha.springbootproject.exception.DriverNotFound;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepo addressRepo;
	
	

	public ResponseStructure<Address> saveAddress(SaveAddressDto addressdto) {
		
		Address add=new Address();
		add.setPincode(addressdto.getPincode());
		add.setState(addressdto.getState());
		add.setStreet(addressdto.getStreet());
		add.setCity(addressdto.getCity());
		
		ResponseStructure<Address> rs=new ResponseStructure<Address>();

		
		Address a=addressRepo.findByPincode(addressdto.getPincode());
		if(a==null) {
					
			Address a1=addressRepo.save(add);
			rs.setData(a1);
			rs.setMeaasge("data entered succesfully");
			rs.setStatuscode(202);
			
		}
		else {
			System.out.println("pincode already exists");
			throw new AddressAlreadyExists();
		}
		
		return rs;
	}


	//------------FIND OPERATION--------------

	public ResponseStructure<Address> findAddressByPincode(int pincode) {
		
		Address a=addressRepo.findByPincode(pincode);
		ResponseStructure<Address> rs=new ResponseStructure<Address>();
		
		if(a!=null) {
			
			rs.setData(a);
            rs.setMeaasge("data fetched sucessfully");
            rs.setStatuscode(HttpStatus.BAD_GATEWAY.value());
			
		}
		else {
			throw new AddressNotFound();
		}
		
		return rs;
	}


	public ResponseStructure<List<Address>> findAllAddress() {
	
		List<Address> a=addressRepo.findAll();
		if(a.size()>0) {
			ResponseStructure<List<Address>> rs=new ResponseStructure<List<Address>>();
			rs.setStatuscode(HttpStatus.ACCEPTED.value());
			rs.setMeaasge("data found successfully");
			rs.setData(a);
			
			return rs;
		}
		else {
			throw new AddressNotFound();
		}
	}


	public ResponseStructure<Address> deleteAddress(int id) {

		Address a=addressRepo.findById(id).orElseThrow(()->new AddressNotFound());
		ResponseStructure<Address> rs=new ResponseStructure<Address>();
		if(a!=null) {
			addressRepo.deleteById(a.getId());
			
			rs.setData(a);
			rs.setMeaasge("data dleted successfully");
			rs.setStatuscode(HttpStatus.ACCEPTED.value());
		}
		return rs;
	}

	
}
