package com.example.demo.sp50.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.sp50.entity.Item;
import com.example.demo.sp50.repository.ItemRepository;

@Controller
@RequestMapping("/sp50")
public class ItemController50 {
	
	@Autowired
	ItemRepository itemRepository;
	
	@GetMapping("/items")
	public String index(
			@RequestParam(name="sort", required=false) String sort,
			Model model
	) {
		List<Item> list = null;
		
		if (sort == null) {
			list = itemRepository.findAll();
		} else if (sort.equals("priceAsc")) {
			list = itemRepository.findByOrderByPriceAsc();
		}
		
		model.addAttribute("list", list);
		
		return "sp50/items";
	}
}
