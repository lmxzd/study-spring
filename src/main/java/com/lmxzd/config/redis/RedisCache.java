package com.lmxzd.config.redis;

import com.lmxzd.cache.service.IManualCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author zhangD
 * @since 2024/8/12
 */
@Service
@EnableCaching
public class RedisCache implements IManualCache<String, Object> {

	private RedisTemplate<Object, Object> redisTemplate;

	@Autowired
	public RedisCache(RedisTemplate<Object, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public Object get(String key) {
		return null;
	}

	@Override
	public void set(String key, Object value) {

	}

	@Override
	public void expire(String key) {

	}

	@Override
	public Object hget(String key, String field) {
		return null;
	}

	@Override
	public void hset(String key, String field, Object value) {

	}

	@Override
	public void hdel(String key, String field) {

	}

	@Override
	public void hdel(String key) {

	}

	@Override
	public Object getSet(String key, Object value) {
		return null;
	}
}
