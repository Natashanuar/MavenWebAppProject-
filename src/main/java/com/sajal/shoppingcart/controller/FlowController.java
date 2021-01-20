package com.sajal.shoppingcart.controller;

import org.springframework.stereotype.Component;

import com.sajal.shoppingcart.model.Cart;

@Component
public class FlowController {

	public Cart initFlow() {
		return new Cart();
	}

}
