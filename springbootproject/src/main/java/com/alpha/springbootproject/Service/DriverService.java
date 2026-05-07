package com.alpha.springbootproject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alpha.springbootproject.DTO.ResponseStructure;
import com.alpha.springbootproject.DTO.SaveDriverDto;
import com.alpha.springbootproject.Repository.CarrierRepo;
import com.alpha.springbootproject.Repository.DriverRepo;
import com.alpha.springbootproject.Repository.TruckRepo;
import com.alpha.springbootproject.entity.Carrier;
import com.alpha.springbootproject.entity.Driver;
import com.alpha.springbootproject.entity.Truck;
import com.alpha.springbootproject.exception.CarrierNotFound;
import com.alpha.springbootproject.exception.DriverAlreadyExists;
import com.alpha.springbootproject.exception.DriverNotFound;
import com.alpha.springbootproject.exception.TruckNotFound;
@Service
public class DriverService {
	
	@Autowired
	private DriverRepo driverRepo;
	
	@Autowired
	private TruckRepo truckRepo;
	
	@Autowired
	private CarrierRepo carrierRepo;
	
//========================SAVE DRIVER===============================//
	
	public ResponseStructure<Driver> saveDriver(SaveDriverDto driverdto) {
		
		Driver driverToSave=new Driver();
		driverToSave.setName(driverdto.getName());
		driverToSave.setContact(driverdto.getContact());
		
		Driver d=driverRepo.findByContact(driverToSave.getContact());
		
		ResponseStructure<Driver> rs=new ResponseStructure<Driver>();
		
		if(d==null) {
			
		Driver d1=driverRepo.save(driverToSave);
		rs.setData(d1);
		rs.setMeaasge("data entered successfully");
		rs.setStatuscode(202);
		
			System.out.println(driverToSave);
		}
		else {
			System.out.println("driver already exists");
			throw new DriverAlreadyExists();
		}
		return rs;
	}

	
	//=====================FIND==================//
	
    public ResponseStructure<Driver> findDriverByContact(long contact) {
		
		ResponseStructure<Driver> rs=new ResponseStructure<Driver>();
         Driver d=driverRepo.findByContact(contact);
         
     	if(d != null) {
			rs.setStatuscode(HttpStatus.OK.value());
			rs.setMeaasge("Driver Found");
			rs.setData(d);
		}
		else {
			throw new DriverNotFound();
		}
	return rs;
		
	}

    
    //==================FIND ALL====================//

	public ResponseStructure<List<Driver>> findAllDrivers() {
       
	List<Driver> d= driverRepo.findAll();
	if(d.size()>0) {
		ResponseStructure<List<Driver>> rs=new ResponseStructure<List<Driver>>();
		rs.setMeaasge("data found successfully");
		rs.setStatuscode(HttpStatus.ACCEPTED.value());
		rs.setData(d);
		
		return rs;
	}
	else {
		throw new DriverNotFound();
	}
	
	}



	

	
	//=====================DELETE DRIVER OPERATON==========================//
	
	
	public ResponseStructure<Driver> deleteDriver(int id) {
        
		Driver d=driverRepo.findById(id).orElseThrow(()->new DriverNotFound());
		ResponseStructure<Driver> rs=new ResponseStructure<Driver>();
		if(d!=null) {
			driverRepo.deleteById(d.getId());
			
			rs.setData(d);
			rs.setMeaasge("data dleted successfully");
			rs.setStatuscode(HttpStatus.ACCEPTED.value());
		}
		return rs;
	}


	
	//=====assigning carrier and truck to a driver===================//
	public ResponseStructure<Driver> assigncarrietandtrucktodriver(int driverId, int truckId, int carrierId) {
		
		Truck t1=truckRepo.findById(truckId).orElseThrow(()->new TruckNotFound());
		Driver d1=driverRepo.findById(driverId).orElseThrow(()->new DriverNotFound());
		Carrier c1=carrierRepo.findById(carrierId).orElseThrow(()->new CarrierNotFound());
		
		
		d1.setCarrier(c1);
		d1.setTruck(t1);
		


		t1.setCarrier(c1);
           
		driverRepo.save(d1);
		carrierRepo.save(c1);
		truckRepo.save(t1);
		
		ResponseStructure<Driver> rs=new ResponseStructure<Driver>();
		rs.setData(d1);
		rs.setMeaasge("data found successfully");

           
 		rs.setStatuscode(HttpStatus.OK.value());
 		return rs;
	}


	
		
	
}
