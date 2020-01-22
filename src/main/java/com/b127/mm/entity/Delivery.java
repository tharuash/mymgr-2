package com.b127.mm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "deliveries")
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private Order order;

	private double deliveryCost;
	private String currencyType;
	private String destinationAddress;

	private DeliveryType deliveryType;

	private boolean isDeliveryComplete;

	public Delivery() {

	}

	public Delivery(Long id, Order order, double deliveryCost, String currencyType, String destinationAddress,
			DeliveryType deliveryType, boolean isDeliveryComplete) {
		super();
		this.id = id;
		this.order = order;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
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

	public boolean isDeliveryComplete() {
		return isDeliveryComplete;
	}

	public void setDeliveryComplete(boolean isDeliveryComplete) {
		this.isDeliveryComplete = isDeliveryComplete;
	}

}
