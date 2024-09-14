package com.lmxzd.entity;

/**
 * @author zhangD
 * @since 2024/8/29
 */
public class OrderInfo {
	private String address;

	private String productName;

	private String orderId;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "OrderInfo{" +
				       "address='" + address + '\'' +
				       ", productName='" + productName + '\'' +
				       ", orderId='" + orderId + '\'' +
				       '}';
	}
}
