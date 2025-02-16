package com.redisapi.dao;

import com.redisapi.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository
public class UserDao {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    private static final String KEY_USER = "user";

    public User save(User user){

        redisTemplate.opsForHash().put(KEY_USER,user.getUserId(),user);

        return user;
    }

    public User get(String userId){
        return (User)redisTemplate.opsForHash().get(KEY_USER,userId);
    }

    public Map<Object,Object> findAll(){
        return redisTemplate.opsForHash().entries(KEY_USER);
    }

    public void deleteUser(String userId){
        redisTemplate.opsForHash().delete(KEY_USER,userId);
    }

    public User updateUser(User user){
        redisTemplate.opsForHash().put(KEY_USER,user.getUserId(),user);
        return user;
    }


}
