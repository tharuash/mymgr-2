package com.b127.mm.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.b127.mm.entity.OrderStatus;

public class ManualOrderDto {
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
	private List<ManualOrderProductDto> orderedProducts;
	private int noOfProducts;

	public ManualOrderDto() {

	}

	public ManualOrderDto(Long id, LocalDate orderExpirationDate, LocalDate orderStartDate, LocalTime orderStartTime,
			double totalPrice, String currencyType, OrderStatus orderStatus, String orderLocation,
			boolean sellerConfirmation, boolean buyerConfirmation, List<ManualOrderProductDto> orderedProducts) {
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
		this.orderedProducts = orderedProducts;
	}
	
	

	public ManualOrderDto(Long id, LocalDate orderExpirationDate, LocalDate orderStartDate, LocalTime orderStartTime,
			double totalPrice, String currencyType, OrderStatus orderStatus, String orderLocation,
			boolean sellerConfirmation, boolean buyerConfirmation, List<ManualOrderProductDto> orderedProducts,
			int noOfProducts) {
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
		this.orderedProducts = orderedProducts;
		this.noOfProducts = noOfProducts;
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

	public List<ManualOrderProductDto> getOrderedProducts() {
		return orderedProducts;
	}

	public void setOrderedProducts(List<ManualOrderProductDto> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}
	
	public int getNoOfProducts() {
		return noOfProducts;
	}
	
	public void setNoOfProducts(int noOfProducts) {
		this.noOfProducts = noOfProducts;
	}

}
