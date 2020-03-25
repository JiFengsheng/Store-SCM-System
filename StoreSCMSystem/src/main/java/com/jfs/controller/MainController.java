package com.jfs.controller;

import com.jfs.domain.User;
import com.jfs.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    private IUserService IUserService;

    /*
     * 登录页面
     *
     * */
    @RequestMapping("/userLogin")
    public String login(){

        return "login";

    }


    /*
     * 生成验证码
     * */
    @GetMapping("/imageCode")
    public String imageCode(){
        System.out.println("/imageCode");
        return "imageCode";
    }

    /*
     * 主页
     * */
    @RequestMapping("/index")
    public String index(HttpServletRequest request,HttpServletResponse response){

        //获取登录后用户:UserDetail对象
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        HttpSession model = request.getSession();
        if(principal!=null){
            if(principal instanceof UserDetails){
                UserDetails userDetails = (UserDetails)principal;
                String username = userDetails.getUsername();
                User user = (User) userDetails;
                model.setAttribute("username",username);
                model.setAttribute("user",user);
            }
        }
//        response.addHeader("REFRESH", "3;URL=./index");
        return "index";
    }

    /*
     * 权限不足错误页面
     * */
    @RequestMapping("/error")
    public String error(){
        return "error";
    }


    @RequestMapping("/transport")
    public String transport(){

        return "redirect:./userLogin";
    }


}
