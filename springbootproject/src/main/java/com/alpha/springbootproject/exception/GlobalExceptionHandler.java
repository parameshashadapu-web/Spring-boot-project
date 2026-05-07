package com.alpha.springbootproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alpha.springbootproject.DTO.ResponseStructure;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DriverAlreadyExists.class)
	public ResponseStructure<String> DriverAlreadyExits() {
	
		ResponseStructure<String> rs=new ResponseStructure<String>();
		
		rs.setData(null);
		rs.setStatuscode(404);
		rs.setMeaasge("driver already exists");
		
		return rs;
	}
	
	@ExceptionHandler(AddressAlreadyExists.class)
	public ResponseStructure<String> AddressAlreadyExits() {
	
		ResponseStructure<String> rs=new ResponseStructure<String>();
		
		rs.setData(null);
		rs.setStatuscode(404);
		rs.setMeaasge("address already exists");
		
		return rs;
	}
	
	@ExceptionHandler(TruckAlreadyExists.class)
     public ResponseStructure<String> TruckAlreadyExists(){
		
		ResponseStructure<String> rs=new ResponseStructure<String>();
		
		rs.setData(null);
		rs.setMeaasge("already this truck exists");
		rs.setStatuscode(404);
		return rs;
		
	}
	
	
	
	//----------------FIND OPERATIONS---------------------
	
	
	@ExceptionHandler(DriverNotFound.class)
	public ResponseStructure<String> driverNotFound() {
		ResponseStructure<String> rs=new ResponseStructure<String>();
		rs.setData(null);
		rs.setMeaasge("driver not found by this num , please enter a valid contact num");
		rs.setStatuscode(HttpStatus.BAD_GATEWAY.value());
		return rs;
	}
	
	@ExceptionHandler(AddressNotFound.class)
	public ResponseStructure<String> addressnotfound(){
		ResponseStructure<String> rs=new ResponseStructure<String>();
		rs.setData(null);
		rs.setMeaasge("invalid pincode,please enter a alid pincode");
		rs.setStatuscode(HttpStatus.BAD_GATEWAY.value());
		
		return rs;
	}

	
	@ExceptionHandler(TruckNotFound.class)
	public ResponseStructure<String> truckNotFound(){
		ResponseStructure<String> rs=new ResponseStructure<String>();
		rs.setData(null);
		rs.setData("invalid truck number,please enter a valid truck number");
		rs.setStatuscode(HttpStatus.BAD_GATEWAY.value());
		
		return rs;
	}
	
	
	@ExceptionHandler(CarrierNotFound.class)
	public ResponseStructure<String> carrierNotFound(){
		
		ResponseStructure<String> rs =new ResponseStructure<String>();
		
		rs.setData(null);
		rs.setStatuscode(HttpStatus.BAD_GATEWAY.value());
		rs.setMeaasge("error!,carrier not found");
		
		return rs;
	}
	
	
	@ExceptionHandler(LoadAndUnloadAdressMatch.class)
	public ResponseStructure<String> loadAndUnloadAdressMatch(){
		
		ResponseStructure<String> rs =new ResponseStructure<String>();
		
		rs.setData(null);
		rs.setStatuscode(HttpStatus.BAD_GATEWAY.value());
		rs.setMeaasge("error!,unloading and loading  addresses are same");
		
		return rs;
	}
	
	
	
	@ExceptionHandler(InsufficientTruckCapacity.class)
	public ResponseStructure<String> insufficientTruckCapacity(){
		
		ResponseStructure<String> rs =new ResponseStructure<String>();
		
		rs.setData(null);
		rs.setStatuscode(HttpStatus.BAD_GATEWAY.value());
		rs.setMeaasge("insufficent space in truck");
		
		return rs;
	}
	
	
	@ExceptionHandler(CustomerNotFoundExcep.class)
	public ResponseStructure<String> CustomerNotFoundExcep(){
		
		ResponseStructure<String> rs =new ResponseStructure<String>();
		
		rs.setData(null);
		rs.setStatuscode(HttpStatus.BAD_GATEWAY.value());
		rs.setMeaasge("invalid customer");
		
		return rs;
	}
	
 }
