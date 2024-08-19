package com.lmxzd.eventMechanism;

import com.lmxzd.bean.Bean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zhangD
 * @since 2024/7/5
 */
@Component
public class SomeComponent {
	private ApplicationEventPublisher publisher;

	private Bean1 bean1;

	public SomeComponent(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	@Resource
	public void setBean1(Bean1 bean1) {
		this.bean1 = bean1;
	}

	@Scheduled(cron = "* * * * * ?")
	public void someMethod() {
		// 业务逻辑...

		// 创建自定义事件
		CustomEvent event = new CustomEvent(this, "自定义消息内容");
		System.out.println(bean1);

		// 发布事件
		publisher.publishEvent(event);
	}
}