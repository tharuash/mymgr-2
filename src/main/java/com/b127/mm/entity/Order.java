package com.b127.mm.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "seller_id", referencedColumnName = "id")
	private User seller;

	@OneToMany(mappedBy = "order")
	List<OrderedProducts> orderProducts;

	private LocalDate orderExpirationDate;
	private LocalDate orderStartDate;
	private LocalTime orderStartTime;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "buyer_id", referencedColumnName = "id")
	private User buyer;

	private double totalAmount;
	private String currencyType;
	private OrderStatus orderStatus;

	public Order() {

	}

	public Order(Long id, User seller, List<OrderedProducts> orderProducts, LocalDate orderExpirationDate,
			LocalDate orderStartDate, LocalTime orderStartTime, User buyer, double totalAmount, String currencyType,
			OrderStatus orderStatus) {
		super();
		this.id = id;
		this.seller = seller;
		this.orderProducts = orderProducts;
		this.orderExpirationDate = orderExpirationDate;
		this.orderStartDate = orderStartDate;
		this.orderStartTime = orderStartTime;
		this.buyer = buyer;
		this.totalAmount = totalAmount;
		this.currencyType = currencyType;
		this.orderStatus = orderStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public List<OrderedProducts> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderedProducts> orderProducts) {
		this.orderProducts = orderProducts;
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

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
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

}
