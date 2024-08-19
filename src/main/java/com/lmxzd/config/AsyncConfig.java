package com.lmxzd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author zhangD
 * @since 2024/7/16
 */
@Configuration
@EnableAsync
public class AsyncConfig extends AsyncConfigurerSupport {

	private final Executor executor;

	public AsyncConfig(Executor executor) {
		this.executor = executor;
	}

	@Override
	public Executor getAsyncExecutor() {
		return executor;
	}

	@Bean
	public Executor executor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(5);  // 核心线程数
		executor.setMaxPoolSize(10);  // 最大线程数
		executor.setQueueCapacity(25);  // 队列容量
		executor.setThreadNamePrefix("CustomExecutor-");

		executor.initialize();
		return executor;
	}
}
