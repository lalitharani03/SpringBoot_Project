package com.supermarket.loginpage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LoginPage {
    @Id
    private int customerId;
    private String password;
    public LoginPage(){}
    public int getCustomerId() {
        return customerId;
    }
    public void setcustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
}
