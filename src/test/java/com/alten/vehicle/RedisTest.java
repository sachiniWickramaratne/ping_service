package com.alten.vehicle;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import redis.clients.jedis.Jedis;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application-test.properties")
public class RedisTest {
	@Test
	public void jedisTest() {
		
		Jedis jedis = new Jedis("localhost", 6379);
		jedis.set("test", "setok");
		assertTrue(jedis.get("test").equals("setok"));
		jedis.close();
	}

}
