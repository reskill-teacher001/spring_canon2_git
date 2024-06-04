package com.example.demo.sp40.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.sp40.model.Item;

@Controller
@RequestMapping("/sp40")
public class CartController {
	
	@GetMapping("/cart")
	public String showCart() {
		return "sp40/cart";
	}
	
	@PostMapping("/cart/add")
	public String addCart(
			@RequestParam("name") String name,
			@RequestParam("price") Integer price,
			Model model
	) {
		Item item = new Item(name, price);
		
		model.addAttribute("item", item);
		
		return "sp40/cart";
	}
}
