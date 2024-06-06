package com.example.demo.sp60.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.sp50.entity.Item;
import com.example.demo.sp60.repository.ItemRepository60;

@Controller
@RequestMapping("/sp60")
public class ItemController60 {
	
	@Autowired
	ItemRepository60 itemRepository;

	@GetMapping("/items")
	public String index(Model model) {
		List<Item> list = itemRepository.findAll();
		
		model.addAttribute("list", list);
		
		return "sp60/items";
	}
	
	@GetMapping("/items/add")
	public String create() {
		return "sp60/addItem";
	}
	
	@PostMapping("/items/add")
	public String store(
			@RequestParam(name="categoryId", required=false) Integer categoryId,
			@RequestParam(name="name", required=false) String name,
			@RequestParam(name="price", required=false) Integer price,
			Model model
	) {
		Item item = new Item(categoryId, name, price);
		
		itemRepository.saveAndFlush(item);
		//itemRepository.save(item);
		
		//return index(model);
		return "redirect:/sp60/items";
	}
}
