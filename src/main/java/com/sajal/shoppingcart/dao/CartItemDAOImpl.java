package com.sajal.shoppingcart.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sajal.shoppingcart.model.Cart;
import com.sajal.shoppingcart.model.Item;

@Transactional
@Repository("CartItemDAO")
public class CartItemDAOImpl implements CartItemDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public CartItemDAOImpl() {
	}

	Session ss;

	public CartItemDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Item> cartItem(Cart cart) {
		return sessionFactory.getCurrentSession().createQuery("from item where cart = :cart").setParameter("cart", cart)
				.getResultList();
	}

	public Item getItemById(int id) {
		return sessionFactory.getCurrentSession().get(Item.class, Integer.valueOf(id));
	}

	public boolean addItem(Item item) {
		try {
			sessionFactory.getCurrentSession().save(item);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateItem(Item item) {
		try {
			sessionFactory.getCurrentSession().update(item);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteItemById(int id) {
		try {
			sessionFactory.getCurrentSession().delete(getItemById(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteAllItem(List<Item> list) {
		try {
			for (Item i : list) {
				sessionFactory.getCurrentSession().delete(i);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteCart(int id) {
		try {
			sessionFactory.getCurrentSession().delete(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}