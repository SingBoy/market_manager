<%--
  Created by IntelliJ IDEA.
  User: yuxiangjie
  Date: 2017/7/22
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="basePath" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="main-content">
    <div class="breadcrumbs" id="breadcrumbs">


        <ul class="breadcrumb">
            <li>
                <i class="icon-home home-icon"></i>
                <a href="#">系统设置</a>
            </li>
            <li class="active"><a href="#">角色列表</a> </li>
            <li class="active">${role eq null ?"新增":"修改"}角色</li>
        </ul><!-- .breadcrumb -->

        <!-- #nav-search -->
    </div>
    <div class="page-content">
        <div class="page-header">

        </div><!-- /.page-header -->

        <div class="row">
            <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->

                <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/role/saveOrUpdate" method="post">
                    <input type="hidden" name="id" id="id" value="${role.id}">
                    <input type="hidden" name="keyword" id="keyword" value="${queryBean.keyword}">
                    <input type="hidden" name="currentPage" id="currentPage" value="${queryBean.currentPage}">
                    <input type="hidden" name="pageSize" id="pageSize" value="${queryBean.pageSize}">
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="name">角色名称</label>

                        <div class="col-sm-9">
                            <input type="text" id="name" name="name" placeholder="输入用户账号" value="${role.name}" class="col-xs-12 col-sm-5 " />
                        </div>
                    </div>

                    <div class="space-4"></div>


                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="description">描述</label>

                        <div class="col-sm-9">
                            <textarea type="text" id="description" name="description" placeholder="输入描述..."   class="col-xs-10 col-sm-5" >${role.description}</textarea>
                            <span class="help-inline col-xs-12 col-sm-7">
                                                </span>
                        </div>
                    </div>

                    <div class="space-4"></div>


                    <div class=" ">
                        <div class="col-md-offset-3 col-md-9">
                            <button class="btn btn-info" type="submit">
                                <i class="icon-ok bigger-110"></i>
                                确定
                            </button>

                            &nbsp; &nbsp; &nbsp;
                            <a href="javascript:history.back()" class="btn" type="reset">
                                <i class="icon-undo bigger-110"></i>
                                返回
                            </a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
