package com.lmxzd.config.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * @author zhangD
 * @since 2024/8/12
 */
@Configuration
@EnableConfigurationProperties(RedisConfiguration.class)
public class RedisConfig {

	// @Bean
	// @ConditionalOnClass(RedisConnectionFactory.class)
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory);
		template.setKeySerializer(new StringRedisSerializer()); // key序列化工具
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer()); // value序列化工具
		return template;
	}

	// @Bean
	public LettuceConnectionFactory redisConnectionFactory() {
		RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
		redisConfig.setHostName("localhost");
		redisConfig.setPort(6379);
		// redisConfig.setPassword("yourpassword");

		LettucePoolingClientConfiguration.LettucePoolingClientConfigurationBuilder builder =
				LettucePoolingClientConfiguration.builder();

		// 配置连接池属性
		builder.poolConfig(getPoolConfig());
		builder.commandTimeout(Duration.ofSeconds(2));  // 命令超时时间

		LettuceClientConfiguration clientConfig = builder.build();

		return new LettuceConnectionFactory(redisConfig, clientConfig);
	}



	private GenericObjectPoolConfig<?> getPoolConfig() {
		GenericObjectPoolConfig<?> poolConfig = new GenericObjectPoolConfig<>();
		poolConfig.setMaxTotal(8);    // 最大连接数
		poolConfig.setMaxIdle(8);     // 最大空闲连接数
		poolConfig.setMinIdle(1);     // 最小空闲连接数
		poolConfig.setMaxWait(Duration.ofMillis(-1));  // 最大等待时间，-1表示无限制
		return poolConfig;
	}



}
