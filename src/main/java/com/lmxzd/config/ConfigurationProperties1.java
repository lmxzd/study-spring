package com.lmxzd.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhangD
 * @since 2024/7/7
 */
@ConfigurationProperties(prefix = "zd")
public class ConfigurationProperties1 {
	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
