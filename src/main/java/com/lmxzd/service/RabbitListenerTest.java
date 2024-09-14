package com.lmxzd.service;

import com.google.gson.Gson;
import com.lmxzd.entity.OrderInfo;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author zhangD
 * @since 2024/8/29
 */
@Service
@Slf4j
public class RabbitListenerTest {

	private static final String EXCHANGE_NAME = "my_exchange";
	private static final String QUEUE_NAME = "my_queue";
	private static final String ROUTING_KEY = "my_routing";

	@RabbitListener(bindings = {@QueueBinding(value = @Queue(value = QUEUE_NAME, durable = "true"),
			exchange = @Exchange(value = EXCHANGE_NAME, type = "topic", durable = "true"), key = ROUTING_KEY)})
	public void handleMessage(Message message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
		log.info("接收到消息:{},deliveryTag:{}", new String(message.getBody(), StandardCharsets.UTF_8), tag);
		channel.basicAck(tag, false);
	}


	@RabbitListener(queues = "queue")
	public void handleMessage2(Message message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
		OrderInfo orderInfo = new Gson().fromJson(new String(message.getBody(), StandardCharsets.UTF_8), OrderInfo.class);
		log.info(orderInfo.toString());
		channel.basicAck(tag, false);
	}
}
