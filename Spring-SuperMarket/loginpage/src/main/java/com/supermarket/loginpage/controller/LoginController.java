package com.supermarket.loginpage.controller;

import org.springframework.web.bind.annotation.RestController;

import com.supermarket.loginpage.model.LoginPage;
import com.supermarket.loginpage.services.LoginService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
public class LoginController {
    private LoginService loginService;
    public LoginController(LoginService loginService){
        this.loginService=loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginPage> postlogin(@RequestBody LoginPage loginPage) {
        LoginPage logpage=loginService.saveLogin(loginPage);
        if(logpage!=null)
            return new ResponseEntity<>(logpage,HttpStatus.CREATED);
        return new ResponseEntity<>(logpage,HttpStatus.NOT_FOUND);    
    }

    @GetMapping("/loginpage")
    public ResponseEntity<List<LoginPage>> getloginPages() {
        List<LoginPage>li=loginService.getloginPage();
        if(li!=null)
            return new ResponseEntity<>(li,HttpStatus.OK);
        return new ResponseEntity<>(li,HttpStatus.NOT_FOUND)  ;  
    }

    @GetMapping("/loginpages/{customerId}")
    public ResponseEntity<LoginPage> getloginPage(@PathVariable("customerId") int customerId) {
        LoginPage getlog=loginService.getbyloginId(customerId);
        if(getlog!=null)
            return new ResponseEntity<>(getlog,HttpStatus.CREATED);
        return new ResponseEntity<>(getlog,HttpStatus.NOT_FOUND);    
        
    }

    @PutMapping("/loginpages/{customerId}")
    public ResponseEntity<LoginPage> putloginId(@PathVariable("customerId") int customerId, @RequestBody LoginPage loginPage){
        LoginPage putlog=loginService.putbyloginId(customerId,loginPage);
        if(putlog!=null)
            return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);    
    }
    
    @DeleteMapping("/loginpagess/{customerId}")
    public void delbyloginId(@PathVariable("customerId") int customerId){
        loginService.delloginbyId(customerId);
    }
}
