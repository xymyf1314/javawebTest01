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
public class AdminService {
    AdminMapper iAdminMapper;

    public AdminService(AdminMapper iAdminMapper) {
        this.iAdminMapper = iAdminMapper;
    }

    List<Admin> findAll() {
        return iAdminMapper.findAll();
    }
}