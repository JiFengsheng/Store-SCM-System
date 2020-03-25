<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>

    <title>首页</title>




</head>


<body>



<h2>Hello Wold!</h2>
<h3>欢迎用户，${username}</h3>
<h3>以下是网站的功能</h3>




<%--<security:authorize access="hasAuthority('ROLE_ADD_PRODUCT')">
<a href="${pageContext.request.contextPath}/templates.product/add">商品添加</a>
</security:authorize>
<security:authorize access="hasAuthority('ROLE_UPDATE_PRODUCT')">
<a href="${pageContext.request.contextPath}/templates.product/update">商品修改</a>
</security:authorize>
<security:authorize access="hasAuthority('ROLE_LIST_PRODUCT')">
<a href="${pageContext.request.contextPath}/templates.product/list">商品查询</a>
</security:authorize>
<security:authorize access="hasAuthority('ROLE_DELETE_PRODUCT')">
<a href="${pageContext.request.contextPath}/templates.product/delete">商品删除</a>
</security:authorize>--%>





</body>
</html>
