package com.jfs.security;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyLogoutSuccessHandler implements LogoutSuccessHandler {

    Logger logger = LogManager.getLogger(MyLogoutSuccessHandler.class);

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        HttpSession session = request.getSession();
        session.setAttribute("logout","true");


        logger.info("{info}:登出成功！！！");
        int v = (int) (Math.random() * 10000);
        response.sendRedirect("./userLogin?ran="+v);
    }
}
