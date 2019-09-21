package com.neuedu.test;

import com.neuedu.entity.User;
import com.neuedu.mapper.UserMapper;
import com.neuedu.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserTest01 {
    public static void main(String[] args) {
        SqlSession session = MyBatisUtil.getSqlSession("mybatis-config.xml");
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.del(4);
        session.commit();
        List<User> users = mapper.findAll();
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
    }
}
