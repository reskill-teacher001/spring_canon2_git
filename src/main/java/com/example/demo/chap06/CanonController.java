package com.example.demo.chap06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/canon")
public class CanonController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	User user;

	@GetMapping({"/index", "/logout"})
	public String index() {
		session.invalidate();
		
		return "chap06/index";
	}

	@GetMapping("/test01")
	public String test01(
		@RequestParam(name="name", required=false) String name
	) {
		if (name != null) {
			user.setName(name);
		}
		
		return "chap06/test01";
	}

	@GetMapping("/test02")
	public String test02() {
		//int result = 10 / 0;
		
		return "chap06/test02";
	}
}
