package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/jmaster")
public class MyController01 {

	@GetMapping({"/start", "/end"})
	public String start01() {
		return "view01";
	}
	
	@GetMapping("/second")
	public String second(Model m) {
		m.addAttribute("name", "山田太郎");
		m.addAttribute("age", 23);
		//m.addAttribute("data", "<a href='https://www.yahoo.co.jp'>キヤノン</a>");
		
		String[] list = {"遠藤", "椿", "東海林"};
		m.addAttribute("list", list);
		
		m.addAttribute("data", 1);
		
		return "view02";
	}
	
	@GetMapping("/third")
	public String third(Model m) {
		Human h = new Human("山田太郎", 23);
		
		m.addAttribute("h", h);
		
		return "view03";
	}
	
	@GetMapping("/send01")
	public String send01() {
		return "send01";
	}
	
	@GetMapping("/receive01")
	public String receive01(
			Model m,
			@RequestParam(name="name", defaultValue="名前なし") String name,
			@RequestParam(name="age", defaultValue="0") Integer age,
			@RequestParam(name="fruits", required=false) String[] fruits
	) {
		m.addAttribute("name", name);
		m.addAttribute("age", age);
		m.addAttribute("fruits", fruits);
		m.addAttribute("id", 1);
		
		return "receive01";
	}
	
	@GetMapping("/fourth/{data}")
	public String fourth(
			Model m,
			@PathVariable("data") String data
	) {
		m.addAttribute("data", data);
		
		return "view04";
	}
}
