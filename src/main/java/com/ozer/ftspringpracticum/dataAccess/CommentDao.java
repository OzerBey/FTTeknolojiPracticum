package com.ozer.ftspringpracticum.dataAccess;

import com.ozer.ftspringpracticum.entities.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment, Integer> {
}
