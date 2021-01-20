package com.sajal.shoppingcart.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sajal.shoppingcart.model.Supplier;

@Transactional
@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {

	public SupplierDAOImpl() {
	}

	@Autowired
	private SessionFactory sessionFactory;

	Session ss;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Supplier> supplier() {
		ss = sessionFactory.getCurrentSession();
		return ss.createQuery("from Supplier").list();
	}

	public boolean save(Supplier supplier) {
		try {
			ss = sessionFactory.getCurrentSession();
			ss.save(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Supplier supplier) {
		try {
			ss = sessionFactory.getCurrentSession();
			ss.update(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(int id) {
		try {
			ss = sessionFactory.getCurrentSession();
			ss.delete(getSupplierByID(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Supplier supplier) {
		try {
			ss = sessionFactory.getCurrentSession();
			ss.delete(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Supplier getSupplierByID(int id) {
		ss = sessionFactory.getCurrentSession();
		return (Supplier) ss.createQuery("from Supplier where id = '" + id + "'").uniqueResult();
	}

	public Supplier getSupplierByName(String name) {
		ss = sessionFactory.getCurrentSession();
		return (Supplier) ss.createQuery("from Supplier where name = '" + name + "'").list().get(0);
	}

}
