package com.lmxzd.config;

import com.lmxzd.bean.Bean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * @author zhangD
 * @since 2024/7/5
 */
@Configuration
@EnableScheduling
public class ConfigurationConfig {
	@Bean
	public Bean2 bean2() {
		return new Bean2();
	}
}
