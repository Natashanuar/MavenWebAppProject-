package com.sajal.shoppingcart.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sajal.shoppingcart.dao.ProductDAO;
import com.sajal.shoppingcart.model.Product;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.sports.ZenSportsBackEnd");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	@Test
	public void testAddProduct() {
		product = new Product();
		product.setName("ABC");
		product.setBrandId("BMW");
		product.setPrice(2000000);
		product.setDesc("Test case car. ");
		product.setSupplierId("Sedans");

		assertEquals("Successfully added a product.", true, productDAO.save(product));
	}

	@Test
	public void testGetProduct() {
		product = productDAO.getProductByID(1);
		assertEquals("Retrieving data based on id from table", 1, product.getId());
	}

	@Test
	public void testUpdateProduct() {
		product = productDAO.getProductByID(3);
		product.setName("ABC");
		product.setBrandId("BMW");
		product.setPrice(2000000);
		product.setDesc("Test case car. ");
		product.setSupplierId("Sedans");
		assertEquals("Updating user based on id from table", true, productDAO.update(product));
	}

	@Test
	public void testDeleteProduct() {
		assertEquals("Deleting product based on id", true, productDAO.delete(2));
	}

}
