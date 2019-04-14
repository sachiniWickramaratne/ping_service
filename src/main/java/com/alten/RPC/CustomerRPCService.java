package com.alten.RPC;

import java.util.Collection;

import com.alten.dto.VehicleDetailsDTO;

/**
 * @author sachini
 *
 */
public interface CustomerRPCService {
	public Collection<VehicleDetailsDTO> getVehicleDetails()throws Exception;

}
