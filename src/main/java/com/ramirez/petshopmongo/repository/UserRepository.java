package com.ramirez.petshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ramirez.petshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
}
