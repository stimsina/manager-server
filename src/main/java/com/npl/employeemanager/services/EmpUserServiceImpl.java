package com.npl.employeemanager.services;

import com.npl.employeemanager.model.EmpUser;
import com.npl.employeemanager.repository.EmpUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Qualifier("EmpUserService")
public class EmpUserServiceImpl implements  EmpUserService {

    //repositories
    @Autowired private EmpUserRepository empUserRepository;

    public Collection<EmpUser> getAllUsers(){
        Collection<EmpUser> allUsers=empUserRepository.findAll();
        return  allUsers;
    }

    @Override
    public EmpUser createUser(EmpUser empUser) {
        if(empUser.getId()!=null){
            return  null;
        }
        try {
            EmpUser savedUser=empUserRepository.save(empUser);
            return  savedUser;
        }
        catch (Exception e){
            System.out.println("error while saving user = " + e.getMessage());
            return null;
        }
    }

    @Override
    public EmpUser findOne(Long id) {
        EmpUser foundUser=empUserRepository.getOne(id);
        return foundUser;
    }

    @Override
    public EmpUser updateUser(EmpUser empUser) {
        if(empUser.getId()==null){
            return  null;
        }
        EmpUser updatedUser=empUserRepository.save(empUser);
        return  updatedUser;
    }

    @Override
    public void deleteUser(Long id) {
        empUserRepository.deleteById(id);
    }
}
