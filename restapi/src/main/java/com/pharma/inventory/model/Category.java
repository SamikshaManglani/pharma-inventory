package com.pharma.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="category")
@Entity
@Table(name = "category")
public class Category {

	/*
	 * Category Id
	 */
	@Id
	@Column(name = "category_id")
	private int id;

	/*
	 * Category Name
	 */
	@Column(name = "category_name")
	private String categoryName;

	/*
	 * Category Desc
	 */
	@Column(name = "category_desc")
	private String categoryDesc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}


}
