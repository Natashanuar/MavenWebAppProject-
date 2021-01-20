package com.sajal.shoppingcart.dao;

import java.util.List;

import com.sajal.shoppingcart.model.Cart;
import com.sajal.shoppingcart.model.Item;

public interface CartItemDAO {

	public List<Item> cartItem(Cart cart);

	public Item getItemById(int id);

	// CRUD for items
	public boolean addItem(Item item);

	public boolean updateItem(Item item);

	public boolean deleteItemById(int id);

	public boolean deleteAllItem(List<Item> list);

	// CRUD for cart
	public boolean updateCart(Cart cart);

	public boolean deleteCart(int id);

}
