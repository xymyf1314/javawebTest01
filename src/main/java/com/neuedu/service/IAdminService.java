package com.neuedu.service;

import com.neuedu.entity.Admin;

import java.util.List;

public interface IAdminService {
    List<Admin> findAll();

    List<Admin> findById(int id);

    boolean add(Admin admin);

    boolean update(Admin admin);

    boolean del(int id);

}
