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

import com.sajal.shoppingcart.dao.SupplierDAO;
import com.sajal.shoppingcart.model.Supplier;

@Controller
public class SupplierController {

	@Autowired
	private Supplier supplier;

	@Autowired
	private SupplierDAO supplierDAO;

	@RequestMapping("/addSupplier")
	public String registerSupplier(Model model) {
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", supplierDAO.supplier());

		return "/admin/AdminSupplier";
	}

	@RequestMapping(value = "/registerSupplier", method = RequestMethod.POST)
	public String insertSupplier(@Valid @ModelAttribute("supplier") Supplier s, BindingResult result, Model model,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			model.addAttribute("listSupplier", this.supplierDAO.supplier());
			return "forward:/addSupplier";
		} else {
			if (s.getId() == 0) {
				this.supplierDAO.save(s);
			} else {
				this.supplierDAO.update(s);
				model.addAttribute("supplier", new Supplier());
			}
			return "/admin/AdminSupplier";
		}
	}

	@RequestMapping("/deleteSupplier/{id}")
	public String deleteSupplier(@PathVariable("id") int id) {
		this.supplierDAO.delete(id);
		return "redirect:/addSupplier";
	}

	@RequestMapping("/editSupplier/{id}")
	public String editBrand(@PathVariable("id") int id, Model model) {

		model.addAttribute("supplier", supplierDAO.getSupplierByID(id));
		model.addAttribute("supplierList", this.supplierDAO.supplier());

		return "/admin/AdminSupplier";

	}
}
