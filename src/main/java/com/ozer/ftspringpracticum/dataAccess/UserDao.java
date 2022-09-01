package com.ozer.ftspringpracticum.dataAccess;

import com.ozer.ftspringpracticum.entities.concretes.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDao extends MongoRepository<User, Long> {
}
