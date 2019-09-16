package com.neuedu.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: mvntest09
 * @description: MyBatis工具类
 * @author: LinLuo
 * @create: 2019-09-09 15:30
 **/
public class MyBatisUtil {
    private MyBatisUtil() {
    }

    public static SqlSession getSqlSession(String reso) {
        String resource = reso;
        InputStream inputStream = null;
        SqlSession session = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return session;
    }
}