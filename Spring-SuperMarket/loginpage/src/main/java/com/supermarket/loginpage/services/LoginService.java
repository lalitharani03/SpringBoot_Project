package com.supermarket.loginpage.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.supermarket.loginpage.model.LoginPage;
import com.supermarket.loginpage.repository.LoginRepo;

@Service
public class LoginService {
    private LoginRepo loginRepo;
    public LoginService(LoginRepo loginRepo){
        this.loginRepo=loginRepo;
    }
    public LoginPage saveLogin(LoginPage loginPage){
            return loginRepo.save(loginPage);
            
    }
    public List<LoginPage> getloginPage(){
           return loginRepo.findAll();
    }
    public LoginPage getbyloginId(int customerId){
          return loginRepo.findById(customerId).orElse(new LoginPage());
    }
    public LoginPage putbyloginId(int customerId,LoginPage loginPage){
        return loginRepo.findById(customerId).orElse(null);
    }
    public void delloginbyId(int customerId){
        loginRepo.deleteById(customerId);
    }
}
