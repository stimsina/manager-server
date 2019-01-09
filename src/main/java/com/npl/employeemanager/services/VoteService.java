package com.npl.employeemanager.services;

import com.npl.employeemanager.model.Vote;
import org.springframework.stereotype.Service;

@Service
public interface VoteService {

    public Vote createVote(Vote vote);

}
