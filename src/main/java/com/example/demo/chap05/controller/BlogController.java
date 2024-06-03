package com.example.demo.chap05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.chap05.model.Account;
import com.example.demo.chap05.model.Post;
import com.example.demo.chap05.model.PostList;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/chap05")
public class BlogController {
	@Autowired
	private HttpSession session;

	@Autowired
	private Account account;

	@Autowired
	private PostList postList;

	@GetMapping({"/", "/logout"})
	public String index() {
		session.invalidate();
		
		return "chap05/login";
	}

	@PostMapping("/login")
	public String login(
		@RequestParam("name") String name,
		Model model
	) {
		account.setName(name);
		
		return "chap05/blog";
	}

	@PostMapping("/blog")
	public String blog(
			@RequestParam("title") String title,
			@RequestParam("content") String content,
		Model model
	) {
		Post post = new Post(title, content);
		
		List<Post> posts = postList.getPosts();
		posts.add(post);
		
		return "chap05/blog";
	}
}
