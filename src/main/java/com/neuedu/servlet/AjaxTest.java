package com.neuedu.servlet;

import com.neuedu.entity.User;
import com.neuedu.mapper.UserMapper;
import com.neuedu.util.MyBatisUtil;
import com.neuedu.util.ServletUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ajaxtest")
public class AjaxTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtil.setCharacter(req, resp);
        SqlSession sqlSession = MyBatisUtil.getSqlSession("mybatis-config.xml");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        String username1 = req.getParameter("username");
        if(username1!=null){
            User username = mapper.findByName(username1);
            PrintWriter out = resp.getWriter();
            if (username == null) {
                out.write("可以注册");
            }else{
                out.write("用户名已存在");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
