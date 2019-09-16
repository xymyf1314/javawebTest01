package com.neuedu.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @program: servletTest03
 * @description: Servlet工具类
 * @author: LinLuo
 * @create: 2019-09-16 15:58
 **/
public final class ServletUtil {
    private ServletUtil() {}
    public static void setCharacter(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
    }
}