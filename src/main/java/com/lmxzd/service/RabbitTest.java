package com.lmxzd.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangD
 * @since 2024/8/22
 */
@Service
public class RabbitTest {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void send() {
		rabbitTemplate.convertAndSend("test", "hello");
	}
}
