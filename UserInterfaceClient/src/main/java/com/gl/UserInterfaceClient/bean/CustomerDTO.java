package com.gl.UserInterfaceClient.bean;

public class CustomerDTO {
	private Long customerId;
	private String name;
	private String address;
	private String contactNo;
	private String email;
	private String status;
	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerDTO(Long customerId, String name, String address, String contactNo, String email, String status) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.contactNo = contactNo;
		this.email = email;
		this.status = status;
	}

	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getaddress() {
		return address;
	}
	public void setaddress(String address) {
		this.address = address;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CustomerId=" + customerId + "\nName=" + name + "\naddress=" + address + ", contactNo="
				+ contactNo + "\nE-mail=" + email + "\nStatus=" + status;
	}
	
	
}
