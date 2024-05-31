package com.example.demo.chap04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.chap04.model.Item;

@Controller
@RequestMapping("/chap04")
public class ItemController {
	// 初期画面表示
	@GetMapping("/item")
	public String index() {
		return "chap04/item";
	}

	// 登録ボタンクリック時
	@PostMapping("/item")
	public String add(
			@RequestParam("name") String name,
			@RequestParam("price") Integer price,
			Model model) {

		// Itemクラスのオブジェクト（モデル）を生成
		Item item = new Item(name, price);
		// Thymeleafに渡すデータ（モデル）を追加
		model.addAttribute("item", item);
		// itme.htmlを出力
		return "chap04/item";
	}
}
