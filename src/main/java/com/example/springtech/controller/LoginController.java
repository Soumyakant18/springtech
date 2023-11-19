package com.example.springtech.controller;

import com.example.springtech.entity.Login;
import com.example.springtech.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class LoginController {
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService studentService)
    {
        this.loginService=studentService;
    }

    @PostMapping("/api/student")
    public ResponseEntity<Login> saveEmployeeDetails(@RequestBody Login student){
        return new ResponseEntity<Login>(loginService.saveDetails(student), HttpStatus.CREATED);
    }

    @GetMapping("/login/{usernameOrEmail}/{password}")
    public Login getUserByUsernameOrEmail(@PathVariable String usernameOrEmail, @PathVariable String password) {
        return loginService.getUserByUsernameOrEmail(usernameOrEmail,password);
    }

}

