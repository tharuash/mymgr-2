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

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "buyer_id", referencedColumnName = "id")
	private User buyer;

	@OneToMany(mappedBy = "order")
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
	private String cancellation;

	public Order() {

	}

	public Order(Long id, User seller, List<OrderedProducts> orderProducts, double productAmount,
			LocalDate orderExpirationDate, LocalDate orderStartDate, LocalTime orderStartTime, double totalPrice,
			String currencyType, OrderStatus orderStatus, String orderLocation, boolean sellerConfirmation,
			boolean buyerConfirmation, User buyer, String cancellation) {
		super();
		this.id = id;
		this.seller = seller;
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
		this.buyer = buyer;
		this.cancellation = cancellation;
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

	public void setOrderProducts(List<OrderedProducts> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public List<OrderedProducts> getOrderProducts() {
		return orderProducts;
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

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}
	
	public String getCancellation() {
		return cancellation;
	}
	
	public void setCancellation(String cancellation) {
		this.cancellation = cancellation;
	}

}
