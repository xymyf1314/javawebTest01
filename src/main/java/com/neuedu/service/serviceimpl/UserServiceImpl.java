package com.neuedu.service.serviceimpl;

import com.neuedu.entity.User;
import com.neuedu.mapper.UserMapper;
import com.neuedu.service.IUserService;
import com.neuedu.util.ServletUtil;
import java.util.List;

/**
 * @program: servletTest03
 * @description:
 * @author: LinLuo
 * @create: 2019-09-16 16:05
 **/
public class UserServiceImpl implements IUserService {
    UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> findAll() {
        System.out.println("查找事务");
        return userMapper.findAll();
    }

    @Override
    public User findById(int id) {
        System.out.println("通过id查找");
        return userMapper.findById(id);
    }

    @Override
    public User findByName(String username) {
        System.out.println("通过name查找");
        return userMapper.findByName(username);
    }

    @Override
    public boolean add(User user) {
        System.out.println("添加的事务");
        User result = this.findByName(user.getUsername());
        boolean add = false;
        if (result == null) {
            add = userMapper.add(user);
        }
        return add;
    }

    @Override
    public boolean update(User user) {
        System.out.println("修改的事务");
        return userMapper.update(user);
    }

    @Override
    public boolean del(int id) {
        System.out.println("删除的事务");
        boolean del = userMapper.del(id);
        return del;
    }

    @Override
    public User logIn(String username, String password) {
        System.out.println("服务层登陆事务");
        User user = this.findByName(username);
        if (user != null) {
            if (user.getPassword().equals(ServletUtil.md5(password))) {
                return user;
            }
        }
        return null;
    }

}