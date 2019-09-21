package com.neuedu.mapper;

import com.neuedu.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();

    User findById(int id);

    User findByName(String username);

    boolean add(User user);

    boolean update(User user);

    boolean del(int id);
}
