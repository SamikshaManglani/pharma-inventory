package com.pharma.inventory.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pharma.inventory.model.InvoiceDetail;

public class InvoiceDetailDAO{
	
	public static int save(InvoiceDetail invoiceDetail){
		
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		int k=0;
		try {
			if(!t.isActive())
				t.begin();
			k = (Integer)session.save(invoiceDetail);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return k;
	}

}
