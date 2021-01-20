package com.sajal.shoppingcart.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sajal.shoppingcart.dao.BrandDAO;
import com.sajal.shoppingcart.dao.ProductDAO;
import com.sajal.shoppingcart.dao.SupplierDAO;

@Controller
public class HomeController {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private BrandDAO brandDAO;

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private HttpSession session;

	@RequestMapping("/")
	public ModelAndView showStartPage() {
		ModelAndView mv = new ModelAndView("/Home");
		session.setAttribute("productList", productDAO.product());
		session.setAttribute("brandList", brandDAO.brand());
		session.setAttribute("supplierList", supplierDAO.supplier());
		return mv;
	}

	@RequestMapping("/home")
	public ModelAndView showHomePage() {
		ModelAndView mv = new ModelAndView("/Home");
		session.setAttribute("productList", productDAO.product());
		session.setAttribute("brandList", brandDAO.brand());
		session.setAttribute("supplierList", supplierDAO.supplier());
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView showLoginPage() {
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("LoginClicked", "true");
		return mv;
	}

	@RequestMapping("/cart")
	public ModelAndView showCartPage() {
		ModelAndView mv = new ModelAndView("/Cart");
		return mv;
	}

	@RequestMapping("/aboutus")
	public ModelAndView showAboutUsPage() {
		ModelAndView mv = new ModelAndView("/AboutUs");
		return mv;
	}

	@RequestMapping("/forgotpassword")
	public ModelAndView showForgotPasswordPage() {
		ModelAndView mv = new ModelAndView("/ForgotPassword");
		return mv;
	}

	@RequestMapping("/403")
	public ModelAndView show403ErrorPage() {
		ModelAndView mv = new ModelAndView("/error/403");
		return mv;
	}

	@RequestMapping("/logout")
	public ModelAndView logout() {
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("logoutMessage", "Logout Successful.");
		return mv;
	}
}