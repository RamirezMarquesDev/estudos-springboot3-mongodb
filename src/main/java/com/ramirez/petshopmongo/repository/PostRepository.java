package com.ramirez.petshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ramirez.petshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
