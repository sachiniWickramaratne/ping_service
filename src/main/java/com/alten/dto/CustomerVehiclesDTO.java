package com.alten.dto;

/**
 * @author sachini
 *
 */
public class CustomerVehiclesDTO {
	private String name;
	private String vehicleId;
	private String registrationNo;
	private int status;
	
	public CustomerVehiclesDTO(String name, String vehicleId, String registrationNo){
		this.name=name;
		this.registrationNo=registrationNo;
		this.vehicleId=vehicleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
