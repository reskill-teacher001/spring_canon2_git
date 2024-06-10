package com.example.demo.chap00;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;

@Data
@SessionScope
@Component
public class Account00 {
	private String name;
}
