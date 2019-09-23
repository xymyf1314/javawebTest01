package com.neuedu.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.neuedu.entity.Province;
import com.neuedu.entity.User;
import com.neuedu.mapper.ProvinceMapper;
import com.neuedu.mapper.UserMapper;
import com.neuedu.service.IProvinceService;
import com.neuedu.service.serviceimpl.ProvinceServiceImpl;
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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtil.setCharacter(req, resp);
        SqlSession sqlSession = MyBatisUtil.getSqlSession("mybatis-config.xml");
        ProvinceMapper mapper = sqlSession.getMapper(ProvinceMapper.class);
        IProvinceService provinceService = new ProvinceServiceImpl(mapper);
        String method = req.getParameter("method");
        PrintWriter out = resp.getWriter();
        if (method == null) {
            JSONArray strprovinces = provinceService.findByLvl(1);
            out.print(strprovinces);
        } else if ("2".equals(method)) {
            int code = Integer.parseInt(req.getParameter("code"));
            JSONArray strprovinces = provinceService.findByCode(code);
            out.print(strprovinces);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
