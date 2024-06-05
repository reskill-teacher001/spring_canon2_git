package com.example.demo.chap07;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Members")
public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; //ID
	
	@Column(name="name")
	private String name; //名前
	private Integer age; //年齢
	
	public Member() {

	}
	
	public Member(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	public Member(Integer id, String name, Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
}
