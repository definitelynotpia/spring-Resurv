package com.rss.resurv.service;

import com.rss.resurv.model.Manager;
import com.rss.resurv.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerLoginService {

    @Autowired
    private ManagerRepository managerRepository;

    public String validateLogin(String email, String password) {
        List<Manager> managers = managerRepository.findByEmailAndPassword(email, password);

        if (managers.isEmpty()) {
            return "Invalid email or password";
        }
        return "Login successful";
    }

    public Manager findManagerByEmail(String email) {
        return managerRepository.findByEmail(email);
    }
}
