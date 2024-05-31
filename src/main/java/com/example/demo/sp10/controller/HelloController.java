package com.example.demo.sp10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sp10")
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "sp10/index";
	}

	@GetMapping("/hello")
	public String input() {
		return "sp10/input";
	}

	@PostMapping("/hello")
	public String show(
			@RequestParam(name="name", defaultValue="") String name,
			@RequestParam(name="age", defaultValue="0") Integer age,
			@RequestParam(name="hobby", defaultValue="") String hobby,
			Model model
	) {
		String memo = "未成年です";
		
		if (age >= 18) {
			memo = "成人してから" + (age - 18) + "年たちました";
		}
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("memo", memo);
		model.addAttribute("hobby", hobby);
		
		return "sp10/hello";
	}
}
