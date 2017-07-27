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
            <li class="active"><a href="#">用户列表</a> </li>
            <li class="active">${account eq null ?"新增":"修改"}用户</li>
        </ul><!-- .breadcrumb -->

        <!-- #nav-search -->
    </div>
    <div class="page-content">
        <div class="page-header">

        </div><!-- /.page-header -->

        <div class="row">
            <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->

                <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/account/saveOrUpdate" method="post">
                    <input type="hidden" name="id" id="id" value="${account.id}">
                    <input type="hidden" name="keyword" id="keyword" value="${queryBean.keyword}">
                    <input type="hidden" name="currentPage" id="currentPage" value="${queryBean.currentPage}">
                    <input type="hidden" name="pageSize" id="pageSize" value="${queryBean.pageSize}">
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="accountname">用户账号</label>

                        <div class="col-sm-9">
                            <c:if test="${account eq null }">
                                <input type="text" id="accountname" name="accountname" placeholder="输入用户账号" value="${account.accountname}" class="col-xs-12 col-sm-5 " />
                            </c:if>
                            <c:if test="${account ne null }">
                                <span type="text" id="" name="accountname" placeholder="输入用户账号" value="${account.accountname}" class="col-xs-12 col-sm-5 " />
                            </c:if>
                        </div>
                    </div>

                    <div class="space-4"></div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="nickname">用户名称</label>

                        <div class="col-sm-9">
                            <input type="text" id="nickname" name="nickname" placeholder="输入用户名称" value="${account.nickname}" class="col-xs-10 col-sm-5" />
                            <span class="help-inline col-xs-12 col-sm-7">
                                                </span>
                        </div>
                    </div>

                    <div class="space-4"></div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="phone">手机号</label>

                        <div class="col-sm-9">
                            <input type="text" id="phone" name="phone" placeholder="输入手机号"  value="${account.phone}" class="col-xs-10 col-sm-5" />
                            <span class="help-inline col-xs-12 col-sm-7">
                                                </span>
                        </div>
                    </div>

                    <div class="space-4"></div>


                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="email">邮箱地址</label>

                        <div class="col-sm-9">
                            <input type="email" id="email" name="email" placeholder="输入邮箱地址" value="${account.email}" class="col-xs-10 col-sm-5" />
                            <span class="help-inline col-xs-12 col-sm-7">
                                                </span>
                        </div>
                    </div>

                    <div class="space-4"></div>


                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="description">描述</label>

                        <div class="col-sm-9">
                            <textarea type="text" id="description" name="description" placeholder="输入描述..."   class="col-xs-10 col-sm-5" >${account.description}</textarea>
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
