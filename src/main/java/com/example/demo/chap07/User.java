package com.example.demo.chap07;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Users")
public class User {
	@Id
	private Integer id; //ID
	
	@Column(name="name")
	private String name; //名前
	private Integer age; //年齢
	
	public User() {

	}
	
	public User(Integer id, String name, Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
}
