package com.sajal.shoppingcart.dao;

import java.util.List;

import com.sajal.shoppingcart.model.Brand;

public interface BrandDAO {

	public List<Brand> brand(); // get all brands

	public boolean save(Brand brand); // create brand

	public boolean update(Brand brand); // update brand

	public boolean delete(int id); // delete brand by id

	public boolean delete(Brand brand);// delete brand by brand

	public Brand getBrandByID(int id); // get() brand by id

	public Brand getBrandByName(String name); // get() brand by name

}
