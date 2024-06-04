package com.example.demo.sp40.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sp40")
public class CartController {
	
	@GetMapping("/cart")
	public String showCart() {
		return "sp40/cart";
	}
}
