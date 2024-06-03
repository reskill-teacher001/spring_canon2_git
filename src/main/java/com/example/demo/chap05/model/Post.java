package com.example.demo.chap05.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Post implements Serializable {
	private String title;
	private String content;
	private LocalDateTime createAt;
	
	public Post() {

	}
	
	public Post(String title, String content) {
		this.title = title;
		this.content = content;
		this.createAt = LocalDateTime.now();
	}
	
}
