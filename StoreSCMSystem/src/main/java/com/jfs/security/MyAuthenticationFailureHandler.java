package com.jfs.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfs.exception.UserNotExistException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        //返回json数据
        System.out.println("success");
        Map result = new HashMap();
        result.put("success",false);

        String errorMsg = "";

        if (exception instanceof BadCredentialsException){
            result.put("errorMsg","密码错误");
        }else if(exception instanceof UserNotExistException){
            result.put("errorMsg","用户名不存在");
        }else if(exception instanceof LockedException){
            result.put("errorMsg","帐户被锁");
        }else if(exception instanceof DisabledException){
            result.put("errorMsg","账户未启动");
        }else {
            //错误信息
            result.put("errorMsg",exception.getMessage());
        }


        String json = objectMapper.writeValueAsString(result);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(json);


    }
}
