package com.sajal.shoppingcart.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sajal.shoppingcart.model.Brand;

@Transactional
@Repository("brandDAO")
public class BrandDAOImpl implements BrandDAO {

	public BrandDAOImpl() {
	}

	@Autowired
	private SessionFactory sessionFactory;

	Session ss;

	public BrandDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Brand> brand() {
		ss = sessionFactory.getCurrentSession();
		return ss.createQuery("from Brand").list();
	}

	public boolean save(Brand brand) {
		try {
			ss = sessionFactory.getCurrentSession();
			ss.save(brand);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Brand brand) {
		try {
			ss = sessionFactory.getCurrentSession();
			ss.update(brand);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(int id) {
		try {
			ss = sessionFactory.getCurrentSession();
			ss.delete(getBrandByID(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Brand brand) {
		try {
			ss = sessionFactory.getCurrentSession();
			ss.delete(brand);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Brand getBrandByID(int id) {
		ss = sessionFactory.getCurrentSession();
		return (Brand) ss.createQuery("from Brand where id = '" + id + "'").uniqueResult();
	}

	public Brand getBrandByName(String name) {
		ss = sessionFactory.getCurrentSession();
		return (Brand) ss.createQuery("from Brand where name = '" + name + "'").list().get(0);
	}

}
