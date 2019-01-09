package com.npl.employeemanager.cronjobs;

import com.npl.employeemanager.model.EmpUser;
import com.npl.employeemanager.services.EmpUserService;
import com.npl.employeemanager.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class UpdateUserStatusScheduler {

    @Autowired
    @Qualifier("EmpUserService")
    private EmpUserService empUserService;

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    private static int CUTOFF_DAYS=15;

    @Scheduled(cron = "0 0 0 * * *")
    public void  inActivateDormantUsers(){

        logger.info("user update method started >>>>>>>>>>>>>>>>>>>>");

        Collection<EmpUser>allUsers=empUserService.getAllUsers();

        new ArrayList<>(allUsers).stream().filter(empUser ->DateUtils.getDaysBetweenLocalDateTimes(empUser.getLoginDateTime(),
                LocalDateTime.now())>=CUTOFF_DAYS).forEach(fEmp->{
                    fEmp.setActive(false);
                    empUserService.updateUser(fEmp);
        });

        logger.info("<<<<<<<<<<<<<<<<<<<<<user update method completed");

    }
}
