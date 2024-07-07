package com.lmxzd.eventMechanism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author zhangD
 * @since 2024/7/5
 */
@Component
public class SomeComponent {
	private ApplicationEventPublisher publisher;

	@Autowired
	public SomeComponent(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	@Scheduled(cron = "* * * * * ?")
	public void someMethod() {
		// 业务逻辑...

		// 创建自定义事件
		CustomEvent event = new CustomEvent(this, "自定义消息内容");

		// 发布事件
		publisher.publishEvent(event);
	}
}