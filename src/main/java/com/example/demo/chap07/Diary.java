package com.example.demo.chap07;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="diaries")
public class Diary {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer no; //ID
//	@Column(name="member_id")
//	private Integer memberId; //メンバーID
	
	@OneToOne
	@JoinColumn(name="mem_id")
	private Member member;
	
	private LocalDate date; //年月日
	private String content; //内容
	
	public Diary(Member member, LocalDate date, String content) {
		this.member = member;
		this.date = date;
		this.content = content;
	}
	
	
	public Diary(Integer no, Member member, LocalDate date, String content) {
		this.no = no;
		this.member = member;
		this.date = date;
		this.content = content;
	}
	
	
}
