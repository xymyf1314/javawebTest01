package com.neuedu.service;


import com.neuedu.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findById(int id);

    User findByName(String username);

    boolean add(User user);

    boolean update(User user);

    boolean del(int id);

    User logIn(String username, String password);

}
