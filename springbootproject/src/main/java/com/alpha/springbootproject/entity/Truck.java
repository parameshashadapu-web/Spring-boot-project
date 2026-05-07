package com.alpha.springbootproject.entity;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
@Entity
public class Truck {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String tname;
	private int tnumber;
	private double capacity;
	private String status;
	@OneToOne
	private  Carrier carrier;
	
	public Truck(String tname, int tnumber, double capacity, String status, Carrier carrier) {
		super();
		this.tname = tname;
		this.tnumber = tnumber;
		this.capacity = capacity;
		this.status = status;
		this.carrier = carrier;
	}

	public Truck() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	@Override
	public String toString() {
		return "Truck [id=" + id + ", tname=" + tname + ", tnumber=" + tnumber + ", capacity=" + capacity + ", status="
				+ status + ", carrier=" + carrier + "]";
	}
	
	
	
	
	
	
	
	
}
