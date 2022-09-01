package com.ozer.ftspringpracticum.dataAccess;

import com.ozer.ftspringpracticum.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
