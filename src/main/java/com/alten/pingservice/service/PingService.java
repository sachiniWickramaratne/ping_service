package com.alten.pingservice.service;

public interface PingService {

	/**
     * @param regNo
     * @param ip
     * @return 1 0r 0
     * 
     * This method will later be modified to ping an actual ip 
     * 
     */
	public int pingVehicles(String regNo,String ip);
	
	
	/**
	 * 
	 * Persists the current status in Redis temporarily(until next status arrives)
	 * 
     * @param regNo registration number of a vehicle
     * @param status current status of the vehicle : 1 or 0
     */

	public void setJedis(String regNo, int status);
}
