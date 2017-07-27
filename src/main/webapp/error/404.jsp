<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>" />
	<meta charset="utf-8" />
    <title>游戏和应用收益管理平台</title>

    <meta name="description" content="Error 404 - Page Not Found" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%--     <link rel="shortcut icon" href="${pageContext.request.contextPath}/plugins/img/favicon.png" type="image/x-icon"> --%>

    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/plugins/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/plugins/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/css/admin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/css/app.css">


</head>
<body class="body-404">
	<div class="error-header"> </div>
    <div class="container ">
        <section class="error-container text-center">
            <h1>404</h1>
            <div class="error-divider">
                <h2>&nbsp;</h2>
                <p class="description">您所访问的页面不存在</p>
            </div>
            <a href="javascript:history.back();" class="return-btn"><i class="fa fa-home"></i>返回</a>
        </section>
    </div>
    <script src="${pageContext.request.contextPath}/plugins/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/js/amazeui.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/js/app.js"></script>
</body>
</html>