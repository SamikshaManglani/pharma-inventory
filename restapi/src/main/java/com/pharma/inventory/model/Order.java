package com.pharma.inventory.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="order")
public class Order {

	private String doctorName;

	private String patientName;
	
	private List<OrderEntry> orderEntries;

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

	public List<OrderEntry> getOrderEntries() {
		return orderEntries;
	}

	public void setOrderEntries(List<OrderEntry> orderEntries) {
		this.orderEntries = orderEntries;
	}

}
