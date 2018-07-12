package com.pharma.inventory.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.pharma.inventory.model.Invoice;
import com.pharma.inventory.model.InvoiceDetail;
import com.pharma.inventory.model.Order;
import com.pharma.inventory.model.OrderEntry;

public class InvoiceDAO {
	
	public static int create(Order order) {
		
		Session session = getSession();
		Transaction t = session.beginTransaction();
		int k=0;
		try {
			if(!t.isActive())
				t.begin();
			Invoice i = new Invoice();
			i.setDoctorName(order.getDoctorName());
			i.setPatientName(order.getPatientName());
			i.setInvoiceDate(new Date());
			//TODO get id
			List<InvoiceDetail> invoiceDetails = new ArrayList<InvoiceDetail>();
			for(OrderEntry orderEntry : order.getOrderEntries()) {
				InvoiceDetail invoiceDetail = new InvoiceDetail();
				invoiceDetail.setProductQuantity(orderEntry.getQuantity());
				invoiceDetail.setProductId(ProductDAO.getMedicineByName(orderEntry.getName()).getId());
				invoiceDetails.add(invoiceDetail);
			}
			i.setInvoiceDetails(invoiceDetails);
			k = (Integer)session.save(i);
			t.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//t.rollback();
			session.close();
		}
		return k;
	}

	public static Invoice getById(int id) {
		Session session = getSession();
		Criteria cr =session.createCriteria(Invoice.class);
		cr.add(Restrictions.idEq(id));
		if(cr.list().isEmpty())
			return null;
		return (Invoice)cr.list().get(0);
	}
	
	public static Session getSession() {
		return new Configuration().configure().buildSessionFactory().openSession();
	}
}
