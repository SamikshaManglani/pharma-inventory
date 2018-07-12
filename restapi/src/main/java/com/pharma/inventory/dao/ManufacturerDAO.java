package com.pharma.inventory.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pharma.inventory.model.Manufacturer;

public class ManufacturerDAO {

	public static int save(Manufacturer manufacturer) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		int k=0;
		try {
			if (!t.isActive())
				t.begin();
			k = (Integer)session.save(manufacturer);
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
