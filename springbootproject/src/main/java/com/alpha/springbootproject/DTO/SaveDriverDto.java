package com.alpha.springbootproject.DTO;

public class SaveDriverDto{
	

	private String name;
	private long contact;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public SaveDriverDto(String name, long contact) {
		super();
		this.name = name;
		this.contact = contact;
	}
	public SaveDriverDto() {
		super();
	}
	@Override
	public String toString() {
		return "DriverDTO [name=" + name + ", contact=" + contact + "]";
	}
	
	
	

}
