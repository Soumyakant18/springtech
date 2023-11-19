package com.example.springtech.service;

import com.example.springtech.entity.Login;

import java.util.List;

public interface LoginService1 {
    Login saveDetails (Login student);

    List<Login> getAllStudents();

    Login getUserByUsernameOrEmail(String username, String password);
}
