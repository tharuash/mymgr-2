package com.b127.mm.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.b127.mm.entity.OrderStatus;

public class OnlineOrderDto {
	private Long id;
	private LocalDate orderExpirationDate;
	private LocalDate orderStartDate;
	private LocalTime orderStartTime;
	private double totalPrice;
	private String currencyType;
	private OrderStatus orderStatus;
	private String orderLocation;
	private boolean sellerConfirmation;
	private boolean buyerConfirmation;
	private ProductDto productDto;
	private Long orderProductId;
	private double requiredQuantity;
	private UserDto userDto;
	private String cancellation;
	// private StockDto stockDto;

	public OnlineOrderDto() {

	}

	public OnlineOrderDto(Long id, LocalDate orderExpirationDate, LocalDate orderStartDate, LocalTime orderStartTime,
			double totalPrice, String currencyType, OrderStatus orderStatus, String orderLocation,
			boolean sellerConfirmation, boolean buyerConfirmation, ProductDto productDto, Long orderProductId, double requiredQuantity, String cancellation) {
		super();
		this.id = id;
		this.orderExpirationDate = orderExpirationDate;
		this.orderStartDate = orderStartDate;
		this.orderStartTime = orderStartTime;
		this.totalPrice = totalPrice;
		this.currencyType = currencyType;
		this.orderStatus = orderStatus;
		this.orderLocation = orderLocation;
		this.sellerConfirmation = sellerConfirmation;
		this.buyerConfirmation = buyerConfirmation;
		this.productDto = productDto;
		this.orderProductId = orderProductId;
		this.requiredQuantity = requiredQuantity;
		this.cancellation = cancellation;
	}
	
	
	public OnlineOrderDto(Long id, LocalDate orderExpirationDate, LocalDate orderStartDate, LocalTime orderStartTime,
			double totalPrice, String currencyType, OrderStatus orderStatus, String orderLocation,
			boolean sellerConfirmation, boolean buyerConfirmation, ProductDto productDto, Long orderProductId,
			double requiredQuantity, UserDto userDto, String cancellation) {
		super();
		this.id = id;
		this.orderExpirationDate = orderExpirationDate;
		this.orderStartDate = orderStartDate;
		this.orderStartTime = orderStartTime;
		this.totalPrice = totalPrice;
		this.currencyType = currencyType;
		this.orderStatus = orderStatus;
		this.orderLocation = orderLocation;
		this.sellerConfirmation = sellerConfirmation;
		this.buyerConfirmation = buyerConfirmation;
		this.productDto = productDto;
		this.orderProductId = orderProductId;
		this.requiredQuantity = requiredQuantity;
		this.userDto = userDto;
		this.cancellation = cancellation;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getOrderExpirationDate() {
		return orderExpirationDate;
	}

	public void setOrderExpirationDate(LocalDate orderExpirationDate) {
		this.orderExpirationDate = orderExpirationDate;
	}

	public LocalDate getOrderStartDate() {
		return orderStartDate;
	}

	public void setOrderStartDate(LocalDate orderStartDate) {
		this.orderStartDate = orderStartDate;
	}

	public LocalTime getOrderStartTime() {
		return orderStartTime;
	}

	public void setOrderStartTime(LocalTime orderStartTime) {
		this.orderStartTime = orderStartTime;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderLocation() {
		return orderLocation;
	}

	public void setOrderLocation(String orderLocation) {
		this.orderLocation = orderLocation;
	}

	public boolean isSellerConfirmation() {
		return sellerConfirmation;
	}

	public void setSellerConfirmation(boolean sellerConfirmation) {
		this.sellerConfirmation = sellerConfirmation;
	}

	public boolean isBuyerConfirmation() {
		return buyerConfirmation;
	}

	public void setBuyerConfirmation(boolean buyerConfirmation) {
		this.buyerConfirmation = buyerConfirmation;
	}

	public ProductDto getProductDto() {
		return productDto;
	}

	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}
	
	public Long getOrderProductId() {
		return orderProductId;
	}
	
	public void setOrderProductId(Long orderProductId) {
		this.orderProductId = orderProductId;
	}
	
	public double getRequiredQuantity() {
		return requiredQuantity;
	}
	
	public void setRequiredQuantity(double requiredQuantity) {
		this.requiredQuantity = requiredQuantity;
	}
	
	public UserDto getUserDto() {
		return userDto;
	}
	
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	
	public String getCancellation() {
		return cancellation;
	}
	
	public void setCancellation(String cancellation) {
		this.cancellation = cancellation;
	}

}
