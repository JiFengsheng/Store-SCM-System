<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>



    <title>主页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/libs/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/layer/layer.js" type="text/javascript"></script>
    <style type="text/css">


    </style>
    <script language="JavaScript">
        history.go(1);
    </script>
    <script>
        //JavaScript代码区域
        layui.use('element', function(){
            var element = layui.element;

        });

        $(document).ready(function(){

            var username = "${username}";
            // console.log(username);
            if(username == null||username == ""){
                console.log("null");
                window.location.href = "./userLogin";
            }
            <%--alert('<%=request.getHeader("Referer")%>')--%>


        })

    </script>


</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">


    <div class="layui-header">


        <div class="layui-logo">SCM System</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a></li>

            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">用户管理</a></dd>
                    <%--<dd><a href="">消息管理</a></dd>--%>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>


        </ul>



        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;" >
                    <img src="/SCM/images/a2.jpg"
                         class="layui-nav-img">
                    ${username}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">密码设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="${pageContext.request.contextPath}/logout">退了</a>
            </li>
        </ul>
    </div>



    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">


                <li class="layui-nav-item">
                    <a href="javascript:;">人事管理</a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;">员工添加</a>
                        </dd>
                        <dd>
                            <a href="javascript:;">员工查询</a>
                        </dd>



                    </dl>
                </li>

                <li class="layui-nav-item">
                    <a href="javascript:;">合作公司管理</a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;">公司添加</a>
                        </dd>
                        <dd>
                            <a href="javascript:;">公司查询</a>
                        </dd>

                    </dl>
                </li>

                <li class="layui-nav-item">
                    <a href="javascript:;">订单管理</a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;">列表一</a>
                        </dd>
                        <dd>
                            <a href="javascript:;">列表二</a>
                        </dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>


                <li class="layui-nav-item">
                    <a href="javascript:;">库存管理</a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;">列表一</a>
                        </dd>
                        <dd>
                            <a href="javascript:;">列表二</a>
                        </dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>


                <li class="layui-nav-item">
                    <a href="javascript:;">销售管理</a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:;">列表一</a>
                        </dd>
                        <dd>
                            <a href="javascript:;">列表二</a>
                        </dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">经营统计</a>
                    <dl class="layui-nav-child" >
                        <dd><a href="javascript:;">列表一</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                        <dd><a href="javascript:;">列表三</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>


            </ul>
        </div>
    </div>



    <div class="layui-body">




        <!-- 内容主体区域 -->
        <div style="padding: 0px;">



            <iframe scrolling="auto" frameborder="0"
                    src="/SCM/html/user/user_formation.html" style="width:100%;height:100%;">
            </iframe>

        </div>


    </div>




    <div class="layui-footer" >
        <!-- 底部固定区域 -->
        © jfs.com
    </div>

</div>


</body>
</html>
