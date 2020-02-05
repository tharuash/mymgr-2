package com.b127.mm.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.b127.mm.entity.OrderStatus;

public class ProductOrderDto {
	private Long id;
	private LocalDate orderStartDate;
	private LocalTime orderStartTime;
	private OrderStatus orderStatus;
	private double requiredQuantity;
	private double subTotal;

	public ProductOrderDto() {

	}

	public ProductOrderDto(Long id, LocalDate orderStartDate, LocalTime orderStartTime,
			OrderStatus orderStatus, double requiredQuantity, double subTotal) {
		super();
		this.id = id;
		this.orderStartDate = orderStartDate;
		this.orderStartTime = orderStartTime;
		this.orderStatus = orderStatus;
		this.requiredQuantity = requiredQuantity;
		this.subTotal = subTotal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public double getRequiredQuantity() {
		return requiredQuantity;
	}

	public void setRequiredQuantity(double requiredQuantity) {
		this.requiredQuantity = requiredQuantity;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

}
