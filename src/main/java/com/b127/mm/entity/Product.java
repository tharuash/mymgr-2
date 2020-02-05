package com.b127.mm.entity;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private ProductType type;
	private double unitPrice;
	private String currencyType;
	private double unitQuantity;
	private String siUnit;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "seller_id", referencedColumnName = "id")
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "stock_id", referencedColumnName = "id")
	private Stock stock;
	
	@OneToMany(mappedBy = "product")
	private List<OrderedProducts> productOrders;
	
	/*@Lob
	@Type(type = "org.hibernate.type.ImageType")
	private String image;*/

	public Product() {

	}

	public Product(Long id, String name, ProductType type, double unitPrice, String currencyType, double unitQuantity,
			String siUnit, User user, Stock stock) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.unitPrice = unitPrice;
		this.currencyType = currencyType;
		this.unitQuantity = unitQuantity;
		this.siUnit = siUnit;
		this.user = user;
		this.stock = stock;
		// this.image = image;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	/*public void setImage(String image) {
		this.image = image;
	}
	
	public String getImage() {
		return image;
	}*/

}
