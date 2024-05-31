package com.example.demo.sp10.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sp10")
public class OmikujiController {

	@GetMapping("/omikuji")
	public String index() {
		return "sp10/omikujia";
	}

	@PostMapping("/omikuji")
	public String omikuji(Model model) {
		String[] kuji = {"大吉", "吉", "凶", "吉", "小吉", "吉"};

		Random rand = new Random();
		int num = rand.nextInt(6);

		String result = kuji[num];
		model.addAttribute("result", result);

		return "sp10/omikuji";
	}
}
