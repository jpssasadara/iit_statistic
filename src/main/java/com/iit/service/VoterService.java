package com.iit.service;

import com.iit.model.Voter;
import com.iit.repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoterService {

    @Autowired
    private VoterRepository voterRepository;


    public long countByStatus(boolean isActive){
        return voterRepository.countByStatus(isActive);
    }

    public long countByEligibility(int age){
        return voterRepository.countByEligibility(age);
    }
}
