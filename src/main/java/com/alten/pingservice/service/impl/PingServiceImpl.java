package com.alten.pingservice.service.impl;

import org.apache.commons.net.telnet.TelnetClient;
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
		//int randomStatus = (int)(Math.random()*2);
		int port = Integer.parseInt(ip);
    	TelnetClient client = new TelnetClient();
    	client.setConnectTimeout( 5000 );
    	try
        {
            client.connect( "18.216.186.149", port );
            return 1;
        }
        catch ( Exception socketException )
        {
        	//System.out.println("not connected " + port);
        	return 0;
        }

     	//return randomStatus;
	}

	@Override
	public void setJedis(String regNo, int status) {
		try {
    		Jedis jedis = new Jedis(REDIS_HOST, REDIS_PORT);
        	jedis.set(regNo, String.valueOf(status));
        	jedis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
