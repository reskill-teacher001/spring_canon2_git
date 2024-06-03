package com.example.demo.sp30.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.sp30.model.Account;

@Controller
@RequestMapping("/sp30")
public class AccountController {

	@GetMapping("/account")
	public String index(Model model) {
		
		Account account = new Account();
		model.addAttribute("account", account);
		
		return "/sp30/accountForm";
	}

	@PostMapping("/account/confirm")
	public String confirm(
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			Model model
	) {
		List<String> errors = new ArrayList<>();
		
		if (name.equals("")) {
			errors.add("名前は必須です");
		}
		
		if (name.length() > 20) {
			errors.add("名前は20文字以内で入力してください");
		}
		
		if (email.equals("")) {
			errors.add("メールアドレスは必須です");
		}
		
		if (password.equals("")) {
			errors.add("パスワードは必須です");
		}
		
		//Accountクラスのインスタンスを生成
		Account account = new Account(name, email, password);
		
		if (errors.size() > 0) {
			model.addAttribute("errors", errors);
			model.addAttribute("account", account);
			
			return "sp30/accountForm";
		}
		
		//Modelに記憶
		model.addAttribute("account", account);
		
		return "sp30/accountConfirm";
	}
}
