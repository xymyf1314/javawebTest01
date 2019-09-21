package com.neuedu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String addr;
    private Timestamp rdate;

    public User(String username, String password, String phone, String addr) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.addr = addr;
    }

    public User(Integer id, String username, String password, String phone, String addr) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.addr = addr;
    }
}
