package com.example.demo.sp30.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Account implements Serializable {
	//フィールド
	private String name;     //名前
	private String email;    //Eメール
	private String password; //パスワード
	
	public Account() {

	}
	
	public Account(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
}
