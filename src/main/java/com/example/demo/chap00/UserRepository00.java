package com.example.demo.chap00;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository00 extends JpaRepository<User00, Integer> {

}
