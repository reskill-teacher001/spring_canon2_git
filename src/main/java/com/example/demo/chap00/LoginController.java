package com.example.demo.chap00;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/chap00")
public class LoginController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	UserRepository00 userRepository;
	
	@Autowired
	Account00 account;

	@GetMapping({"/login", "/logout"})
	public String index() {
		session.invalidate();
		
		return "chap00/index";
	}

	@PostMapping("/login")
	public String login(
		@RequestParam("id") Integer id,
		Model model
	) {
		User00 user = null;
		
		Optional<User00> record = userRepository.findById(id);
		
		if (record.isEmpty() == false) {
			user = record.get();
		}
		
		if (user == null) {
			model.addAttribute("error", "ログインできません");
			return "chap00/index";
		}
		
		String name = user.getName();
		account.setName(name);
		
		return "chap00/main";
	}
}
