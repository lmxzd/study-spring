package com.lmxzd.eventMechanism;

import org.springframework.context.ApplicationEvent;

/**
 * @author zhangD
 * @since 2024/7/5
 */
public class CustomEvent extends ApplicationEvent {
	private final String message;

	public CustomEvent(Object source, String message) {
		super(source);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}