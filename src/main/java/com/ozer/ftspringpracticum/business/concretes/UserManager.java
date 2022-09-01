package com.ozer.ftspringpracticum.business.concretes;

import com.ozer.ftspringpracticum.business.abstracts.SequenceGeneratorService;
import com.ozer.ftspringpracticum.business.abstracts.UserService;
import com.ozer.ftspringpracticum.core.utilities.exceptions.UserNotFoundException;
import com.ozer.ftspringpracticum.core.utilities.results.*;
import com.ozer.ftspringpracticum.dataAccess.UserDao;
import com.ozer.ftspringpracticum.entities.concretes.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class UserManager implements UserService {

    private UserDao userDao;
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public UserManager(UserDao userDao, SequenceGeneratorService sequenceGeneratorService) {
        this.userDao = userDao;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }


    @Override
    public Result add(User user) {
        user.setId((long) sequenceGeneratorService.getSequenceNumber(user.SEQUENCE_NAME));
        this.userDao.save(user);
        return new SuccessResult("User added successfully");
    }

    @Override
    public Result deleteById(Long id) throws UserNotFoundException {
        if (this.userDao.existsById(id)) {
            this.userDao.deleteById(id);
            return new SuccessResult("User deleted by their id successfully");
        } else {
            new UserNotFoundException();
        }
        return new ErrorResult();
    }

    @Override
    public Result update(User user) throws UserNotFoundException {
        if (this.userDao.existsById(user.getId())) {
            this.userDao.save(user);
            return new SuccessResult("User updated by their id successfully");
        } else {
            new UserNotFoundException();
        }
        return new ErrorResult();
    }

    @Override
    public Optional<User> getById(Long userId) {
        if (this.userDao.existsById(userId)) {
            return this.userDao.findById(userId);
        } else new UserNotFoundException();
        return new ErrorDataResult<Optional<User>>().getData();
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<>(this.userDao.findAll(), "All users listed");
    }
}
