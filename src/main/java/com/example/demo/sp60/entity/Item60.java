package com.example.demo.sp60.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="items")
public class Item60 {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; //ID
	
	@Column(name="category_id")
	private String categoryId; //カテゴリID
	
	private String name; //名前
	private Integer price; //価格
}
