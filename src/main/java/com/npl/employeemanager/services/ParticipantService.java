package com.npl.employeemanager.services;

import com.npl.employeemanager.model.Participant;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface ParticipantService {

    public Participant createParticipant(Participant restParticipant);

    public Participant updateParticipant(Participant restParticipant);

    public Collection<Participant> getAllParticipants();

    public void deleteParticipantById(Long id);
}
