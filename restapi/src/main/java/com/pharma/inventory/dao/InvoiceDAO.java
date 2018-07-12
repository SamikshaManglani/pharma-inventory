package com.pharma.inventory.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pharma.inventory.model.Invoice;

public class InvoiceDAO {
	
	public static int register(Invoice i) {
		
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		int k=0;
		try {
			if(!t.isActive())
				t.begin();
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
}
