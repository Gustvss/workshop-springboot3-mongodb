package com.tcser.workshopmongo.repositories;

import com.tcser.workshopmongo.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User getReferenceById(String id);
}
