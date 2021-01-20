package com.sajal.shoppingcart.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sajal.shoppingcart.model.Product;

@Transactional
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {

	public ProductDAOImpl() {
	}

	@Autowired
	private SessionFactory sessionFactory;

	Session ss;

	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Product> product() {
		ss = sessionFactory.getCurrentSession();
		return ss.createQuery("from Product").list();
	}

	public boolean save(Product product) {
		try {
			ss = sessionFactory.getCurrentSession();
			ss.save(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Product product) {
		try {
			ss = sessionFactory.getCurrentSession();
			ss.update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(int id) {
		try {
			ss = sessionFactory.getCurrentSession();
			ss.delete(getProductByID(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Product product) {
		try {
			ss = sessionFactory.getCurrentSession();
			ss.delete(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Product getProductByID(int id) {
		ss = sessionFactory.getCurrentSession();
		return (Product) ss.createQuery("from Product where id = " + id).uniqueResult();
	}

	public List<Product> getProductByBrand(String name) {
		ss = sessionFactory.getCurrentSession();
		return ss.createQuery("from Product where brandId = '" + name + "'").getResultList();
	}

}
