package com.b127.mm.dto;

public class ManualOrderProductDto {
	private Long id;
	private Long productId;
	private String productName;
	private Long requiredQuantity;
	private double subTotal;

	public ManualOrderProductDto() {

	}

	public ManualOrderProductDto(Long id, Long requiredQuantity, double subTotal) {
		super();
		this.id = id;
		this.requiredQuantity = requiredQuantity;
		this.subTotal = subTotal;
	}

	public ManualOrderProductDto(Long id, String productName, Long requiredQuantity, double subTotal, Long productId) {
		super();
		this.id = id;
		this.productName = productName;
		this.requiredQuantity = requiredQuantity;
		this.subTotal = subTotal;
		this.productId = productId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRequiredQuantity() {
		return requiredQuantity;
	}

	public void setRequiredQuantity(Long requiredQuantity) {
		this.requiredQuantity = requiredQuantity;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Long getProductId() {
		return productId;
	}
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
