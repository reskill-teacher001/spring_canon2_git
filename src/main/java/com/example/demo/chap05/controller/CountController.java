package com.example.demo.chap05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.chap05.model.Counter;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/chap05")
public class CountController {
	
	//セッションオブジェクトの生成
	@Autowired
	private HttpSession session;
	
	//セッションオブジェクトの中のCounterクラスのインスタンスを生成
	@Autowired
	private Counter counter;
	
	@GetMapping("/counter")
	public String index() {
		//セッションオブジェクトを破棄する
		session.invalidate();
		
		return "chap05/counter2";
	}
	
	@GetMapping("/count_up")
	public String countUp(Model model) {
		Integer count = (Integer)session.getAttribute("COUNT");
		
		if (count == null) {
			count = 0;
		}
		
		count++;
		
		session.setAttribute("COUNT", count);
		
		model.addAttribute("count", count);
		
		return "chap05/counter";
	}
	
	@GetMapping("/count_up2")
	public String countUp2(Model model) {
		int number = counter.getNumber();
		
		number++;
		
		counter.setNumber(number);
		
		return "chap05/counter2";
	}
}
