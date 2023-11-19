package com.example.springtech.service;

import com.example.springtech.entity.Login;
import com.example.springtech.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService implements LoginService1 {

    @Autowired
    private LoginRepo loginRepo;

    @Override
    public Login saveDetails(Login student) {
        return loginRepo.save(student);
    }

    @Override
    public List<Login> getAllStudents() {
        return loginRepo.findAll();
    }

    @Override
    public Login getUserByUsernameOrEmail(String username, String password) {
        Optional<Login> user = loginRepo.findByUsername(username);

        if (user.isPresent()) {
            String storedPassword = user.get().getPassword();
            if (storedPassword.equals(password)) {
                System.out.println(user.get());
                return user.get();
            }else {
                return null;
            }
        }


        return null;
    }
}
