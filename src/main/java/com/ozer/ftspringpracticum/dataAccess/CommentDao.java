package com.ozer.ftspringpracticum.dataAccess;

import com.ozer.ftspringpracticum.entities.concretes.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentDao extends MongoRepository<Comment, Long> {
}
