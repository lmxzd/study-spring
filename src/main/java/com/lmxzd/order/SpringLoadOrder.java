package com.lmxzd.order;


import com.lmxzd.bean.Bean1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
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

import javax.annotation.PostConstruct;
import javax.annotation.Resource;


/**
 * @author zhangD
 * @since 2024/7/10
 */
public class SpringLoadOrder implements ApplicationContextAware, BeanFactoryAware, InitializingBean, SmartLifecycle,
		                                    BeanNameAware, ApplicationListener<ContextRefreshedEvent>,
		                                    CommandLineRunner, SmartInitializingSingleton {
	private static final Logger log = LoggerFactory.getLogger(SpringLoadOrder.class);


	@Resource
	private Bean1 bean1;

	@PostConstruct
	public void postConstruct() {
		log.error("启动顺序:bean1:{}", bean1);
		log.error("启动顺序:post-construct");
	}

	public void initMethod() {
		log.error("启动顺序:init-method");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		log.info("启动顺序:BeanFactoryAware");
	}

	@Override
	public void setBeanName(String name) {
		log.info("启动顺序:BeanNameAware");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("启动顺序:InitializingBean.afterPropertiesSet");
	}

	@Override
	public void afterSingletonsInstantiated() {
		log.info("启动顺序:SmartInitializingSingleton");
	}


	@Override
	public void run(String... args) throws Exception {
		log.info("启动顺序:CommandLineRunner");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		log.info("启动顺序:ApplicationContextAware");
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		log.info("启动顺序:ApplicationListener");
	}

	@Override
	public void start() {
		log.info("启动顺序:SmartLifecycle.start");
	}

	@Override
	public void stop() {
		log.info("启动顺序:SmartLifecycle.stop");
	}

	@Override
	public boolean isRunning() {
		log.info("启动顺序:SmartLifecycle.isRunning");
		return false;
	}

	@Override
	public boolean isAutoStartup() {
		log.info("启动顺序:SmartLifecycle.isAutoStartup");
		return false;
	}

	@Override
	public void stop(Runnable callback) {
		log.info("启动顺序:SmartLifecycle.stop(callback)");
	}

	@Override
	public int getPhase() {
		log.info("启动顺序:SmartLifecycle.getPhase");
		return 0;
	}
}
