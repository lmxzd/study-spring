package com.lmxzd.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author zhangD
 * @since 2024/7/11
 */
@Component
public class SpringLoadOrder3 implements BeanFactoryPostProcessor {
	private static final Logger log = LoggerFactory.getLogger(SpringLoadOrder3.class);

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		log.error("启动顺序:BeanFactoryPostProcessor postProcessBeanFactory ");
	}
}
