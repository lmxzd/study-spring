package com.lmxzd.cache.service;

/**
 * @author zhangD
 * @since 2024/8/12
 */
public interface IManualCache<K,V> {
	/**
	 * 获取缓存
	 * @param key
	 * @return
	 */
	V get(K key);

	void set(K key, V value);

	void expire(K key);

	V hget(K key, String field);

	void hset(K key, String field, V value);

	void hdel(K key, String field);

	void hdel(K key);

	V getSet(K key, V value);

}
