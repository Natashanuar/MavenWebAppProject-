package com.sajal.shoppingcart.dao;

import java.util.List;

import com.sajal.shoppingcart.model.User;

public interface UserDAO {
	
	public List<User> user(); // get all users

	public boolean save(User user); // create user

	public boolean update(User user); // update user

	public boolean delete(String id); // delete user by id

	public boolean delete(User user);// delete user by user

	public User getUserByID(String id); // get() user by id

	public User getUserByName(String name); // get() user by name
	
	public boolean validate(String id, String password);
}
