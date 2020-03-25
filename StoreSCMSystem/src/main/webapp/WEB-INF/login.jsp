<%--
  Created by IntelliJ IDEA.
  User: master
  Date: 2020/3/13
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/libs/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <style>

        html,body{
            width:100%;
            height:100%;
            margin: 0;
            padding: 0;
        }

        body{
            background-color: #eeeeee;
        }

        .title{

            font-size: 25px;
            font-weight: 500;
            padding-left: 3px;
        }
        #main{

            background-color: white;
            border-radius: 10px;
            margin: 0 auto;
            padding: 16px;
            padding-left: 20px;
            padding-right: 20px;
            padding-bottom: 25px;
            width: 380px;
            /*width: 30%;*/
            position: relative;
            top: 10%;
        }

    </style>

    <script>
        layui.use('form', function(){
            // var form = layui.form;
            // form.render();
        });


    </script>
    <script type="text/javascript">
        var timer ;
        $(function () {
            $("#loginBtn").click(function () {

                var username = $("#username").val();
                var password = $("#password").val();
                var imagecode = $("#imageCode").val();
                if(username!=""&&password!=""&&imagecode!=""){
                    $.post("${pageContext.request.contextPath}/login",$("#loginForm").serialize(),function (data) {

                        // alert(data);
                        if(data.success){
                            window.location.href = "${pageContext.request.contextPath}/index";
                        }else{

                            layui.use('layer', function(){
                                var layer = layui.layer;

                                layer.alert("登录失败："+data.errorMsg, {
                                    icon: 2,
                                    anim: 6,
                                    closeBtn: 0,
                                    time: 3000
                                });
                            });

                        }

                    },"json");
                    return false;
                }

            });

        });

        $(document).ready(function(){

            timer = setInterval(changeCode,120*1000)

        })

        function changeCode(){

            var rand = Math.random()*10000;
            var url = "/SCM/imageCode?rand="+rand;
            $("#image").attr("src","/SCM/imageCode?rand="+rand);

            // $("#imageCode").load(url);

        }



    </script>
</head>
<body>

<div id="main">


    <form method="post" id="loginForm" class="layui-form">

        <div class="form-group title">
            <span class="">Please sign in</span>
        </div>

        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon">
                     <i class="layui-icon layui-icon-username"
                        style="font-size: 30px; color: #1E9FFF;"></i>
                </span>
                <input id="username" class="form-control input-lg" type="text" name="username"
                       placeholder="用户名" required>
            </div>
        </div>


        <div class="form-group">

            <div class="input-group">
                <span class="input-group-addon">
                    <i class="layui-icon layui-icon-password"
                       style="font-size: 30px; color: #1E9FFF;"></i>
                </span>
                <input id="password" class="form-control input-lg" type="text" name="password"
                       placeholder="密码" required>
            </div>
        </div>
        <div class="form-group" >
            <div class="" style="width: 60%;float: left;display: inline-block">
                <div class="input-group"  >
                <span class="input-group-addon">
                    <i class="layui-icon layui-icon-vercode"
                       style="font-size: 30px; color: #1E9FFF;"></i>
                </span>
                    <input id="imageCode" class="form-control input-lg" name = "imageCode"
                           type="text" placeholder="验证码" required>
                </div>

            </div>
            <div style="float: right;display: inline-block;
            padding-bottom: 10px;">
                <img src="/SCM/imageCode" onclick="changeCode(this)" id="image"
                     style="width: 125px;height: 46px;border: 1px solid #eeeeee;
                    border-radius: 5px"/>
            </div>


        </div>

        <div class="layui-form-item " style="margin-bottom: 0;">

            <label style="font-weight: bold;font-size: 15px;float: left;
                position: static" >
                记住我
            </label>
            <div class="layui-input-block"
                 style="margin-left: 20px;height: 0px;
                 float: left;
                 transform: translateY(-7px)" >
                <input type="checkbox" name="remember-me" lay-skin="switch">

            </div>

        </div>

        <button id="loginBtn" type="submit"  class="btn btn-primary btn-block btn-lg">
            Submit
        </button>
        <button type="reset" class="btn btn-default btn-block btn-lg">Reset</button>
    </form>


</div>







</body>
</html>
