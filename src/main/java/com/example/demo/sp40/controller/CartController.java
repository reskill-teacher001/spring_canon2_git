package com.example.demo.sp40.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.sp40.model.Cart;
import com.example.demo.sp40.model.Item;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/sp40")
public class CartController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	Cart cart;
	
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
		
		List<Item> items = cart.getItems();
		items.add(item);
		
		return "sp40/cart";
	}
	
	@GetMapping("/cart/clear")
	public String clearCart() {
		List<Item> items = cart.getItems();
		items.clear();
		
		return "sp40/cart";
	}
}
