package com.example.demo.sp50.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.sp50.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
	public List<Item> findByOrderByPriceAsc();
	public List<Item> findByPriceLessThanEqual(Integer price);
	public List<Item> findByNameLike(String keyword);
}
