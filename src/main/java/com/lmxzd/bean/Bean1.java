package com.lmxzd.bean;

/**
 * @author zhangD
 * @since 2024/7/5
 */
public class Bean1 {
	private String field1;

	public Bean1(String field1) {
		this.field1 = field1;
	}

	public Bean1() {
	}

	@Override
	public String toString() {
		return "Bean1{" +
				       "field1='" + field1 + '\'' +
				       '}';
	}
}
