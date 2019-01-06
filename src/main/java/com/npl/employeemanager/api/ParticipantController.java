package com.npl.employeemanager.api;

import com.npl.employeemanager.model.Participant;
import com.npl.employeemanager.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin()
@RestController
public class ParticipantController {

    @Autowired private ParticipantService participantService;

    @RequestMapping(
            value = "/api/participants",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Participant> createParticipant(@RequestBody Participant restParticipant){

        if(restParticipant.getId()!=null){
            return  null;
        }
        Participant savedParticipant=participantService.createParticipant(restParticipant);
        return  new ResponseEntity<Participant>(savedParticipant, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/participants",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Collection<Participant> getAllParticipants(){
        return participantService.getAllParticipants();
    }
}
