package com.lmxzd.order;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.SmartLifecycle;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author zhangD
 * @since 2024/7/10
 */
@Component
public class SpringLoadOrder implements ApplicationContextAware, BeanFactoryAware, InitializingBean, SmartLifecycle,
		                                    BeanNameAware, ApplicationListener<ContextRefreshedEvent>,
		                                    CommandLineRunner, SmartInitializingSingleton,
		                                    BeanPostProcessor, BeanFactoryPostProcessor {
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("启动顺序:BeanFactoryAware");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("启动顺序:BeanNameAware"+name);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("启动顺序:InitializingBean");
	}

	@Override
	public void afterSingletonsInstantiated() {
		System.out.println("启动顺序:SmartInitializingSingleton");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("启动顺序:BeanFactoryPostProcessor");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("启动顺序:CommandLineRunner");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("启动顺序:ApplicationContextAware");
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("启动顺序:ApplicationListener");
	}

	@Override
	public void start() {
		System.out.println("启动顺序:SmartLifecycle.start");
	}

	@Override
	public void stop() {
		System.out.println("启动顺序:SmartLifecycle.stop");
	}

	@Override
	public boolean isRunning() {
		System.out.println("启动顺序:SmartLifecycle.isRunning");
		return false;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("启动顺序:BeanPostProcessorBefore"+beanName);
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("启动顺序:BeanPostProcessorAfter"+beanName);
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}

	@Override
	public boolean isAutoStartup() {
		System.out.println("启动顺序:SmartLifecycle.isAutoStartup");
		return SmartLifecycle.super.isAutoStartup();
	}

	@Override
	public void stop(Runnable callback) {
		System.out.println("启动顺序:SmartLifecycle.stop(callback)");
		SmartLifecycle.super.stop(callback);
	}

	@Override
	public int getPhase() {
		System.out.println("启动顺序:SmartLifecycle.getPhase");
		return SmartLifecycle.super.getPhase();
	}
}
