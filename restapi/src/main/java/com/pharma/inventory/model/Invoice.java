package com.pharma.inventory.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="invoice")
@Entity
@Table(name = "Invoice")
public class Invoice {

	/*
	 * Invoice Id
	 */
	@Id
	@Column(name = "invoice_id")
	private int id;
	
	/*
	 * Doctor name
	 */
	@Column(name = "doctor_name")
	private String doctorName;
	
	/*
	 * Patient name
	 */
	@Column(name = "patient_name")
	private String patientName;
	
	/*
	 * invoice date
	 */
	@Column(name = "invoice_date")
	private Date invoiceDate;
	
	/*
	 * total cost
	 */
	@Column(name = "total_cost")
	private double totalCost;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
}
