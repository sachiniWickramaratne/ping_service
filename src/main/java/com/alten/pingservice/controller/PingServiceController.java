package com.alten.pingservice.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.alten.RPC.CustomerRPCService;
import com.alten.dto.VehicleDetailsDTO;
import com.alten.pingservice.service.PingService;

/**
 * @author sachini
 *
 */
@Controller
public class PingServiceController {

    private static final String URL = "/vehicle/broadcaster";
    
    @Autowired
    SimpMessagingTemplate template;

    @Autowired
    CustomerRPCService customerRPCService;
    
    @Autowired
    PingService pingService;
    
    @SubscribeMapping(URL)
    public String onSubscribe() {
        return "SUBSCRIBED";
    }

    @Scheduled(fixedRate = 10000)
    public void sendMessage() {
    	try {
    		Collection<VehicleDetailsDTO> details= customerRPCService.getVehicleDetails();
    	
	    	details.forEach((vehicle)->{
	    		Map<String, Object> headers = new HashMap<>();
	        	headers.put("regNo", vehicle.getRegistrationNo());
	        	int status = pingService.pingVehicles(vehicle.getRegistrationNo(),vehicle.getAddress());
	            template.convertAndSend(URL, status, headers);
	            
	            pingService.setJedis(vehicle.getRegistrationNo(), status);
	    	});
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
        
}
