/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-03-19 16:56:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>登录页面</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/layui/css/layui.css\"/>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/libs/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/layui/layui.js\"></script>\r\n");
      out.write("    <meta http-equiv=\"pragma\" content=\"no-cache\"/>\r\n");
      out.write("    <meta http-equiv=\"cache-control\" content=\"no-cache\"/>\r\n");
      out.write("    <meta http-equiv=\"expires\" content=\"0\"/>\r\n");
      out.write("    <style>\r\n");
      out.write("\r\n");
      out.write("        html,body{\r\n");
      out.write("            width:100%;\r\n");
      out.write("            height:100%;\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        body{\r\n");
      out.write("            background-color: #eeeeee;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .title{\r\n");
      out.write("\r\n");
      out.write("            font-size: 25px;\r\n");
      out.write("            font-weight: 500;\r\n");
      out.write("            padding-left: 3px;\r\n");
      out.write("        }\r\n");
      out.write("        #main{\r\n");
      out.write("\r\n");
      out.write("            background-color: white;\r\n");
      out.write("            border-radius: 10px;\r\n");
      out.write("            margin: 0 auto;\r\n");
      out.write("            padding: 16px;\r\n");
      out.write("            padding-left: 20px;\r\n");
      out.write("            padding-right: 20px;\r\n");
      out.write("            padding-bottom: 25px;\r\n");
      out.write("            width: 380px;\r\n");
      out.write("            /*width: 30%;*/\r\n");
      out.write("            position: relative;\r\n");
      out.write("            top: 10%;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    </style>\r\n");
      out.write("    <script>\r\n");
      out.write("        layui.use('form', function(){\r\n");
      out.write("            // var form = layui.form;\r\n");
      out.write("            // form.render();\r\n");
      out.write("        });\r\n");
      out.write("    </script>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("        var timer ;\r\n");
      out.write("        $(function () {\r\n");
      out.write("            $(\"#loginBtn\").click(function () {\r\n");
      out.write("\r\n");
      out.write("                var username = $(\"#username\").val();\r\n");
      out.write("                var password = $(\"#password\").val();\r\n");
      out.write("                var imagecode = $(\"#imageCode\").val();\r\n");
      out.write("                if(username!=\"\"&&password!=\"\"&&imagecode!=\"\"){\r\n");
      out.write("                    $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/login\",$(\"#loginForm\").serialize(),function (data) {\r\n");
      out.write("\r\n");
      out.write("                        // alert(data);\r\n");
      out.write("                        if(data.success){\r\n");
      out.write("                            window.location.href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/index\";\r\n");
      out.write("                        }else{\r\n");
      out.write("\r\n");
      out.write("                            layui.use('layer', function(){\r\n");
      out.write("                                var layer = layui.layer;\r\n");
      out.write("\r\n");
      out.write("                                layer.alert(\"登录失败：\"+data.errorMsg, {\r\n");
      out.write("                                    icon: 2,\r\n");
      out.write("                                    anim: 6,\r\n");
      out.write("                                    closeBtn: 0,\r\n");
      out.write("                                    time: 3000\r\n");
      out.write("                                });\r\n");
      out.write("                            });\r\n");
      out.write("\r\n");
      out.write("                        }\r\n");
      out.write("\r\n");
      out.write("                    },\"json\");\r\n");
      out.write("                    return false;\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        $(document).ready(function(){\r\n");
      out.write("\r\n");
      out.write("            timer = setInterval(changeCode,120*1000)\r\n");
      out.write("\r\n");
      out.write("        })\r\n");
      out.write("\r\n");
      out.write("        function changeCode(){\r\n");
      out.write("\r\n");
      out.write("            var rand = Math.random()*10000;\r\n");
      out.write("            var url = \"/imageCode?rand=\"+rand;\r\n");
      out.write("            $(\"#image\").attr(\"src\",\"/imageCode?rand=\"+rand);\r\n");
      out.write("\r\n");
      out.write("            // $(\"#imageCode\").load(url);\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div id=\"main\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <form method=\"post\" id=\"loginForm\" class=\"layui-form\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form-group title\">\r\n");
      out.write("            <span class=\"\">Please sign in</span>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <div class=\"input-group\">\r\n");
      out.write("                <span class=\"input-group-addon\">\r\n");
      out.write("                     <i class=\"layui-icon layui-icon-username\"\r\n");
      out.write("                        style=\"font-size: 30px; color: #1E9FFF;\"></i>\r\n");
      out.write("                </span>\r\n");
      out.write("                <input id=\"username\" class=\"form-control input-lg\" type=\"text\" name=\"username\"\r\n");
      out.write("                       placeholder=\"用户名\" required>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"input-group\">\r\n");
      out.write("                <span class=\"input-group-addon\">\r\n");
      out.write("                    <i class=\"layui-icon layui-icon-password\"\r\n");
      out.write("                       style=\"font-size: 30px; color: #1E9FFF;\"></i>\r\n");
      out.write("                </span>\r\n");
      out.write("                <input id=\"password\" class=\"form-control input-lg\" type=\"text\" name=\"password\"\r\n");
      out.write("                       placeholder=\"密码\" required>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-group\" >\r\n");
      out.write("            <div class=\"\" style=\"width: 60%;float: left;display: inline-block\">\r\n");
      out.write("                <div class=\"input-group\"  >\r\n");
      out.write("                <span class=\"input-group-addon\">\r\n");
      out.write("                    <i class=\"layui-icon layui-icon-vercode\"\r\n");
      out.write("                       style=\"font-size: 30px; color: #1E9FFF;\"></i>\r\n");
      out.write("                </span>\r\n");
      out.write("                    <input id=\"imageCode\" class=\"form-control input-lg\" name = \"imageCode\"\r\n");
      out.write("                           type=\"text\" placeholder=\"验证码\" required>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <div style=\"float: right;display: inline-block;\r\n");
      out.write("            padding-bottom: 10px;\">\r\n");
      out.write("                <img src=\"/imageCode\" onclick=\"changeCode(this)\" id=\"image\"\r\n");
      out.write("                     style=\"width: 125px;height: 46px;border: 1px solid #eeeeee;\r\n");
      out.write("                    border-radius: 5px\"/>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"layui-form-item \" style=\"margin-bottom: 0;\">\r\n");
      out.write("\r\n");
      out.write("            <label style=\"font-weight: bold;font-size: 15px;float: left;\r\n");
      out.write("                position: static\" >\r\n");
      out.write("                记住我\r\n");
      out.write("            </label>\r\n");
      out.write("            <div class=\"layui-input-block\"\r\n");
      out.write("                 style=\"margin-left: 20px;height: 0px;\r\n");
      out.write("                 float: left;\r\n");
      out.write("                 transform: translateY(-7px)\" >\r\n");
      out.write("                <input type=\"checkbox\" name=\"switch\" lay-skin=\"switch\"\r\n");
      out.write("                       name=\"remember-me\">\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <button id=\"loginBtn\" type=\"submit\"  class=\"btn btn-primary btn-block btn-lg\">\r\n");
      out.write("            Submit\r\n");
      out.write("        </button>\r\n");
      out.write("        <button type=\"reset\" class=\"btn btn-default btn-block btn-lg\">Reset</button>\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
