package com.pharma.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="manufacturer")
@Entity
@Table(name = "Manufacturer")
public class Manufacturer {
	
	/*
	 * Manufacturer Id
	 */
	@Id
	@Column(name = "manufacturer_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	/*
	 * Address
	 */
	@Column(name = "address")
	private String address;

	/*
	 * Contact
	 */
	@Column(name = "contact")
	private String contact;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	
}
