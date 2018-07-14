package com.pharma.inventory.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.pharma.inventory.exception.InvoiceDoesNotExistException;
import com.pharma.inventory.model.Invoice;
import com.pharma.inventory.model.InvoiceDetail;
import com.pharma.inventory.model.Order;
import com.pharma.inventory.model.OrderEntry;
import com.pharma.inventory.model.Product;

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
			double totalCost =0.0;
			for(OrderEntry orderEntry : order.getOrderEntries()) {
				InvoiceDetail invoiceDetail = new InvoiceDetail();
				invoiceDetail.setProductQuantity(orderEntry.getQuantity());
				Product product = ProductDAO.getMedicineByName(orderEntry.getName());
				invoiceDetail.setProductId(product.getId());
				totalCost = totalCost+(product.getPrice()*orderEntry.getQuantity());
				invoiceDetails.add(invoiceDetail);
			}
			i.setTotalCost(totalCost);
			session.save(i);
			t.commit();
			k=i.getId();
			for(InvoiceDetail invoiceDetail: invoiceDetails) {
				session = getSession();
				t = session.beginTransaction();
				if(!t.isActive())
					t.begin();
				invoiceDetail.setInvoiceId(k);
				session.save(invoiceDetail);
				t.commit();
			}
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

	public static Invoice getById(int id) throws InvoiceDoesNotExistException {
		Session session = getSession();
		Criteria cr =session.createCriteria(Invoice.class);
		cr.add(Restrictions.idEq(id));
		if(!cr.list().isEmpty() && cr.list() != null)
			return (Invoice)cr.list().get(0);
		else {
			throw new InvoiceDoesNotExistException("Invoice with id = "+id+" doesn't exist");
		}
	}
	
	public static Session getSession() {
		return new Configuration().configure().buildSessionFactory().openSession();
	}
}
