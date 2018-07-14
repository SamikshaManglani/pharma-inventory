package com.pharma.inventory.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.pharma.inventory.model.Category;
import com.pharma.inventory.model.Manufacturer;
import com.pharma.inventory.model.Response;

public class ManufacturerDAO {

	public static Response save(Manufacturer manufacturer) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Response response = new Response();
		if(find(manufacturer)) {
			response.setMessage("Manufacturer exists");
			response.setStatus(false);
			return response;
		}
		int k=0;
		try {
			if (!t.isActive())
				t.begin();
			session.save(manufacturer);
			t.commit();
			k=manufacturer.getId();
			response.setMessage("Manufacturer added successfully. Manufacturer id="+k);
			response.setStatus(true);
		} catch (Exception e) {
			e.printStackTrace();
			response.setMessage(e.getMessage());
			response.setStatus(false);
		}
		finally {
			session.close();
		}
		return response;
	}
	public static boolean find(Manufacturer manufacturer) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		
		Criteria cr = session.createCriteria(Manufacturer.class);
		cr.add(Restrictions.eq("contact", manufacturer.getContact()));
		List<Manufacturer> manufacturerList = cr.list();
		if(manufacturerList != null && !manufacturerList.isEmpty())
			return true;
		return false;
	}
}
