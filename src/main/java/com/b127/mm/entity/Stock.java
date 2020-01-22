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
@Table(name = "stocks")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product product;
	private StockType stockType;
	private double maximumQuantity;
	private boolean isAvailableOnSell;

	public Stock() {

	}

	public Stock(Long id, Product product, StockType stockType, double maximumQuantity, boolean isAvailableOnSell) {
		super();
		this.id = id;
		this.product = product;
		this.stockType = stockType;
		this.maximumQuantity = maximumQuantity;
		this.isAvailableOnSell = isAvailableOnSell;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public StockType getStockType() {
		return stockType;
	}

	public void setStockType(StockType stockType) {
		this.stockType = stockType;
	}

	public double getMaximumQuantity() {
		return maximumQuantity;
	}

	public void setMaximumQuantity(double maximumQuantity) {
		this.maximumQuantity = maximumQuantity;
	}

	public boolean isAvailableOnSell() {
		return isAvailableOnSell;
	}

	public void setAvailableOnSell(boolean isAvailableOnSell) {
		this.isAvailableOnSell = isAvailableOnSell;
	}

}
