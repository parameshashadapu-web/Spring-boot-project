package com.alpha.springbootproject.DTO;

import java.util.List;

import com.alpha.springbootproject.entity.Orders;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

public class CustomerDto {

	private String name;
	private String email;
	@Column(unique = true)
	private long mobilno;
	private int age;
	
	@OneToMany
	private List<Orders> orders;

	public CustomerDto(String name, String email, long mobilno, int age, List<Orders> orders) {
		super();
		this.name = name;
		this.email = email;
		this.mobilno = mobilno;
		this.age = age;
		this.orders = orders;
	}

	public CustomerDto() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobilno() {
		return mobilno;
	}

	public void setMobilno(long mobilno) {
		this.mobilno = mobilno;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "CustomerDto [name=" + name + ", email=" + email + ", mobilno=" + mobilno + ", age=" + age + ", orders="
				+ orders + "]";
	}
	
	

}
