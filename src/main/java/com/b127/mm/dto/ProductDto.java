package com.b127.mm.dto;

import com.b127.mm.entity.ProductType;
import com.b127.mm.entity.Stock;

public class ProductDto {

	private Long id;
	private String name;
	private ProductType type;
	private double unitPrice;
	private String currencyType;
	private double unitQuantity;
	private String siUnit;
	private Stock stock;

	public ProductDto() {

	}

	public ProductDto(Long id, String name, ProductType type, double unitPrice, String currencyType,
			double unitQuantity, String siUnit, Stock stock) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.unitPrice = unitPrice;
		this.currencyType = currencyType;
		this.unitQuantity = unitQuantity;
		this.siUnit = siUnit;
		this.stock = stock;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public double getUnitQuantity() {
		return unitQuantity;
	}

	public void setUnitQuantity(double unitQuantity) {
		this.unitQuantity = unitQuantity;
	}

	public String getSiUnit() {
		return siUnit;
	}

	public void setSiUnit(String siUnit) {
		this.siUnit = siUnit;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}
