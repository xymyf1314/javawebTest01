<%--
  Created by IntelliJ IDEA.
  User: fan
  Date: 2019/9/19 0019
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.neuedu.entity.Admin" %>
<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%
    Admin admin = (Admin) request.getSession().getAttribute("admin");
    if (admin == null) {
        response.sendRedirect("/servletTest03_war/login.jsp");
        return;
    }
%>
