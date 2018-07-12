package com.pharma.inventory.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pharma.inventory.model.Category;

public class CategoryDAO {

	public static int save(Category category) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		int k=0;
		try {
			if (!t.isActive())
				t.begin();
			k = (Integer)session.save(category);
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
