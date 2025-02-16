package com.redisapi.controllers;


import com.redisapi.dao.UserDao;
import com.redisapi.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping
    public User createUser(@RequestBody User user){

        user.setUserId(UUID.randomUUID().toString());
        return userDao.save(user);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") String userId){
        return userDao.get(userId);
    }

    @GetMapping
    public Map<Object,Object> getAll(){
        return userDao.findAll();
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") String userId){
        userDao.deleteUser(userId);

    }

    @PutMapping
    public User updateUser(@RequestBody User user){
        return userDao.save(user);
    }

}
