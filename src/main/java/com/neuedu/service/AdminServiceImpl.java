package com.neuedu.service;

import com.neuedu.entity.Admin;
import com.neuedu.mapper.AdminMapper;

import java.util.List;

/**
 * @program: servletTest03
 * @description:
 * @author: LinLuo
 * @create: 2019-09-16 16:05
 **/
public class AdminServiceImpl implements IAdminService {
    AdminMapper iAdminMapper;

    public AdminServiceImpl(AdminMapper iAdminMapper) {
        this.iAdminMapper = iAdminMapper;
    }

    @Override
    public List<Admin> findAll() {
        System.out.println("查找事务");
        return iAdminMapper.findAll();
    }

    @Override
    public List<Admin> findById(int id) {
        System.out.println("通过id查找");
        return iAdminMapper.findById(id);
    }

    @Override
    public boolean add(Admin admin) {
        System.out.println("添加的事务");
        boolean add = iAdminMapper.add(admin);
        return add;
    }

    @Override
    public boolean update(Admin admin) {
        System.out.println("修改的事务");
        boolean add = iAdminMapper.update(admin);
        return add;
    }

    @Override
    public boolean del(int id) {
        System.out.println("删除的事务");
        boolean del = iAdminMapper.del(id);
        return del;
    }

}