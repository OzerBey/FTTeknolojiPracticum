package com.ozer.ftspringpracticum.api.controllers;

import com.ozer.ftspringpracticum.business.abstracts.UserService;
import com.ozer.ftspringpracticum.core.utilities.exceptions.UserNotFoundException;
import com.ozer.ftspringpracticum.core.utilities.results.DataResult;
import com.ozer.ftspringpracticum.core.utilities.results.Result;
import com.ozer.ftspringpracticum.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("add")
    public Result add(@Validated @RequestBody User user) {
        return this.userService.add(user);
    }

    @PutMapping("update")
    public Result update(@RequestBody User user) throws UserNotFoundException {
        return this.userService.update(user);
    }

    @DeleteMapping("delete")
    public Result delete(@RequestParam("id") Long id) throws UserNotFoundException {
        return this.userService.deleteById(id);
    }

    @GetMapping("getById")
    public Optional<User> getById(@RequestParam(name = "id") Long id) {
        return this.userService.getById(id);
    }

    @GetMapping("getAll")
    public DataResult<List<User>> getAll() {
        return (DataResult<List<User>>) this.userService.getAll();
    }
}
