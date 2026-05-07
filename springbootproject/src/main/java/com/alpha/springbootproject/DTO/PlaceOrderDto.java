	package com.alpha.springbootproject.DTO;

public class PlaceOrderDto {

	String cargoName;
	String cargoDiscription;
	private int cargoCount;
	private double cargoweight;
	private int loadingAddressid;
	private int unloadingAddressid;
	
	
	public String getCargoName() {
		return cargoName;
	}
	public void setCargoName(String cargoName) {
		this.cargoName = cargoName;
	}
	public String getCargoDiscription() {
		return cargoDiscription;
	}
	public void setCargoDiscription(String cargoDiscription) {
		this.cargoDiscription = cargoDiscription;
	}
	public double getCargoweight() {
		return cargoweight;
	}
	public void setCargoweight(double cargoweight) {
		this.cargoweight = cargoweight;
	}
	public int getLoadingAddressid() {
		return loadingAddressid;
	}
	public void setLoadingAddressid(int loadingAddressid) {
		this.loadingAddressid = loadingAddressid;
	}
	public int getUnloadingAddressid() {
		return unloadingAddressid;
	}
	public void setUnloadingAddressid(int unloadingAddressid) {
		this.unloadingAddressid = unloadingAddressid;
	}
	public int getCargoCount() {
		return cargoCount;
	}
	public void setCargoCount(int cargoCount) {
		this.cargoCount = cargoCount;
	}
	public PlaceOrderDto(String cargoName, String cargoDiscription, int cargoCount, double cargoweight,
			int loadingAddressid, int unloadingAddressid) {
		super();
		this.cargoName = cargoName;
		this.cargoDiscription = cargoDiscription;
		this.cargoCount = cargoCount;
		this.cargoweight = cargoweight;
		this.loadingAddressid = loadingAddressid;
		this.unloadingAddressid = unloadingAddressid;
	}
	public PlaceOrderDto() {
		super();
	}
	
	
	
}
