package com.example.demo.sp51.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.sp50.entity.Item;
import com.example.demo.sp51.repository.ItemRepository51;

@Controller
@RequestMapping("/sp51")
public class ItemController51 {
	
	@Autowired
	ItemRepository51 itemRepository;
	
	@GetMapping("/items")
	public String index(
			@RequestParam(name="sort", required=false) String sort,
			@RequestParam(name="maxPrice", required=false) Integer maxPrice,
			@RequestParam(name="keyword", required=false) String keyword,
			Model model
	) {
		List<Item> list = null;
		
		if (sort == null && maxPrice == null && keyword == null) {
			list = itemRepository.findAll();
		}
		
		if (sort != null) {
			list = itemRepository.findByOrderByPriceAsc();
		}
		
		if (maxPrice != null && keyword == null) {
			list = itemRepository.findByPriceLessThanEqual(maxPrice);
		}
		
		if (maxPrice == null && keyword != null) {
			list = itemRepository.findByNameLike("%" + keyword + "%");
		}
		
		if (maxPrice != null && keyword != null) {
			list = itemRepository.findByPriceLessThanEqualAndNameLike(maxPrice, "%" + keyword + "%");
		}
		
		model.addAttribute("list", list);
		model.addAttribute("maxPrice", maxPrice);
		model.addAttribute("keyword", keyword);
		
		return "sp51/items";
	}
}
