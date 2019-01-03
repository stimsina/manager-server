package com.npl.employeemanager.services;

import com.npl.employeemanager.model.EmpUser;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface EmpUserService {

    public Collection<EmpUser> getAllUsers();

    public EmpUser createUser(EmpUser empUser);

    public EmpUser findOne(Long id);

    public EmpUser updateUser(EmpUser empUser);

    public void deleteUser(Long id);
}
