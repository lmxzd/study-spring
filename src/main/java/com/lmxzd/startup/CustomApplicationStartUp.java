package com.lmxzd.startup;

import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.core.metrics.ApplicationStartup;
import org.springframework.core.metrics.StartupStep;

import java.util.Collections;
import java.util.Iterator;
import java.util.function.Supplier;

/**
 * 可以通过这个大致打印一点内容。
 */
public class CustomApplicationStartUp extends BufferingApplicationStartup {
	/**
	 * Create a new buffered {@link ApplicationStartup} with a limited capacity and starts
	 * the recording of steps.
	 *
	 * @param capacity the configured capacity; once reached, new steps are not recorded.
	 */
	public CustomApplicationStartUp(int capacity) {
		super(capacity);
	}

	@Override
	public StartupStep start(String name) {
		StartupStep start = super.start(name);
		// System.out.println(start.getName());
		return start;
	}
}
