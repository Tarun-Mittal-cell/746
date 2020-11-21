package com.sam2021.sam2021.repository;

import java.util.List;
import java.util.Optional;

import com.sam2021.sam2021.models.Topic;
import com.sam2021.sam2021.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Query("FROM User WHERE id=?1")
    Optional<User> findById(Long id);

    @Query("FROM User WHERE account_type = 'Chairman'")
    List<User> getAllChairman();

    @Query("FROM User WHERE account_type = 'Chairman' or account_type = 'Member'")
    List<User> getChairandMeb();
    
    @Query("SELECT accountType FROM User WHERE email = ?1")
    String getEmailAccoutType(String email);

    @Query("SELECT id FROM User WHERE email = ?1")
    Long getEmailid(String email);

    @Query("DELETE FROM User WHERE email = ?1")
    String deleteUserByEmail(String email);

    @Query("SELECT email FROM User WHERE email =?1")
    Boolean existbyEmail(String Email);

    
    
}
