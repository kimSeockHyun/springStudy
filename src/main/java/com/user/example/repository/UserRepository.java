package com.user.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.example.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
	Users findByUserIdAndUserPw(String user_id, String user_pw);
}
