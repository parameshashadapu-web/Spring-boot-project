package com.alpha.springbootproject.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cargo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String discription;
	private double weight;
	private int count;
	public Cargo(String name, String discription, double weight, int count) {
		super();
		this.name = name;
		this.discription = discription;
		this.weight = weight;
		this.count = count;
	}
	public Cargo() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Cargo [id=" + id + ", name=" + name + ", discription=" + discription + ", weight=" + weight + ", count="
				+ count + "]";
	}
	
	
	
	
}
