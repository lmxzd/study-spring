package com.lmxzd.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author zhangD
 * @since 2024/7/11
 */
@Component
public class SpringLoadOrder2 implements BeanPostProcessor{
	private static final Logger log = LoggerFactory.getLogger(SpringLoadOrder2.class);



	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		log.error("启动顺序:BeanPostProcessor postProcessBeforeInitialization beanName:{}", beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		log.error("启动顺序:BeanPostProcessor postProcessAfterInitialization beanName:{}", beanName);
		return bean;
	}


}
