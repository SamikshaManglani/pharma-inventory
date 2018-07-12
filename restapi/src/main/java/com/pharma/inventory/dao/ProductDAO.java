package com.pharma.inventory.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.pharma.inventory.model.Category;
import com.pharma.inventory.model.Product;

public class ProductDAO {

	public static void save(List<Product> productList) {
		for (Product product : productList) {
			Session session = getSession();
			Transaction t = session.beginTransaction();
			try {
				if (!t.isActive())
					t.begin();
				session.save(product);
				t.commit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// t.rollback();
				session.close();
			}
		}
	}

	public static Product getMedicineByName(String name) {
		Session session = getSession();
		Transaction t = session.beginTransaction();
		try {
			if (!t.isActive())
				t.begin();
			Criteria cr = session.createCriteria(Product.class);
			cr.add(Restrictions.eq("productName", name));
			List<Product> productList = cr.list();
			t.commit();
			if (productList != null && !productList.isEmpty()) {
				return productList.get(0);
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public static List<Product> getMedicineByGenericName(String name) {
		Session session = getSession();
		Transaction t = session.beginTransaction();
		try {
			if (!t.isActive())
				t.begin();
			Criteria cr = session.createCriteria(Product.class);
			cr.add(Restrictions.eq("genericName", name));
			List<Product> productList = cr.list();
			t.commit();
			if (productList != null && !productList.isEmpty()) {
				return productList;
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public static List<Product> getMedicineByCategoryName(String name) {
		Session session = getSession();
		Transaction t = session.beginTransaction();
		try {
			if (!t.isActive())
				t.begin();
			Criteria cr = session.createCriteria(Category.class);
			cr.add(Restrictions.eq("categoryName", name));
			List<Category> categoryList = cr.list();
			List<Product> productList = new ArrayList<Product>();
			for (Category category : categoryList) {
				if (!t.isActive())
					t.begin();
				Criteria cr1 = session.createCriteria(Product.class);
				cr1.add(Restrictions.eq("categoryId", category.getId()));
				List<Product> productList1 = cr1.list();
				if (productList != null && !productList.isEmpty()) {
					productList.addAll(productList1);
				}
				t.commit();
			}
			return productList;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public static Session getSession() {
		return new Configuration().configure().buildSessionFactory().openSession();
	}
}
