package com.example.demo.chap05.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;

@Data
@SessionScope
@Component
public class Counter implements Serializable {
	private int number;
}
