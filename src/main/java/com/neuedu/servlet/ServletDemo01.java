package com.neuedu.servlet;

import com.neuedu.entity.Admin;
import com.neuedu.mapper.AdminMapper;
import com.neuedu.service.AdminServiceImpl;
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
import java.util.List;

/**
 * @program: servletTest03
 * @description: servlet
 * @author: LinLuo
 * @create: 2019-09-16 11:26
 **/
@WebServlet("*.demo01")
public class ServletDemo01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 解决中文乱码
        ServletUtil.setCharacter(request, response);
        SqlSession session = MyBatisUtil.getSqlSession("mybatis-config.xml");
        AdminMapper mapper = session.getMapper(AdminMapper.class);
        // 调用服务层
        AdminServiceImpl adminService = new AdminServiceImpl(mapper);
        String url = request.getRequestURL().toString();
        String substring = url.substring(url.lastIndexOf("/"), url.lastIndexOf(".demo01"));
        if ("/findAll".equals(substring)) {
            System.out.println("findAll");
            List<Admin> admins = adminService.findAll();
            request.setAttribute("admins",admins);
            request.getRequestDispatcher("admin-list.jsp").forward(request,response);

        } else if ("/add".equals(substring)) {
            System.out.println("add");
            Admin admin = new Admin();
            String aname = request.getParameter("aname");
            String apwd = request.getParameter("apwd");
            admin.setAName(aname);
            admin.setAPwd(apwd);
            adminService.add(admin);
            session.commit();
            response.sendRedirect("findAll.demo01");
        } else if ("/load".equals(substring)) {
            System.out.println("load");
            PrintWriter out = response.getWriter();
            int id = Integer.parseInt(request.getParameter("id"));
            List<Admin> list = adminService.findById(id);
            Admin admin = new Admin();

        } else if ("/update".equals(substring)) {
            System.out.println("update");
            Admin admin = new Admin();
            admin.setId(Integer.parseInt(request.getParameter("id")));
            admin.setAName(request.getParameter("aname"));
            admin.setAPwd(request.getParameter("apwd"));
            System.out.println(admin);
            boolean update = adminService.update(admin);
            System.out.println(update);
            session.commit();
            response.sendRedirect("findAll.demo01");
        } else if ("/del".equals(substring)) {
            System.out.println("del");

            String id = request.getParameter("aid");

            System.out.println(id);
//            int id = Integer.parseInt(request.getParameter("id"));
            boolean del = adminService.del(Integer.parseInt(id));
            session.commit();
            System.out.println(del);
            response.sendRedirect("findAll.demo01");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}