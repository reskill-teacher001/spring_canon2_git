package com.example.demo.sp51.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.sp50.entity.Item;

@Repository
public interface ItemRepository51 extends JpaRepository<Item, Integer> {
	public List<Item> findByOrderByPriceAsc();
	public List<Item> findByPriceLessThanEqual(Integer price);
	public List<Item> findByPriceLessThanEqualOrderByPriceAsc(Integer price);
	public List<Item> findByNameLike(String keyword);
	public List<Item> findByNameLikeOrderByPriceAsc(String keyword);
	public List<Item> findByPriceLessThanEqualAndNameLike(Integer price, String keyword);
	public List<Item> findByPriceLessThanEqualAndNameLikeOrderByPriceAsc(Integer price, String keyword);

	@Query(
			value="INSERT INTO items(category_id, name, price) VALUES(?1, ?2, ?3)",
			nativeQuery=true
	)
	@Modifying(clearAutomatically = true)
	int touroku(Integer categoryId, String name, Integer price);
}
