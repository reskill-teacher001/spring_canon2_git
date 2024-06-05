package com.example.demo.chap07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.transaction.Transactional;

@Controller
public class DatabaseController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	DiaryRepository diaryRepository;
	
	@GetMapping("/db01")
	public String db01(Model model) {
		//全件検索
		List<User> list = userRepository.findAll();
		
		model.addAttribute("list", list);
		
		return "chap07/db01";
	}
	
	@GetMapping("/db11")
	public String db11(Model model) {
		//全件検索
		List<Member> list = memberRepository.findAll();
		//List<Member> list = memberRepository.findByAgeGreaterThan(23);
		//List<Member> list = memberRepository.findByAgeGreaterThanEqual(23);
		//List<Member> list = memberRepository.findByAgeBetween(23, 24);
		//List<Member> list = memberRepository.findByNameLike("%田%");
		//List<Member> list = memberRepository.tsubaki();
		//List<Member> list = memberRepository.kudo(23, 24);
		
		model.addAttribute("list", list);
		
		return "chap07/db11";
	}
	
	@GetMapping("/db21")
	public String db21(Model model) {
		//全件検索
		List<Diary> list = diaryRepository.findAll();
		
		model.addAttribute("list", list);
		
		return "chap07/db21";
	}
	
	@GetMapping("/db02")
	public String db02(Model model) {
//		User user = null;
//		
//		//単一検索
//		Optional<User> record = userRepository.findById(1);
//		
//		if (record.isEmpty() == false) { //レコードがあれば
//			user = record.get();
//		}
		
		User user = userRepository.findById(1).get();
		
		model.addAttribute("user", user);
		
		return "chap07/db02";
	}
	
	@GetMapping("/db12")
	public String db12(Model model) {
//		User user = null;
//		
//		//単一検索
//		Optional<User> record = userRepository.findById(1);
//		
//		if (record.isEmpty() == false) { //レコードがあれば
//			user = record.get();
//		}
		
		Member member = memberRepository.findById(1).get();
		
		model.addAttribute("member", member);
		
		return "chap07/db12";
	}
	
	@Transactional //トランザクション処理用のアノテーション「
	@GetMapping("/db03")
	public String db03(Model model) {
		User user = new User(5, "小川", 24);
		
		User user1 = userRepository.saveAndFlush(user);
		
		model.addAttribute("result", "成功");
		
		return "chap07/db03";
	}
	
	@Transactional //トランザクション処理用のアノテーション「
	@GetMapping("/db13")
	public String db13(Model model) {
		Member member = new Member("工藤", 23);
		
		memberRepository.saveAndFlush(member);
		
		model.addAttribute("result", "成功");
		
		return "chap07/db03";
	}
	
	@Transactional //トランザクション処理用のアノテーション「
	@GetMapping("/db04")
	public String db04(Model model) {
//		User user = new User(5, "小川", 24);
//		
//		userRepository.delete(user);
		
		userRepository.deleteById(5);
		
		model.addAttribute("result", "成功");
		
		return "chap07/db03";
	}
}
