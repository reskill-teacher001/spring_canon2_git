package com.example.demo.sp11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sp11")
public class LoginController {

	@GetMapping("/login")
	public String index() {
		return "sp11/login";
	}

	@PostMapping("/login")
	public String login(
			@RequestParam("userId") String userId,
			@RequestParam("password") String password,
			Model model
	) {
		//ログイン成功
		if (userId.equals("student") && password.equals("himitu")) {
			return "sp11/index";
		}
		
		//ログイン失敗
		String error = "ログインできません。";
		
		if (!userId.equals("student") && password.equals("himitu")) {
			error = "ユーザIDが一致しませんでした";
		} else if (userId.equals("student") && !password.equals("himitu")) {
			error = "パスワードが一致しませんでした";
		}
		
		model.addAttribute("error", error);
		
		return "sp11/login";
	}
}
