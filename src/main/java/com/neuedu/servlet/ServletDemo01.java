package com.neuedu.servlet;

import com.neuedu.entity.Admin;
import com.neuedu.mapper.AdminMapper;
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
        String url = request.getRequestURL().toString();
        String substring = url.substring(url.lastIndexOf("/"), url.lastIndexOf(".demo01"));
        if ("/findAll".equals(substring)) {
            System.out.println("findAll");
            List<Admin> list = mapper.findAll();
            PrintWriter out = response.getWriter();
            out.print("<table border=\"1\" cellspacing=\"1\" cellpadding=\"1\">");
            out.print("<tr>");
            out.print("<td>ID</td><td>Aname</td><td>Apwd</td>");
            out.print("</tr>");
            for (int i = 0; i < list.size(); i++) {
                out.print("<tr>");
                out.print("<td>" + list.get(i).getId() + "</td>");
                out.print("<td>" + list.get(i).getAName() + "</td>");
                out.print("<td>" + list.get(i).getAPwd() + "</td>");
                out.print("</tr>");
            }
            out.print("</table>");
        } else if ("/add".equals(substring)) {
            System.out.println("add");
            Admin admin = new Admin();
            String aname = request.getParameter("aname");
            String apwd = request.getParameter("apwd");
            admin.setAName(aname);
            admin.setAPwd(apwd);
            mapper.add(admin);
            session.commit();
            response.sendRedirect("findAll");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}