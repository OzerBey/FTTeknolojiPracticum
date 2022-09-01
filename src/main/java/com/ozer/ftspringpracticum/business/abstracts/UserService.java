package com.ozer.ftspringpracticum.business.abstracts;

import com.ozer.ftspringpracticum.core.utilities.exceptions.UserNotFoundException;
import com.ozer.ftspringpracticum.core.utilities.results.DataResult;
import com.ozer.ftspringpracticum.core.utilities.results.Result;
import com.ozer.ftspringpracticum.entities.concretes.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Result add(User user);

    Result deleteById(Long id) throws UserNotFoundException;

    Result update(User user) throws UserNotFoundException;

    Optional<User> getById(Long userId);

    DataResult<List<User>> getAll();
}
