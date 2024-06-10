package com.example.demo.chap00;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Users")
public class User00 {
	@Id
	private Integer id;
	private String name;
	private Integer age;
	
}
