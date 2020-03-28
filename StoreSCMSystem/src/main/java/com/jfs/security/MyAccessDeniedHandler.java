package com.jfs.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfs.utils.HttpUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyAccessDeniedHandler implements AccessDeniedHandler {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {

        Map result = new HashMap();

        if (HttpUtils.isAjaxRequest(request)) {// AJAX请求,使用response发送403
            result.put("errorMsg","你没有相关权限");
            response.sendError(403);
            String json = objectMapper.writeValueAsString(result);
            response.setContentType("text/json;charset=utf-8");
            response.getWriter().write(json);
        } else if (!response.isCommitted()) {// 非AJAX请求，跳转系统默认的403错误界面，在web.xml中配置

            response.sendError(HttpServletResponse.SC_FORBIDDEN,
                    accessDeniedException.getMessage());

        }

    }
}
