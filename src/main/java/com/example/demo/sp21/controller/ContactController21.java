package com.example.demo.sp21.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sp21")
public class ContactController21 {

	@GetMapping("/contact")
	public String index() {
		return "sp21/contactForm";
	}

	@PostMapping("/contact")
	public String contact(
			@RequestParam("genre") Integer genre,
			@RequestParam(name="lang", required=false) String[] lang,
			@RequestParam("detail") String detail,
			@RequestParam(name="dueDate", required=false) LocalDate dueDate,
			@RequestParam(name="name", required=false) String name,
			@RequestParam("email") String email,
			Model model
	) {
		List<String> errors = new ArrayList<>();
		
		if (name == null) {
			return "sp21/contactForm";
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
			return "sp21/contactForm";
		}
		
		String langList = "";
		
		if (lang != null) {
			for (String la : lang) {
				langList += la + "研修,";
			}
		}
		
		model.addAttribute("genre", genre == 1 ? "資料請求" : "見積り依頼");
		model.addAttribute("langList", langList);
		model.addAttribute("lang", genre == 1 ? lang : null);
		model.addAttribute("detail", detail);
		model.addAttribute("dueDate", dueDate);
		model.addAttribute("name", name);
		model.addAttribute("email", email);

		return "sp21/contactResult";
	}
	
	@GetMapping("/training/{lang}")
	public String training(
			@PathVariable("lang") String lang,
			Model model
	) {
		String description = "";
		
		switch (lang) {
		case "Java":
			description = "大規模開発でオールラウンドで活躍できるエンジニアを育成します";
			break;
		case "PHP":
			description = "Webアプリケーションに特化して活躍できるエンジニアを育成します";
			break;
		case "Python":
			description = "AI開発やデータ分析の領域で活躍できるエンジニアを育成します";
			break;
		}

		model.addAttribute("lang", lang);
		model.addAttribute("description", description);

		return "sp21/infoTraining";
	}

}
