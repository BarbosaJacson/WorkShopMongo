package com.barbosajacson.workshopmongo.repository;

import com.barbosajacson.workshopmongo.domain.Post;
import com.barbosajacson.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {

}
