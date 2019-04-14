package com.alten.vehicle;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.alten.pingservice.service.PingService;
import com.alten.pingservice.service.impl.PingServiceImpl;

/**
 * @author sachini
 *
 */
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application-test.properties")
public class PingStatusTest {
	
	@Test
	public void testReturns1or0() {
		PingService pingService = new PingServiceImpl();
		int num = 0;
		for (int i=0; i< 20; i++) {
			num = pingService.pingVehicles("ABC123", "9000");
			assertTrue(num==1 || num ==0);

		}
	}
}
