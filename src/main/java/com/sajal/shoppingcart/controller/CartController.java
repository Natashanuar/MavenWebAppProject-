package com.sajal.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sajal.shoppingcart.dao.ProductDAO;
import com.sajal.shoppingcart.model.Cart;
import com.sajal.shoppingcart.model.Item;

@Controller
public class CartController {

	@Autowired
	private ProductDAO productDAO;

	Cart cart;

	@RequestMapping("/cartadd/{id}")
	public String addToCart(@PathVariable(value = "id") int id, ModelMap mm, HttpSession session) {

		if (session.getAttribute("cart") == null) {
			List<Item> listcart = new ArrayList<Item>();
			cart = new Cart();

			listcart.add(new Item(this.productDAO.getProductByID(id), 1));
			cart.setItem(listcart);
			session.setAttribute("cart", cart);
		} else {
			cart = (Cart) session.getAttribute("cart");
			List<Item> listcart = cart.getItem();

			int index = isExisting(id, listcart);
			if (index == -1)
				listcart.add(new Item(this.productDAO.getProductByID(id), 1));
			else {
				int quantity = listcart.get(index).getQuantity() + 1;
				listcart.get(index).setQuantity(quantity);
			}
			cart.setItem(listcart);
			session.setAttribute("cart", cart);
		}
		System.out.println(cart.getItem());
		return "/Cart";
	}

	@RequestMapping(value = "/deleteItem/{id}")
	public String delete(@PathVariable(value = "id") int id, HttpSession session, Model m) {

		cart = (Cart) session.getAttribute("cart");

		List<Item> listcart = (List<Item>) cart.getItem();

		int index = isExisting(id, listcart);
		listcart.remove(index);
		cart.setItem(listcart);

		session.setAttribute("cart", cart);

		return "redirect:/cart";
	}

	private int isExisting(int id, List<Item> pcart) {

		for (int i = 0; i < pcart.size(); i++)

			if (pcart.get(i).getProduct().getId() == id)
				return i;
		return -1;
	}
}
