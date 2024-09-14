package com.lmxzd.eventMechanism.listener;

import com.lmxzd.eventMechanism.CustomEvent;
import org.springframework.beans.BeansException;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author zhangD
 * @since 2024/7/5
 */
@Component
public class CustomEventListener implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@EventListener
	public void onApplicationEvent(CustomEvent event) {
		System.out.println("接收到自定义事件: " + event.getMessage());
		System.out.println(applicationContext.getBean("bean1"));

		CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}