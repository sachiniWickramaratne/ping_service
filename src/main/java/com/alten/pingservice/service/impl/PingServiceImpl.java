package com.alten.pingservice.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alten.pingservice.service.PingService;

import redis.clients.jedis.Jedis;

@Service
public class PingServiceImpl implements PingService{

	@Value("${spring.redis.host}")
	private String REDIS_HOST;

	@Value("${spring.redis.port}")
	private int REDIS_PORT;
	    
	    
	@Override
	public int pingVehicles(String regNo, String ip){
		int randomStatus = (int)(Math.random()*2);
    	System.out.println(randomStatus);
     	return randomStatus;
	}

	@Override
	public void setJedis(String regNo, int status) {
		try {
    		Jedis jedis = new Jedis(REDIS_HOST, REDIS_PORT);
        	jedis.set(regNo, String.valueOf(status));
        	jedis.close();
		} catch (Exception e) {
			//log error 
			e.printStackTrace();
		}
	}

}
