package com.sajal.shoppingcart.dao;

import java.util.List;

import com.sajal.shoppingcart.model.Product;

public interface ProductDAO {

	public List<Product> product(); // get all products

	public boolean save(Product product); // create product

	public boolean update(Product product); // update product

	public boolean delete(int id); // delete product by id

	public boolean delete(Product product);// delete product by product

	public Product getProductByID(int id); // get() product by id

	public List<Product> getProductByBrand(String name); // get() product by brand
	
}
