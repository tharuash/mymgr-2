package com.b127.mm.dto;

import com.b127.mm.entity.Product;
import com.b127.mm.entity.StockType;

public class StockDto {

	private Long id;
	private String productName;
	private StockType stockType;
	private double maximumQuantity;
	private double availableQuantity;
	private boolean isAvailableOnSell;
	private double unitPrice;

	public StockDto() {

	}

	public StockDto(Long id, String productName, StockType stockType, double maximumQuantity, double availableQuantity,
			boolean isAvailableOnSell, double unitPrice) {
		super();
		this.id = id;
		this.productName = productName;
		this.stockType = stockType;
		this.maximumQuantity = maximumQuantity;
		this.availableQuantity = availableQuantity;
		this.isAvailableOnSell = isAvailableOnSell;
		this.unitPrice = unitPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public double getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(double availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public boolean isAvailableOnSell() {
		return isAvailableOnSell;
	}

	public void setAvailableOnSell(boolean isAvailableOnSell) {
		this.isAvailableOnSell = isAvailableOnSell;
	}
	
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public double getUnitPrice() {
		return unitPrice;
	}

}
