package com.b127.mm.dto;

import com.b127.mm.entity.DeliveryType;

public class DeliveryDto {

	private Long id;
	private Long orderId;
	private double deliveryCost;
	private String currencyType;
	private String destinationAddress;
	private DeliveryType deliveryType;
	private boolean isDeliveryComplete;

	public DeliveryDto() {

	}

	public DeliveryDto(Long id, Long orderId, double deliveryCost, String currencyType, String destinationAddress,
			DeliveryType deliveryType, boolean isDeliveryComplete) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.deliveryCost = deliveryCost;
		this.currencyType = currencyType;
		this.destinationAddress = destinationAddress;
		this.deliveryType = deliveryType;
		this.isDeliveryComplete = isDeliveryComplete;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public double getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(double deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public String getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	public DeliveryType getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(DeliveryType deliveryType) {
		this.deliveryType = deliveryType;
	}

	public boolean getIsDeliveryComplete() {
		return isDeliveryComplete;
	}

	public void setIsDeliveryComplete(boolean isDeliveryComplete) {
		this.isDeliveryComplete = isDeliveryComplete;
	}

}
