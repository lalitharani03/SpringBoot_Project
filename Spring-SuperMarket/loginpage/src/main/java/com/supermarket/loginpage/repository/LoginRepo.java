package com.supermarket.loginpage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermarket.loginpage.model.LoginPage;

public interface LoginRepo extends JpaRepository<LoginPage,Integer> {
    
}
