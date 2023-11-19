package com.example.prctice1.service;

import com.example.prctice1.entity.Login;

import java.util.List;

public interface LoginService1 {
    Login saveDetails (Login student);

    List<Login> getAllStudents();

    Login getUserByUsernameOrEmail(String username, String password);
}
