package com.alpha.springbootproject.DTO;

public class ResponseStructure<T> {

	
	private int statuscode;
	private String meaasge;
	private T data;
	
	public ResponseStructure(int statuscode, String meaasge, T data) {
		super();
		this.statuscode = statuscode;
		this.meaasge = meaasge;
		this.data = data;
	}

	public ResponseStructure() {
		super();
	}

	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}

	public String getMeaasge() {
		return meaasge;
	}

	public void setMeaasge(String meaasge) {
		this.meaasge = meaasge;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseStructure [statuscode=" + statuscode + ", meaasge=" + meaasge + ", data=" + data + "]";
	}
	
	
}
