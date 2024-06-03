package com.example.demo.chap05.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;

@Data
@SessionScope
@Component
public class PostList {
	private List<Post> posts = new ArrayList<>();
}
