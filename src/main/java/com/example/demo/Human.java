package com.example.demo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Human implements Serializable {
	//フィールド
//	@Setter
//	@Getter
	private String name; //名前
	
//	@Setter
//	@Getter
	private int age;     //年齢
	
	//コンストラクタ
	public Human() {

	}
	
	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
