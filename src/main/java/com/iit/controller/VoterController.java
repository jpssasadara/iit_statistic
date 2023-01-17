package com.iit.controller;

import com.iit.service.VoterService;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/voters/statistic")
public class VoterController {

    Logger logger = LoggerFactory.getLogger(VoterController.class);
    @Autowired
    private VoterService voterService;

    @GetMapping
    public Report getStatic(){
        logger.info("In getStatic Method");
        long numberOfActiveUsers = voterService.countByStatus(true);
        long numberOfInActiveUsers = voterService.countByStatus(false);
        long numberOfEligibleVoters = voterService.countByEligibility(18);
        long numberOfNonEligibleVoters =voterService.countByEligibility(0) - voterService.countByEligibility(18);
        return new Report(numberOfActiveUsers, numberOfInActiveUsers, numberOfEligibleVoters, numberOfNonEligibleVoters);
    }
    @Data
    class Report {
        private long numberOfActiveUsers;
        private long numberOfInActiveUsers;
        private long numberOfEligibleVoters;
        private long numberOfNonEligibleVoters;

        public Report(long numberOfActiveUsers, long numberOfInActiveUsers, long numberOfEligibleVoters, long numberOfNonEligibleVoters) {
            this.numberOfActiveUsers = numberOfActiveUsers;
            this.numberOfInActiveUsers = numberOfInActiveUsers;
            this.numberOfEligibleVoters = numberOfEligibleVoters;
            this.numberOfNonEligibleVoters = numberOfNonEligibleVoters;
        }
    }
}

