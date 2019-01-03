package com.npl.employeemanager.repository;

import com.npl.employeemanager.model.EmpUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpUserRepository extends JpaRepository<EmpUser,Long> {
}
