package com.neuedu.servlet;

import com.neuedu.entity.User;
import com.neuedu.mapper.UserMapper;
import com.neuedu.service.UserServiceImpl;
import com.neuedu.util.MyBatisUtil;
import com.neuedu.util.ServletUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @program: servletTest03
 * @description: servlet
 * @author: LinLuo
 * @create: 2019-09-16 11:26
 **/
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 解决中文乱码
        ServletUtil.setCharacter(request, response);
        SqlSession session = MyBatisUtil.getSqlSession("mybatis-config.xml");
        UserMapper mapper = session.getMapper(UserMapper.class);
        // 调用服务层
        UserServiceImpl userService = new UserServiceImpl(mapper);
        String method = request.getParameter("method");
        if ("findAll".equals(method)) {
            System.out.println("findAll");
            List<User> users = userService.findAll();
            request.setAttribute("users", users);
            request.getRequestDispatcher("member-list.jsp").forward(request, response);

        } else if ("add".equals(method)) {
            System.out.println("add");
            User user = new User(request.getParameter("username"), request.getParameter("password"), request.getParameter("phone"), request.getParameter("addr"));
            userService.add(user);
            session.commit();
            response.sendRedirect("userServlet?method=findAll");
        } else if ("load".equals(method)) {
            System.out.println("load");
            int id = Integer.parseInt(request.getParameter("id"));
            User user = userService.findById(id);
            request.setAttribute("user", user);
            System.out.println(user);
            request.getRequestDispatcher("member-edit.jsp").forward(request, response);
        } else if ("update".equals(method)) {
            System.out.println("update");
            User user = new User();
            user.setId(Integer.parseInt(request.getParameter("id")));
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setPhone(request.getParameter("phone"));
            user.setAddr(request.getParameter("addr"));
            System.out.println(user);
            boolean update = userService.update(user);
            System.out.println(update);
            session.commit();
            response.sendRedirect("userServlet?method=findAll");
        } else if ("del".equals(method)) {
            System.out.println("del");
//            String id = request.getParameter("uid");
            int id = Integer.parseInt(request.getParameter("id"));
            boolean del = userService.del(id);
            session.commit();
            response.sendRedirect("userServlet?method=findAll");
        }
//            // 登陆的方法
//        } else if ("/login".equals(substring)) {
//            System.out.println("login================");
//            String checkcode = (String) request.getSession().getAttribute("checkcode");
//            String aname = request.getParameter("aname");
//            String apwd = request.getParameter("apwd");
//            String yzm = request.getParameter("yzm");
//            if (!(checkcode.equals(yzm))){
//                request.setAttribute("msg", "验证码错误");
//                request.getRequestDispatcher("login.jsp").forward(request, response);
//            }
//            Admin admin = adminService.logIn(aname, apwd);
//            if (admin != null) {
//                HttpSession httpSession = request.getSession();
//                httpSession.setAttribute("admin", admin);
//                response.sendRedirect("/servletTest03_war/index.jsp");
//                System.out.println("登陆成功");
//            } else {
//                request.setAttribute("msg", "用户名或密码错误");
//                request.getRequestDispatcher("login.jsp").forward(request, response);
////                response.sendRedirect("/servletTest03_war/login.jsp");
//            }
//        } else if ("/logout".equals(substring)) {
//            request.getSession().invalidate();
//            response.sendRedirect("/servletTest03_war/login.jsp");
//        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}