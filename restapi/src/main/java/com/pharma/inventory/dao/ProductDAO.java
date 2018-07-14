package com.pharma.inventory.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.pharma.inventory.exception.DataAlreadyExistsException;
import com.pharma.inventory.exception.ProductNameNotExistException;
import com.pharma.inventory.exception.ProductWithCategoryNameNotFoundException;
import com.pharma.inventory.exception.ProductWithGenericNameDoesNotExist;
import com.pharma.inventory.model.Category;
import com.pharma.inventory.model.Product;

public class ProductDAO {

	public static void save(List<Product> productList){
		for (Product product : productList) {
			Session session = getSession();
			Transaction t = session.beginTransaction();
			try {
				if (!t.isActive())
					t.begin();
				session.save(product);
				t.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
	}

	public static Product getMedicineByName(String name) throws ProductNameNotExistException {
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
			else {
				throw new ProductNameNotExistException("Product with name "+name+" does not exist");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} 
		finally {
			session.close();
		}
		return null;
	}

	public static List<Product> getMedicineByGenericName(String name) throws ProductWithGenericNameDoesNotExist {
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
			else {
				throw new ProductWithGenericNameDoesNotExist("Produt with Generic Name = "+name+" does not exist");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	public static List<Product> getMedicineByCategoryName(String name) throws ProductWithCategoryNameNotFoundException {
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
				List<Product> prodList = cr1.list();
				if (prodList != null && !prodList.isEmpty()) {
					productList.addAll(prodList);
				}
			}
			t.commit();
			if(productList != null && !productList.isEmpty()) {
				return productList;
			}
			else {
				throw new ProductWithCategoryNameNotFoundException("Product with category name "+name+" does not exist");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	public static List<Product> getTopSoldProducts(int limit){
		Session session = getSession();
		try {
			String hql = "SELECT productId " + 
					"FROM InvoiceDetail " + 
					"GROUP BY productId " + 
					"ORDER BY SUM(productQuantity) DESC";
			List<Integer> list = session.createQuery(hql).setMaxResults(limit).list();
			List<Product> productList = new ArrayList<Product>();
			for(Integer id:list) {
				Criteria cr =session.createCriteria(Product.class);
				cr.add(Restrictions.idEq(id));
				productList.addAll(cr.list());
			}
				return productList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		session.close();
		}
		return null;
	}

	public static Session getSession() {
		return new Configuration().configure().buildSessionFactory().openSession();
	}

	public static void upsert(Product product) {
		Session session = getSession();
		Transaction t = session.beginTransaction();
		try {
			if (!t.isActive())
				t.begin();
			session.saveOrUpdate(product);
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
