package com.pharma.inventory.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.pharma.inventory.model.Category;
import com.pharma.inventory.model.Response;

public class CategoryDAO {

	public static Response save(Category category) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Response response = new Response();
		if(find(category)) {
			response.setMessage("Category already exists");
			response.setStatus(false);
			return response;
		}
		try {
			if (!t.isActive())
				t.begin();
			session.save(category);
			t.commit();
			int k = category.getId();
			response.setMessage("Category saved successfully. Category id = "+k);
			response.setStatus(true);
		}catch (org.hibernate.exception.ConstraintViolationException e) {
			e.printStackTrace();
			response.setMessage("Dulicate id cannot be inserted");
			response.setStatus(false);
		}
		catch (Exception e) {
			e.printStackTrace();
			response.setMessage(e.getMessage());
			response.setStatus(false);
		}
		finally {
			//t.rollback();
			session.close();
		}
		return response;
	}
	
	public static boolean find(Category category) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Criteria cr1 = session.createCriteria(Category.class);
		cr1.add(Restrictions.eq("categoryName", category.getCategoryName()));
		cr1.add(Restrictions.eq("categoryDesc", category.getCategoryDesc()));
		List<Category> categoryList = cr1.list();
		if(categoryList != null && !categoryList.isEmpty())
			return true;
		return false;
	}
}
