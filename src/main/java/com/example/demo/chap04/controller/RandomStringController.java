package com.example.demo.chap04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.chap04.service.RandomStringService;

@Controller
@RequestMapping("/chap04")
public class RandomStringController {

	@Autowired // Springによるオブジェクトの管理（注入）
	RandomStringService service; // ランダム文字列生成サービス

	// 初期表示
	@GetMapping("/random")
	public String index() {
		return "chap04/random";
	}

	// 作成するボタンをクリックしたとき
	@PostMapping("/random")
	public String generate(
			@RequestParam(name="charLength") int charLength,
			@RequestParam(name = "withNumber", defaultValue = "false") boolean withNumber,
			Model model) {
		
		//RandomStringService service = new RandomStringService();

		// ランダム文字列のListを生成
		List<String> list = service.generate(charLength, withNumber);

		model.addAttribute("randList", list);

		return "chap04/random";
	}
}
