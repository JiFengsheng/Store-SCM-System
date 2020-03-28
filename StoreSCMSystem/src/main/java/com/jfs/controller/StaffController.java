package com.jfs.controller;


import com.alibaba.fastjson.JSONObject;
import com.jfs.domain.User;
import com.jfs.service.IStaffService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private IStaffService staffService;

    private Logger logger = LogManager.getLogger(StaffController.class);

    @RequestMapping("/upload")
    public void upload(HttpSession session, HttpServletResponse response, @RequestParam("upload")CommonsMultipartFile upload) {

        //得到文件名
        String fileName=upload.getOriginalFilename();
        System.out.println(fileName);
        //重新命名为唯一的图片名称
        String uuid= UUID.randomUUID().toString();
        String extendsName = fileName.substring(fileName.lastIndexOf("."),fileName.length());
        String onlyName=uuid+extendsName;
        System.out.println(onlyName);
        File saveDir = new File("E:/upload");
        if(!saveDir.exists()){
            saveDir.mkdir();
        }
        File saveFile=new File(saveDir,onlyName);
        JSONObject jsonObject = new JSONObject();
        response.setContentType("text/html;charset=utf-8");
        //spring api 保存数据
        try {
            upload.transferTo(saveFile);
            String  username = (String) session.getAttribute("username");
            User user = (User) session.getAttribute("user");
            int i = staffService.updatePic(user.getStaff().getStaffId(), onlyName);

            /*{
                "code": 0
                ,"msg": ""
                ,"data": {
                "src": "http://cdn.layui.com/123.jpg"
                }
            }*/
            if (i!=1){
                jsonObject.put("code",1);
                jsonObject.put("msg","上传失败");
            }
            jsonObject.put("code",0);
            jsonObject.put("msg","上传成功");
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("src",onlyName);
            jsonObject.put("data",jsonObject1);
            String jsonString  = jsonObject.toJSONString();
            logger.info(jsonString);
            response.getWriter().write(jsonString);

        } catch (IOException e) {
            e.printStackTrace();
            jsonObject.put("code",1);
            jsonObject.put("msg","上传失败");
            try {
                response.getWriter().write(jsonObject.toJSONString());
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }


    }



}
