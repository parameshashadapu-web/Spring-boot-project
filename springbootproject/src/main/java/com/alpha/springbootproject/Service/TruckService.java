package com.alpha.springbootproject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alpha.springbootproject.DTO.ResponseStructure;
import com.alpha.springbootproject.DTO.SaveDriverDto;
import com.alpha.springbootproject.DTO.SaveTruckDto;
import com.alpha.springbootproject.Repository.AddressRepo;
import com.alpha.springbootproject.Repository.TruckRepo;
import com.alpha.springbootproject.entity.Address;
import com.alpha.springbootproject.entity.Truck;
import com.alpha.springbootproject.exception.TruckAlreadyExists;
import com.alpha.springbootproject.exception.TruckNotFound;

@Service
public class TruckService {

	@Autowired
    TruckRepo truckRepo;
	
	Truck truck=new Truck();
      
//=====================SAVE TRUCK=======================//
	
	public SaveTruckDto saveTruck(SaveTruckDto truckdto) {
		
		Truck truck=new Truck();
	      truck.setTname(truckdto.getTname());
	      truck.setStatus(truckdto.getStatus());
	      truck.setTnumber(truckdto.getTnumber());
	      truck.setCapacity(truckdto.getCapacity());
	      
       	 Truck t= truckRepo.findByTnumber(truck.getTnumber());
	      
       	 ResponseStructure<Truck> rs=new ResponseStructure<Truck>();
       	 
       	 if(t==null) {
       		Truck t1= truckRepo.save(truck);
       		 System.out.println(truck);
       		 rs.setData(t1);
       		 rs.setMeaasge("data entered successfully");
       		 rs.setStatuscode(202);
       		 
       	 }
       	 else {
       		 System.out.println("already this truck exists");
       		 throw new TruckAlreadyExists();
       	 }
	      
		return truckdto;
	}

	
//========================FIND TRUCK===========================//
	
	public ResponseStructure<Truck> findTruckByTruckNumber(int tnumber) {
		
		Truck t=truckRepo.findByTnumber(tnumber);
		ResponseStructure<Truck> rs=new ResponseStructure<Truck>();
		if(t!=null) {
			rs.setData(t);
			rs.setMeaasge("truck found🔥");
			rs.setStatuscode(HttpStatus.ACCEPTED.value());
		}
		else {
			throw new TruckNotFound();
		}
		return rs;
		
	}

	//===================FINDALL TRUCKS==========================//

	public ResponseStructure<List<Truck>> findAllTrucks() {
		
		List<Truck> t=truckRepo.findAll();
		if(t.size()>0) {
			ResponseStructure<List<Truck>> rs=new ResponseStructure<List<Truck>>();
			rs.setStatuscode(HttpStatus.ACCEPTED.value());
			rs.setMeaasge("data found successfully 🔥");
			rs.setData(t);
			
			return rs;
		}
		else {
			throw new TruckNotFound();
		}
		
	}

	
	//====================DELETE TRUCK OPERATON=======================//

	public ResponseStructure<Truck> deleteTruck(int id) {
		
		ResponseStructure<Truck> rs=new ResponseStructure<Truck>();
		Truck t=truckRepo.findById(id).orElseThrow( ()->new TruckNotFound());
		
		if(t!=null) {
			
			truckRepo.deleteById(t.getId());
			rs.setData(t);
			rs.setMeaasge("data deleted successfully");
			rs.setStatuscode(HttpStatus.ACCEPTED.value());			
		}
		
		return rs;
	}


	
}
