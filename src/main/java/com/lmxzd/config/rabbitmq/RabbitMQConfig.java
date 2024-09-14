package com.lmxzd.config.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangD
 * @since 2024/8/22
 */
@EnableRabbit
@Configuration
public class RabbitMQConfig implements BeanFactoryAware, RabbitTemplate.ReturnCallback, RabbitTemplate.ConfirmCallback {

	private BeanFactory beanFactory;

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
		RabbitTemplate rabbitTemplate = beanFactory.getBean(RabbitTemplate.class);
		rabbitTemplate.setConfirmCallback(this);
		rabbitTemplate.setReturnCallback(this);
	}

	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		System.out.println("成功");
	}

	@Override
	public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
		System.out.println("错误");
	}

	// @Bean
	// public Queue queue1(){
	// 	return new Queue("queue1");
	// }
	//
	// @Bean
	// public Queue queue(){
	// 	return new Queue("queue");
	// }
	//
	// @Bean
	// public TopicExchange exchange() {
	// 	return new TopicExchange("my_exchange");
	// }
	//
	// @Bean
	// public Binding myBinding(Queue queue, TopicExchange exchange) {
	// 	return BindingBuilder.bind(queue).to(exchange).with("my_routing");
	// }
	//
	// @Bean
	// public Binding myBinding2(Queue queue1, TopicExchange exchange) {
	// 	return BindingBuilder.bind(queue1).to(exchange).with("my_routing2");
	// }
}
