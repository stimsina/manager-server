package com.npl.employeemanager.api;

import com.npl.employeemanager.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParticipantController {

    @Autowired private ParticipantService participantService;
}
