package com.alpha.springbootproject.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String orderdate;
	private String status;
	private double cost;
	@ManyToOne(cascade = CascadeType.ALL)
	private Carrier carrier;
	@OneToOne (cascade = CascadeType.ALL)
	private Cargo cargo;
	@OneToOne (cascade = CascadeType.ALL)
	private Loading loading;
	@OneToOne  (cascade = CascadeType.ALL)
	private Unloading unloading;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Carrier getCarrier() {
		return carrier;
	}
	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public Loading getLoading() {
		return loading;
	}
	public void setLoading(Loading loading) {
		this.loading = loading;
	}
	public Unloading getUnloading() {
		return unloading;
	}
	public void setUnloading(Unloading unloading) {
		this.unloading = unloading;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderdate=" + orderdate + ", status=" + status + ", cost=" + cost + ", carrier="
				+ carrier + ", cargo=" + cargo + ", loading=" + loading + ", unloading=" + unloading + "]";
	}
	public Orders(String orderdate, String status, double cost, Carrier carrier, Cargo cargo, Loading loading,
			Unloading unloading) {
		super();
		this.orderdate = orderdate;
		this.status = status;
		this.cost = cost;
		this.carrier = carrier;
		this.cargo = cargo;
		this.loading = loading;
		this.unloading = unloading;
	}
	public Orders() {
		super();
	}
	
	
	
	
	
}
