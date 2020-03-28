package com.jfs.controller;

import com.alibaba.fastjson.JSONObject;
import com.jfs.domain.User;
import com.jfs.exception.UserExistException;
import com.jfs.service.IStaffService;
import com.jfs.service.IUserService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IStaffService staffService;

    private Logger logger = LogManager.getLogger(UserController.class);

    @ResponseBody
    @RequestMapping("/updateUser")
    public Map update(String username, String password, HttpSession session){

        String originName = (String) session.getAttribute("username");
        System.out.println(originName);
        Map result = new HashMap();
        User user = (User) session.getAttribute("user");
        if(user==null){
            result.put("success",false);
            result.put("errorMsg","修改失败");
        }
        try {
            int i = userService.updateUser(user, username, password);
            if (i==1){
                result.put("success",true);
            }else {
                result.put("success",false);
                result.put("errorMsg","修改失败");
            }

        } catch (UserExistException e) {
            result.put("success",false);
            result.put("errorMsg",e.getMessage());
            e.printStackTrace();

        }
        return result;
    }


    @GetMapping("/getUserSession")
    public void getUserSession(HttpSession session,HttpServletResponse response) throws IOException {


//        String  username = (String) session.getAttribute("username");
        User user = (User) session.getAttribute("user");

        logger.info(user);
        JSONObject jsonObject = new JSONObject();
        User u = userService.findUser(user.getUserId());
        u.setPassword("");
        session.setAttribute("user",u);
        jsonObject.put("user",u);

        response.setContentType("text/html;charset=utf-8");
        String json = jsonObject.toJSONString();
        response.getWriter().write(json);

    }







}
