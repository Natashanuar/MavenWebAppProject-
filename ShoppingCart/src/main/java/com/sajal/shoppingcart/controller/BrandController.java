package com.sajal.shoppingcart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sajal.shoppingcart.dao.BrandDAO;
import com.sajal.shoppingcart.model.Brand;

@Controller
public class BrandController {

	@Autowired
	private Brand brand;

	@Autowired
	private BrandDAO brandDAO;

	@RequestMapping("/addBrand")
	public String registerBrand(Model model) {
		model.addAttribute("brand", brand);
		model.addAttribute("brandList", brandDAO.brand());

		return "/admin/AdminBrand";
	}

	@RequestMapping(value = "/registerBrand", method = RequestMethod.POST)
	String insertBrand(@Valid @ModelAttribute("brand") Brand b, BindingResult result, Model model,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			model.addAttribute("brandList", this.brandDAO.brand());
			return "forward:/addBrand";
		} else {
			if (b.getId() == 0)
				this.brandDAO.save(b);
			else
				this.brandDAO.update(b);
			model.addAttribute("brand", new Brand());
		}
		model.addAttribute("brandList", this.brandDAO.brand());
		return "/admin/AdminBrand";
	}

	@RequestMapping("/deleteBrand/{id}")
	public String deleteBrand(@PathVariable("id") int id) {
		this.brandDAO.delete(id);
		return "redirect:/addBrand";
	}

	@RequestMapping("/editBrand/{id}")
	public String editBrand(@PathVariable("id") int id, Model model) {
		brand = brandDAO.getBrandByID(id);
		return "/admin/AdminBrand";

	}

}
