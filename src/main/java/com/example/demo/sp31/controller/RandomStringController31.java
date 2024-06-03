package com.example.demo.sp31.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.sp31.service.RandomStringService31;

@Controller
@RequestMapping("/sp31")
public class RandomStringController31 {

	@Autowired // Springによるオブジェクトの管理（注入）
	RandomStringService31 service; // ランダム文字列生成サービス

	// 初期表示
	@GetMapping("/random")
	public String index() {
		return "sp31/random";
	}

	// 作成するボタンをクリックしたとき
	@PostMapping("/random")
	public String generate(
			@RequestParam(name="charLength") int charLength,
			@RequestParam(name = "withNumber", defaultValue = "false") boolean withNumber,
			@RequestParam(name = "withAlphabet", defaultValue = "false") boolean withAlphabet,
			@RequestParam(name="createCount", defaultValue = "1") int createCount,
			Model model) {
		
		//RandomStringService service = new RandomStringService();

		// ランダム文字列のListを生成
		List<String> list = service.generate(charLength, withNumber, withAlphabet, createCount);

		model.addAttribute("randList", list);
		
		model.addAttribute("charLength", charLength);
		model.addAttribute("withNumber", withNumber);
		model.addAttribute("withAlphabet", withAlphabet);
		model.addAttribute("createCount", createCount);
		
		return "sp31/random";
	}
}
