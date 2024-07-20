package com.rss.resurv.service;

import com.rss.resurv.model.Staff;
import com.rss.resurv.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffLoginService {

    @Autowired
    private StaffRepository staffRepository;

    public String validateLogin(String email, String password) {
        List<Staff> staffs = staffRepository.findByEmailAndPassword(email, password);

        if (staffs.isEmpty()) {
            return "Invalid email or password";
        }
        return "Login successful";
    }

    public Staff findStaffByEmail(String email) {
        return staffRepository.findByEmail(email);
    }
}
