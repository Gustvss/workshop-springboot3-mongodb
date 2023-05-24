package com.tcser.workshopmongo.repositories;

import com.tcser.workshopmongo.entities.Post;
import com.tcser.workshopmongo.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    Post getReferenceById(String id);
    List<Post> findByTitleContainingIgnoreCase(String text);
}
