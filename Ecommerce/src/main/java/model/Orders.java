package model;


public class Orders {
	private String orderId;
	private String productId;
	private String userId;
	private String orderDate;
	private String orderTime;
	public Orders(String orderId, String productId, String userId, String orderDate, String orderTime) {
		this.orderId = orderId;
		this.productId = productId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.orderTime = orderTime;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	
	
}
