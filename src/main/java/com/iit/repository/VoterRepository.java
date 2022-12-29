package com.iit.repository;

import com.iit.model.Voter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface VoterRepository extends MongoRepository<Voter,String> {
    @Query(value = "{isActive: ?0}", count = true)
    public long countByStatus(boolean isActive);

    @Query(value ="{age : {$gte : ?0} }", count = true)
    public long countByEligibility(int age);

}
