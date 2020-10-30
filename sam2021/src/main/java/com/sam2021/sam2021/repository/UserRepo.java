package com.sam2021.sam2021.repository;

import com.sam2021.sam2021.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    User findByEmail(String email);
    
    @Query("SELECT accountType FROM User WHERE email = ?1")
    String getEmailAccoutType(String email);
    
}
