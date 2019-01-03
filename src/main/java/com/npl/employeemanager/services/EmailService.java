package com.npl.employeemanager.services;

import com.npl.employeemanager.model.EmpUser;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface EmailService {

    public void sendWelcomeEmail(EmpUser empUser) throws IOException;
}
