package com.lmxzd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author zhangD
 * @since 2024/8/12
 */
@Service
public class RedisTest {

	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;


	@Scheduled(cron = "0/5 * * * * ?")
	private void test() {
		redisTemplate.opsForValue().set("test","1");
		System.out.println(redisTemplate.opsForValue().get("test"));
	}
}
