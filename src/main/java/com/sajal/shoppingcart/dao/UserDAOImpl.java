package com.sajal.shoppingcart.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.sajal.shoppingcart.model.Authorize;
import com.sajal.shoppingcart.model.User;

@Transactional
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	UserDAOImpl() {
	}

	@Autowired
	private SessionFactory sessionFactory;

	Session session;

	public UserDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	public List<User> user() {
		session = sessionFactory.getCurrentSession();
		return session.createQuery("from User").list();
	}

	public boolean save(User user) {
		try {
			session = sessionFactory.getCurrentSession();
			Authorize auth= new Authorize();
			user.setId(user.getUsername());
			user.setEnabled(true);
			auth.setId(user.getId());
			auth.setRole("ROLE_USER");
			session.save(user);
			session.save(auth);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(User user) {
		try {
			session = sessionFactory.getCurrentSession();
			session.update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(String id) {
		try {
			session = sessionFactory.getCurrentSession();
			session.delete(getUserByID(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(User user) {
		try {
			session = sessionFactory.getCurrentSession();
			session.delete(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public User getUserByID(String id) {
		session = sessionFactory.getCurrentSession();
		return (User) session.createQuery("from User where id = '" + id + "'").uniqueResult();
	}

	public User getUserByName(String name) {
		session = sessionFactory.getCurrentSession();
		return (User) session.createQuery("from User where username = '" + name + "'").list().get(0);
	}

	public boolean validate(String username, String password) {
		session = sessionFactory.getCurrentSession();
		String hql = "from User where username='"+username+"' and password='"+ password+"'";
		if (session.createQuery(hql).uniqueResult() != null) {
			return true;
		}
		return false;
	}
}
