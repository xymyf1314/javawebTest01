package com.neuedu.mapper;

import com.neuedu.entity.Admin;

import java.util.List;

public interface AdminMapper {
    List<Admin> findAll();

    boolean add(Admin admin);
}
