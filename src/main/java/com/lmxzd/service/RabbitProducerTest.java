package com.lmxzd.service;

import com.google.gson.Gson;
import com.lmxzd.entity.OrderInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @author zhangD
 * @since 2024/8/22
 */
@Service
@Slf4j
public class RabbitProducerTest {

	private static final String EXCHANGE_NAME = "my_exchange";
	private static final String ROUTING_KEY = "my_routing";

	@Autowired
	private RabbitTemplate rabbitTemplate;

	/**
	 * 正常发送并被broker接收
	 * @return
	 */
	@Scheduled(cron = "0/5 * * * * ?")
	public String send() {
		for (int i = 0; i < 10; i++) {
			OrderInfo orderInfo = new OrderInfo();
			orderInfo.setAddress("成都市高新区");
			orderInfo.setOrderId(String.valueOf(i));
			orderInfo.setProductName("华为P60:" + i);

			//设置回调关联的一个id
			String messageId = UUID.randomUUID().toString();
			log.info("开始发送消息，当前消息关联id为：{}", messageId);
			CorrelationData correlationData = new CorrelationData(messageId);

			MessageProperties messageProperties = new MessageProperties();
			messageProperties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
			Message message = MessageBuilder.withBody(new Gson().toJson(orderInfo).getBytes(StandardCharsets.UTF_8))
					                  .andProperties(messageProperties).build();
			rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, message, correlationData);
		}
		return "ok";
	}

	/**
	 * 设置一个非法的路由键，模拟消息被broker退回的情况，前提是
	 * spring.rabbitmq.template.mandatory=true 当mandatory设置为true时，交换器无法根据自身的类型和路由键找到一个符合条件的队列，那么RabbitMQ会调用Basic.Return命令将消息返回给生产者。当为false时，则直接丢弃消息
	 * <p>
	 * spring.rabbitmq.publisher-returns=true 生产者回调确认机制，由回调来确定消息是否发布成功
	 *
	 * @return
	 */
	@Scheduled(cron = "0/5 * * * * ?")
	public String sendAndReturn() {
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setAddress("成都市高新区");
		orderInfo.setOrderId("111");
		orderInfo.setProductName("小米13");

		//设置回调关联的一个id
		String messageId = UUID.randomUUID().toString();
		log.info("开始发送消息，当前消息关联id为：{}", messageId);
		CorrelationData correlationData = new CorrelationData(messageId);

		MessageProperties messageProperties = new MessageProperties();
		messageProperties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
		Message message = MessageBuilder.withBody(new Gson().toJson(orderInfo).getBytes(StandardCharsets.UTF_8))
				                  .andProperties(messageProperties).build();

		//下面这个RoutingKey是没有绑定的，所以发不出去
		rabbitTemplate.convertAndSend(EXCHANGE_NAME, "error.routing", message, correlationData);
		return "ok";
	}
}
