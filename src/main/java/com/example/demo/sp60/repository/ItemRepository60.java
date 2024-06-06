package com.example.demo.sp60.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.sp50.entity.Item;

@Repository
public interface ItemRepository60 extends JpaRepository<Item, Integer> {

}
