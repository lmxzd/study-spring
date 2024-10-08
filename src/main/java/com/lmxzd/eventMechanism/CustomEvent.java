package com.lmxzd.eventMechanism;

import org.springframework.context.ApplicationEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author zhangD
 * @since 2024/7/5
 */
@Async
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