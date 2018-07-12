package com.pharma.inventory.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="product")
@Entity
@Table(name = "Product")
public class Product {


	/*
	 * Invoice Id
	 */
	@Id
	@Column(name = "product_id")
	private int id;

	/*
	 * Manufacturer Id
	 */
	@Column(name = "manufacturer_id")
	private int manufacturerId;
	
	/*
	 * Product Name
	 */
	@Column(name = "product_name")
	private String productName;
	
	/*
	 * price
	 */
	@Column(name = "price")
	private double price;
	
	/*
	 * Category Id
	 */
	@Column(name = "category_id")
	private int categoryId;
	
	/*
	 * Expiry Date
	 */
	@Column(name = "expiry_date")
	private Date expiryDate;
	
	/*
	 * Generic Name
	 */
	@Column(name = "generic_name")
	private String genericName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getGenericName() {
		return genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}
}
