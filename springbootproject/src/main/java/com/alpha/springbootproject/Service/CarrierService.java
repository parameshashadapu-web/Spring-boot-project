package com.alpha.springbootproject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alpha.springbootproject.DTO.ResponseStructure;
import com.alpha.springbootproject.DTO.SaveCarrierDto;
import com.alpha.springbootproject.Repository.CarrierRepo;
import com.alpha.springbootproject.entity.Carrier;
import com.alpha.springbootproject.entity.Driver;
import com.alpha.springbootproject.exception.CarrierAlreadyExists;
import com.alpha.springbootproject.exception.CarrierNotFound;
import com.alpha.springbootproject.exception.DriverNotFound;

@Service
public class CarrierService {

	@Autowired
   private 	CarrierRepo carrierRepo;

	//===================SAVE CARRIER OPERATION======================//
	
   public ResponseStructure<Carrier> saveCarrier(SaveCarrierDto carrierDto) {
	   
	   Carrier carrier=new Carrier();
	   carrier.setContact(carrierDto.getContact());
	   carrier.setEmail(carrierDto.getEmail());
	   carrier.setName(carrierDto.getName());
	   ResponseStructure<Carrier> rss=new ResponseStructure<Carrier>();
		
	   Carrier c=carrierRepo.findByContact(carrierDto.getContact());
	   if(c==null) {
		   	   
		   Carrier c1=carrierRepo.save(carrier);
		   rss.setData(c1);
		   rss.setMeaasge("data entered succesfully");
		   rss.setStatuscode(202);
	   }
	   
	   else {
		   System.out.println("carrier already exists");
		   throw new CarrierAlreadyExists();
	   }
	   
      return rss;
   }

   
   //====================FIND CARRIER OPERATION==================//
   
   public ResponseStructure<Carrier> findCarrierByContact(long contact) {
	   
	   Carrier c=carrierRepo.findByContact(contact);
	   ResponseStructure<Carrier> rs=new ResponseStructure<Carrier>();
	   
	   if(c!=null) {
		 
		   rs.setData(c);
		   rs.setMeaasge("carrier found🔥");
		   rs.setStatuscode(HttpStatus.ACCEPTED.value());
	   }
	   else {
		   throw new CarrierNotFound();
	   }
	   return rs;
   }


   //========================FIND ALL CARRIERS OPERATION====================//
   
   public ResponseStructure<List<Carrier>> findAllCarriers() {

	   List<Carrier> c=carrierRepo.findAll();
	   if(c.size()>0) {
		   ResponseStructure<List<Carrier>> rs=new ResponseStructure<List<Carrier>>();
		   rs.setStatuscode(HttpStatus.ACCEPTED.value());
		   rs.setMeaasge("data found successfully 🔥");
		   rs.setData(c);
		   
		   return rs;
	   }
	   else {
		   throw new CarrierNotFound();
	   }
   }


   //=======================DELETE OPERATION=================//
   
   public ResponseStructure<Carrier> deleteCarrier(int id) {
	
	Carrier c=carrierRepo.findById(id).orElseThrow(()->new CarrierNotFound());
	ResponseStructure<Carrier> rs=new ResponseStructure<Carrier>();
	
	if(c!=null) {
		carrierRepo.deleteById(c.getId());
        rs.setData(c);
        rs.setMeaasge("data delted sucessfully");
        rs.setStatuscode(HttpStatus.OK.value());
        
	}
	
	return rs;
   }
}
