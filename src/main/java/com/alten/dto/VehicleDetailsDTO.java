package com.alten.dto;

import java.io.Serializable;

/**
 * @author sachini
 *
 */
public class VehicleDetailsDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String registrationNo;
	private String address;
	
	
	public VehicleDetailsDTO(String registrationNo, String address) {
		this.registrationNo=registrationNo;
		this.address=address;
	}
			
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
