package com.sajal.shoppingcart.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sajal.shoppingcart.dao.UserDAO;
import com.sajal.shoppingcart.model.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.sajal.shoppingcart");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
	}

	@Test
	public void testAddUser() {
		user = new User();
		user.setUsername("testcase");
		user.setPassword("testcase");
		user.setEmail("testcase@sajal.com");
		user.setContact("1234567890");
		user.setEnabled(true);

		assertEquals("Successfully added a new user.", true, userDAO.save(user));
	}

	@Test
	public void testUpdateUser() {
		user = userDAO.getUserByID("testcase");
		user.setUsername("testcaseupdate");
		user.setPassword("testcaseupdate");
		user.setEmail("testcaseupdate@sajal.com");
		user.setContact("1234567890");
		user.setEnabled(true);

		assertEquals("Successfully update the user.", true, userDAO.update(user));
	}

	@Test
	public void testDeleteUser() {

		assertEquals("Successfully deleted the user.", true, userDAO.delete("testcase"));

	}
}
