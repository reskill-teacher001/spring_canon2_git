package com.example.demo.chap07;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
	//SELECT id, name, age FROM members WHERE age > 引数
	public abstract List<Member> findByAgeGreaterThan(Integer age);
	
	//SELECT id, name, age FROM members WHERE age >= 引数
	public abstract List<Member> findByAgeGreaterThanEqual(Integer age);
	
	//SELECT id, name, age FROM members WHERE age BETWEEN 引数1 AND 引数2
	public abstract List<Member> findByAgeBetween(Integer age1, Integer age2);
	
	//SELECT id, name, age FROM members WHERE name LIKE '引数'
	public abstract List<Member> findByNameLike(String name);
	
	//SELECT id, name, age FROM members
	@Query(
			value="SELECT id, name, age FROM members",
			nativeQuery=true
	)
	public abstract List<Member> tsubaki();
	
	//SELECT id, name, age FROM members WHERE age BETWEEN 引数1 AND 引数2
	@Query(
			value="SELECT id, name, age FROM members WHERE age BETWEEN ?1 AND ?2",
			nativeQuery=true
	)
	public abstract List<Member> kudo(Integer age1, Integer age2);
}
