package com.arachidsocial.repositories;

import com.arachidsocial.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yassine on 2017-05-27.
 */
@Repository
public interface UserRepository extends MongoRepository<User,String> {
    public User findByUsername(String username);
}
