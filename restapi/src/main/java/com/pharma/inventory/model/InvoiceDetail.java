package com.pharma.inventory.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cascade;

@XmlRootElement (name="invoice_detail")
@Entity
@Table(name = "invoice_detail")
public class InvoiceDetail {
	
	/*
	 * Invoice detail Id
	 */
	@Id
	@Column(name = "invoice_detail_id")
	private int id;
	
	/*
	 * Product Id
	 */
	@Column(name = "product_id")
	private int productId;
	
	/*
	 * Invoice Id
	 */
	@ManyToOne
	@JoinColumn(name = "invoice_id")
	private int invoiceId;
	
	/*
	 * Product Quantity
	 */
	@Column(name = "product_quantity")
	private int productQuantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int i) {
		this.productQuantity = i;
	}

}
