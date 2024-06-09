package com.rishav.coderhack.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.rishav.coderhack.entity.*;

@Repository
public interface Userrepo extends MongoRepository<User, String>{

}
