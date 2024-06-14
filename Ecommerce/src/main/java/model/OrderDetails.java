package model;

public class OrderDetails {
	private String orderId;
	private String userImage;
	private String fullName;
	private String productImage;
	private String productName;
	private String productBrand;
	private String prodctPrice;
	private String orderDate;
	private String orderTime;
	public OrderDetails(String orderId, String userImage, String fullName, String productImage, String productName,
			String productBrand, String prodctPrice, String orderDate, String orderTime) {
		this.orderId = orderId;
		this.userImage = userImage;
		this.fullName = fullName;
		this.productImage = productImage;
		this.productName = productName;
		this.productBrand = productBrand;
		this.prodctPrice = prodctPrice;
		this.orderDate = orderDate;
		this.orderTime = orderTime;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public String getProdctPrice() {
		return prodctPrice;
	}
	public void setProdctPrice(String prodctPrice) {
		this.prodctPrice = prodctPrice;
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
