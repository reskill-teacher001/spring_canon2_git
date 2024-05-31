package com.example.demo.sp20.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sp20")
public class ContactController {

	@GetMapping("/contact")
	public String index() {
		return "sp20/contactForm";
	}

	@PostMapping("/contact")
	public String contact(
			@RequestParam("genre") String genre,
			@RequestParam(name="lang", required=false) String[] lang,
			@RequestParam("detail") String detail,
			@RequestParam(name="dueDate", required=false) LocalDate dueDate,
			@RequestParam(name="name", required=false) String name,
			@RequestParam("email") String email,
			Model model
	) {
		List<String> errors = new ArrayList<>();
		
		if (name == null) {
			return "sp20/contactForm";
		}
		
		if (lang == null) {
			errors.add("言語は必須です");
		}
		
		if (dueDate != null) {
			LocalDate today = LocalDate.now();
			
			//if (dueDate.isEqual(today) || dueDate.isBefore(today)) {
			if (!dueDate.isAfter(today)) {
				errors.add("実施予定日は翌日以降を選択してください");
			}
		}
		
		if (name.equals("")) {
			errors.add("名前は必須です");
		}
		
		if (name.length() > 20) {
			errors.add("名前は20文字以内で入力してください");
		}
		
		if (email.equals("")) {
			errors.add("メールアドレスは必須です");
		}
		
		if (errors.size() > 0) {
			model.addAttribute("errors", errors);
			return "sp20/contactForm";
		}
		
		String langList = "";
		
		if (lang != null) {
			for (String la : lang) {
				langList += la + ",";
			}
		}
		
		model.addAttribute("genre", genre);
		model.addAttribute("langList", langList);
		model.addAttribute("detail", detail);
		model.addAttribute("dueDate", dueDate);
		model.addAttribute("name", name);
		model.addAttribute("email", email);

		return "sp20/contactResult";
	}
}
