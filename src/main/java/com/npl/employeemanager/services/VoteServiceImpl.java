package com.npl.employeemanager.services;

import com.npl.employeemanager.model.Vote;
import com.npl.employeemanager.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired private VoteRepository voteRepository;

    @Override
    public Vote createVote(Vote vote) {

        if(vote.getId()!=null){
            return  null;
        }
        else{

          Vote savedVote= voteRepository.save(vote);
          return  savedVote;
        }
    }
}
