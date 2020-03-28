<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>



    <title>主页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css"/>

    <script type="text/javascript" src="${pageContext.request.contextPath}/libs/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/libs/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>


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

        var time;
        function inputCheck(){
            console.log("input");
            var pass1 = $("#password").val();

            var pass2 = $("#again").val();
            var $tip = $("#tip");
            if(pass2.length<pass1.length){
                $tip.html("");
            }else if(pass2.length=pass1.length){
                checkPass();
            }else{
                flag1 = false;
                $tip.html("<font color='red'>两次输入的密码不一致！</font>");
            }

        }

        var flag1 = false;
        /*验证重复密码*/
        function checkPass() {

            var pass1 = $("#password").val();

            var pass2 = $("#again").val();
            var $tip = $("#tip");

            if(pass1 != pass2){
                flag1 = false;
                $tip.html("<font color='red'>两次输入的密码不一致！</font>");
            } else {
                flag1 = true;
                $tip.html("<font color='green'><b>√</b></font>");
            }

        }

        function updateUser(){

            var username = $("#username").val();

            var pass1 = $("#password").val();

            var pass2 = $("#again").val();

            if(pass1==""||pass2==""){
                layui.use('layer', function(){
                    var layer = layui.layer;

                    layer.alert("密码栏不能为空", {
                        icon: 2,
                        anim: 6,
                        closeBtn: 0,
                        time: 2000
                    });
                });

                return;
            }

            if(flag1){
                var index;
                layui.use('layer',function(){
                    var layer = layui.layer;
                    index = layer.load(0, {shade: false});
                });

                $.ajax({
                    url:"${pageContext.request.contextPath}/user/updateUser",
                    type:"post",
                    data:{
                        username:username,password:pass1
                    },
                    success:function(_data,_status,_xht){

                        if(_data.success){
                            layer.msg('修改成功');
                        }else{
                            layer.msg(_data.errorMsg);
                        }
                        layui.use('layer',function(){
                            var layer = layui.layer;
                            layer.close(index);
                        })

                    },
                    error:function(){

                        layui.use('layer',function(){
                            var layer = layui.layer;
                            layer.msg('发送失败');
                            layer.close(index);
                        })
                    }

                })

            }else{
                layui.use('layer', function(){
                    var layer = layui.layer;

                    layer.alert("两次输入的密码不一致！", {
                        icon: 2,
                        anim: 6,
                        closeBtn: 0,
                        time: 2000
                    });
                });

            }


        }




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
                    <dd>
                        <a href="" data-toggle="modal" data-target=".bs-example-modal-sm">密码设置</a>
                    </dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="${pageContext.request.contextPath}/logout">退了</a>
            </li>
        </ul>
    </div>

    <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">密保设置</h4>
                </div>
                <div class="modal-body">

                    <form>

                        <div class="form-group">
                            <label for="username">用户名：</label>
                            <input type="text" class="form-control" value="${username}"
                                   id="username" placeholder="name" required>
                        </div>
                        <div class="form-group">
                            <label for="password">密码：</label>
                            <input type="password" class="form-control"
                                   id="password" placeholder="Password" required>
                        </div>
                        <div class="form-group">
                            <label for="again">重复密码：<font id="tip"></font></label>
                            <input type="password" class="form-control"
                                   id="again" placeholder="Password" required
                                   oninput="inputCheck()" onblur="checkPass()">
                        </div>

                    </form>


                </div>
                <div class="modal-footer" style="padding-top: 5px;padding-bottom: 5px">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="updateUser()">Save changes</button>
                </div>
            </div>
        </div>
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
                    src="/SCM/html/user/user_formation.html"
                    style="width:100%;height:100%;">
            </iframe>

        </div>


    </div>




    <div class="layui-footer" >
        <!-- 底部固定区域 -->
        © jfs.com
    </div>

</div>

<script src="${pageContext.request.contextPath}/js/effect/activate-power-mode.js"></script>
<script>
    POWERMODE.colorful = true;
    POWERMODE.shake = false;
    document.body.addEventListener('input',POWERMODE);
</script>






<script src="${pageContext.request.contextPath}/libs/L2Dwidget.min.js"></script>
<script type="text/javascript">
    L2Dwidget
    .init({
        dialog: {
            // 开启对话框
            enable: false,
            script: {
                // 每空闲 10 秒钟，显示一条一言
                'every idle 10s': '$hitokoto$',
                // 当触摸到角色身体
                'tap body': '哎呀！别碰我！',
                // 当触摸到角色头部
                'tap face': '人家已经不是小孩子了！'
            }
        }
    });
</script>






</body>
</html>
