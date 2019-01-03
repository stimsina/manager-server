package com.npl.employeemanager.services;

import com.npl.employeemanager.model.Participant;
import com.npl.employeemanager.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    //repositories
    @Autowired private ParticipantRepository participantRepository;

    @Override
    public Participant createParticipant(Participant restParticipant) {
        if(restParticipant.getId()!=null){
            return null;
        }
        Participant savedParticipant=participantRepository.save(restParticipant);
        return savedParticipant;
    }

    @Override
    public Participant updateParticipant(Participant restParticipant) {
        if(restParticipant.getId()==null){
            return  null;
        }
        Participant updatedParticipant=participantRepository.save(restParticipant);
        return updatedParticipant;
    }

    @Override
    public Collection<Participant> getAllParticipants() {
        Collection<Participant> allParticipants=participantRepository.findAll();
        return allParticipants;
    }

    @Override
    public void deleteParticipantById(Long id) {
        participantRepository.deleteById(id);

    }
}
