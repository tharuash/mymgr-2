package com.b127.mm.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.b127.mm.entity.OrderStatus;
import com.b127.mm.entity.OrderedProducts;

public class OrderDto {

	private Long id;
	private List<OrderedProducts> orderProducts;
	private double productAmount;
	private LocalDate orderExpirationDate;
	private LocalDate orderStartDate;
	private LocalTime orderStartTime;
	private double totalPrice;
	private String currencyType;
	private OrderStatus orderStatus;
	private String orderLocation;
	private boolean sellerConfirmation;
	private boolean buyerConfirmation;

	public OrderDto() {

	}

	public OrderDto(Long id, List<OrderedProducts> orderProducts, double productAmount, LocalDate orderExpirationDate,
			LocalDate orderStartDate, LocalTime orderStartTime, double totalPrice, String currencyType,
			OrderStatus orderStatus, String orderLocation, boolean sellerConfirmation,
			boolean buyerConfirmation) {
		super();
		this.id = id;
		this.orderProducts = orderProducts;
		this.productAmount = productAmount;
		this.orderExpirationDate = orderExpirationDate;
		this.orderStartDate = orderStartDate;
		this.orderStartTime = orderStartTime;
		this.totalPrice = totalPrice;
		this.currencyType = currencyType;
		this.orderStatus = orderStatus;
		this.orderLocation = orderLocation;
		this.sellerConfirmation = sellerConfirmation;
		this.buyerConfirmation = buyerConfirmation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<OrderedProducts> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderedProducts> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public double getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(double productAmount) {
		this.productAmount = productAmount;
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
	
	public boolean getSellerConfirmation() {
		return sellerConfirmation;
	}

	public void setSellerConfirmation(boolean sellerConfirmation) {
		this.sellerConfirmation = sellerConfirmation;
	}

	public boolean getBuyerConfirmation() {
		return buyerConfirmation;
	}

	public void setBuyerConfirmation(boolean buyerConfirmation) {
		this.buyerConfirmation = buyerConfirmation;
	}

}
