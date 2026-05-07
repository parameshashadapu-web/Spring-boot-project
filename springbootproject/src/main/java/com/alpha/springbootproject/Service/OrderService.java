package com.alpha.springbootproject.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alpha.springbootproject.DTO.PlaceOrderDto;
import com.alpha.springbootproject.DTO.ResponseStructure;
import com.alpha.springbootproject.Repository.AddressRepo;
import com.alpha.springbootproject.Repository.OrderRepo;
import com.alpha.springbootproject.Repository.TruckRepo;
import com.alpha.springbootproject.entity.Address;
import com.alpha.springbootproject.entity.Cargo;
import com.alpha.springbootproject.entity.Loading;
import com.alpha.springbootproject.entity.Orders;
import com.alpha.springbootproject.entity.Truck;
import com.alpha.springbootproject.entity.Unloading;
import com.alpha.springbootproject.exception.AddressAlreadyExists;
import com.alpha.springbootproject.exception.AddressNotFound;
import com.alpha.springbootproject.exception.InsufficientTruckCapacity;
import com.alpha.springbootproject.exception.LoadAndUnloadAdressMatch;
import com.alpha.springbootproject.exception.TruckNotFound;

@Service
public class OrderService {
	
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private AddressRepo addressRepo;
	
	
	@Autowired
	private TruckRepo truckRepo;
	
	//==================place order===============//

	public ResponseStructure<Orders> placeOrder(PlaceOrderDto orderDto) {

		Orders orders=new Orders();
		orders.setOrderdate(LocalDate.now().toString());
		
		Cargo cargo = new Cargo();
		cargo.setCount(orderDto.getCargoCount());
		cargo.setDiscription(orderDto.getCargoDiscription());
		cargo.setName(orderDto.getCargoName());
		cargo.setWeight(orderDto.getCargoweight());
		
		orders.setCargo(cargo);
		
		
		Loading loading=new Loading();
		Address addressLoading=addressRepo.findById(orderDto.getLoadingAddressid()).orElseThrow(()->new AddressAlreadyExists());
	    loading.setAddress(addressLoading);
	    
	    Unloading unloading=new Unloading();
	    Address addressunloading=addressRepo.findById(orderDto.getUnloadingAddressid()).orElseThrow(()->new AddressNotFound());
	    unloading.setAddress(addressunloading);
	   
	    if(loading.getAddress().getId()!=unloading.getAddress().getId())
	    {
	    	     orders.setLoading(loading);
	    	     orders.setUnloading(unloading);
	    }
	    else {
	    	   
	    	      throw new LoadAndUnloadAdressMatch();
	    	
	    }
	    
	    double cost=0;
	    cost=orderDto.getCargoweight()*orderDto.getCargoCount()*10;
	    orders.setCost(cost);
	    
	    orderRepo.save(orders);
	    
	    ResponseStructure<Orders> rs=new ResponseStructure<Orders>();
	    rs.setData(orders);
	    rs.setMeaasge("order saved");
	    rs.setStatuscode(HttpStatus.ACCEPTED.value());
		
	    return rs;
	}
	
	
	//============findall orders===================//

	public List<Orders> findAllOrders() {
	
		List<Orders> o= orderRepo.findAll();
		ResponseStructure<List<Orders>> rs=new ResponseStructure<List<Orders>>();
		if(o.size()>0) {
			rs.setData(o);
			rs.setMeaasge("data found succesfully");
			rs.setStatuscode(HttpStatus.ACCEPTED.value());
			
		}
		return o;
		
	}
	
	
//===============assignin carrier to order================//
	
public ResponseStructure<Orders> assignCarriertoOrder(int orderId, int truckId) {
Orders o=orderRepo.findById(orderId).orElseThrow(()->new AddressNotFound());
Truck t=truckRepo.findById(truckId).orElseThrow(()->new TruckNotFound());
ResponseStructure<Orders> rs=new ResponseStructure<Orders>();
double weight=o.getCargo().getWeight();
if(t.getCapacity()>=weight) {
	o.setCarrier(t.getCarrier());
	o.setStatus("Confirmed");
	t.setCapacity(t.getCapacity()-weight);
	orderRepo.save(o);
	truckRepo.save(t);	
	rs.setData(o);
	rs.setMeaasge("carrier assigned");
	rs.setStatuscode(200);
	
	
}else {
	throw new InsufficientTruckCapacity();
}
return rs;
	
}

//===============update loading=====================//

public ResponseStructure<Orders> updateLoading(int orderId,String date) {
	Orders o=orderRepo.findById(orderId).orElseThrow(()->new AddressNotFound());
	o.getLoading().setDate(date);
	o.setStatus("On the way");
	orderRepo.save(o);
	ResponseStructure<Orders> rs=new ResponseStructure<Orders>();
	rs.setData(o);
	rs.setMeaasge("Loading details Updated");
	rs.setStatuscode(200);
	return rs;
}


//===================update unloading======================//


public ResponseStructure<Orders> updateUnloading(int orderId, String date) {
	Orders o=orderRepo.findById(orderId).orElseThrow(()->new AddressNotFound());
	o.getUnloading().setDate(date);
	o.setStatus("Delivered");
	orderRepo.save(o);
	ResponseStructure<Orders> rs=new ResponseStructure<Orders>();
	rs.setData(o);
	rs.setMeaasge("Unloading details Updated");
	rs.setStatuscode(200);
	return rs;

}

	

}
