package com.alpha.springbootproject.DTO;

public class SaveTruckDto {

	
	private String tname;
	private int tnumber;
	private double capacity;
	private String status;
	
	public SaveTruckDto(String tname, int tnumber, double capacity, String status) {
		super();
		this.tname = tname;
		this.tnumber = tnumber;
		this.capacity = capacity;
		this.status = status;
	}

	public SaveTruckDto() {
		super();
	}

	@Override
	public String toString() {
		return "SaveTruckDto [tname=" + tname + ", tnumber=" + tnumber + ", capacity=" + capacity + ", status=" + status
				+ "]";
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public int getTnumber() {
		return tnumber;
	}

	public void setTnumber(int tnumber) {
		this.tnumber = tnumber;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
