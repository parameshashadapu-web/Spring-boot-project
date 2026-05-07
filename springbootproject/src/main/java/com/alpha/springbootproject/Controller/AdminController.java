	package com.alpha.springbootproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.springbootproject.DTO.PlaceOrderDto;
import com.alpha.springbootproject.DTO.ResponseStructure;
import com.alpha.springbootproject.DTO.SaveAddressDto;
import com.alpha.springbootproject.DTO.SaveCarrierDto;
import com.alpha.springbootproject.DTO.SaveDriverDto;
import com.alpha.springbootproject.DTO.SaveTruckDto;
import com.alpha.springbootproject.Service.AddressService;
import com.alpha.springbootproject.Service.CarrierService;
import com.alpha.springbootproject.Service.DriverService;
import com.alpha.springbootproject.Service.OrderService;
import com.alpha.springbootproject.Service.TruckService;
import com.alpha.springbootproject.entity.Address;
import com.alpha.springbootproject.entity.Carrier;
import com.alpha.springbootproject.entity.Driver;
import com.alpha.springbootproject.entity.Orders;
import com.alpha.springbootproject.entity.Truck;

//import sun.print.resources.serviceui;

@RestController
public class AdminController {

	@Autowired
	private DriverService driverService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired 
	private TruckService truckService;
	
	@Autowired
	private CarrierService carrierService;
	
	@Autowired
     private OrderService orderService;	
	
	//--------------------------SAVE OPERATIONS--------------------------------
	
	@PostMapping("/admin/save/driver")
	public ResponseStructure<Driver> saveDriver(@RequestBody SaveDriverDto driverdto) {
		return driverService.saveDriver(driverdto);
	}
	
	
	@PostMapping("/admin/save/address")
	public ResponseStructure<Address> saveAddress(@RequestBody SaveAddressDto addressdto) {
		return addressService.saveAddress(addressdto);
	}
	
	
	@PostMapping("/admin/save/truck")
	public SaveTruckDto saveTruck(@RequestBody SaveTruckDto truckdto) {
		return truckService.saveTruck(truckdto);
	}
	
	
	@PostMapping("/admin/save/carrier")
	public ResponseStructure<Carrier> savecarrier(@RequestBody SaveCarrierDto carrierDto) {
		
		return carrierService.saveCarrier(carrierDto);
	}
	
	
	//-------------------FIND OPERATIONS--------------------
	
	 @GetMapping("/admin/find/driver")
	 public ResponseStructure<Driver> finddriver(@RequestParam long contact) {
		 return  driverService.findDriverByContact(contact);
	 }
	 
	 
	 
	 @GetMapping("/admin/find/address")
	 public ResponseStructure<Address> findAddress(@RequestParam int pincode) {
		  return addressService.findAddressByPincode(pincode);
	 }
	 
	 @GetMapping("/admin/find/truck")
	 public ResponseStructure<Truck> findTruck(@RequestParam int tnumber) {		 
		return  truckService.findTruckByTruckNumber(tnumber);
		 
	 }
	
	 @GetMapping("/admin/find/carrier")
	 public ResponseStructure<Carrier> findCarrier(@RequestParam long contact) {
		return carrierService.findCarrierByContact(contact);
	 }
	 
	 
	 
	 //---------------------FIND ALL------------------------//
	 
	 @GetMapping("/admin/findall/drivers")
	 public ResponseStructure<List<Driver>> findAllDrivers() {
		return  driverService.findAllDrivers();
	 }
	 
	 @GetMapping("/admin/findall/address")
	 public ResponseStructure<List<Address>> findAllAddress() {
		 return  addressService.findAllAddress();
	 }
	 
	 @GetMapping("/admin/findall/trucks")
	 public ResponseStructure<List<Truck>> findAllTrucks() {
		return truckService.findAllTrucks();
	 }
	 
	 @GetMapping("/admin/findall/carriers")
	 public ResponseStructure<List<Carrier>> findAllCarriers() {
		 return  carrierService.findAllCarriers();
	 }
	 
	 
	 
	 //===============DELETE OPERATIONS===================//
	 
	 @GetMapping("/admin/delete/driver")
	 public ResponseStructure<Driver> deleteDriver(@RequestParam int id) {
		 
		return driverService.deleteDriver(id);
		 
	 }
	 
	 
	 
	 @GetMapping("/admin/delete/truck")
	 public ResponseStructure<Truck> deleteTruck(@RequestParam int id) {
		 
		return truckService.deleteTruck(id);
	 }
	 
	 
	 
	 @GetMapping("/admin/delete/carrier")
	 public ResponseStructure<Carrier> deleteCarrier(@RequestParam int id) {
		 
		return carrierService.deleteCarrier(id);
	 }
	
	 
	 @GetMapping("/admin/delete/address")
	 public ResponseStructure<Address> deleteAddress(@RequestParam int id) {
		 
		return addressService.deleteAddress(id);
	 }
	
	 
	 //=====================placeorder==	=============================//
	 @PostMapping("/admin/placeorder")
	 public ResponseStructure<Orders> placeorder(@RequestBody PlaceOrderDto orderDto) {
		   return orderService.placeOrder(orderDto);
	 }
	 
	 @GetMapping("/admin/findallorders")
	 public List<Orders> findAllOrders(){	
		 return orderService.findAllOrders();
	 }
	 

	 
	 //========assigning carrier and truck to a driver=========//
	 
	 @PatchMapping("/admin/assigncarrietandtrucktodriver")
	 public ResponseStructure<Driver>  assignTruckCarrier(@RequestParam int truckId, @RequestParam int driverId,@RequestParam int carrierId) {

		   return driverService.assigncarrietandtrucktodriver(driverId,truckId,carrierId);
	 }

	 
	 //================assigning carrier to order============//
	 
	 

		@PatchMapping("/admin/update/order/assigncarrier")
		public ResponseStructure<Orders> assignCarriertorder(@RequestParam int orderId, @RequestParam int truckId) {
			return orderService.assignCarriertoOrder(orderId,truckId);
		}
		
		
		//================update loading========================//
		@PatchMapping("/admin/update/order/updateloading")
		public ResponseStructure<Orders> updateLoading(@RequestParam int orderId,String date) {
			return orderService.updateLoading(orderId,date);
		}
		
		
		
        //============update unloading=========================//		
		

		@PatchMapping("/admin/update/order/updateunloading")
		public ResponseStructure<Orders> updateUnloading(@RequestParam int orderId,String date) {
			return orderService.updateUnloading(orderId,date);
		}
		
		
	 
		
		//================save customer======================//
}
