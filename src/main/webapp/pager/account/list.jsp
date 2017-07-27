<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="${pageContext.request.contextPath}" />
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/22
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <li class="active">用户列表</li>
        </ul><!-- .breadcrumb -->

       <!-- #nav-search -->
    </div>

    <div class="page-content">

        <div class="row">
            <div class="col-xs-12">
                    <div class="widget-main">
                        <form class="form-search" action="${basePath}/account/list">
                            <div class="row">
                                <div class="col-xs-8 col-sm-3">
                                    <div class="input-group">
                                        <input type="text" id="keyword" name="keyword" value="${queryBean.keyword}" class="form-control search-query" placeholder="搜索...">
                                        <span class="input-group-btn">
                                                <button type="submit" class="btn btn-purple btn-sm">
                                                    搜索
                                                    <i class="icon-search icon-on-right bigger-110"></i>
                                                </button>
										</span>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="nav-search" id="">
                        <a href="${basePath}/account/doAdd?keyword="${queryBean.keyword}&currentPage=${queryBean.currentPage}&pageSize=${queryBean.pageSize}" class="btn btn-sm btn-success">
                            <i class="icon-plus"></i>
                            新增
                        </a>
                    </div>
                    <h3 class="header smaller lighter blue"></h3>
                    <div class="table-header"><%--中间蓝色框--%></div>

                    <div class="table-responsive">
                        <table id="sample-table-2" class="table table-striped table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th class="center col-sm-1">
                                        <label>
                                            <input type="checkbox" class="ace" /> <span class="lbl"></span>
                                        </label>
                                    </th>
                                    <th class="center col-sm-2">用户名称</th>
                                    <th class="center col-sm-2">用户账号</th>
                                    <th class="center col-sm-1">手机号码</th>
                                    <th class="center col-sm-1">邮箱地址</th>
                                    <th class="center col-sm-1">描述</th>
                                    <th class="center col-sm-2">操作</th>

                            </thead>
                            <tbody>
                                <c:forEach items="${pageDataList.pageRecords}" var="item">
                                     <tr>
                                    <td class="center">
                                        <label>
                                            <input type="checkbox" class="ace" />
                                            <span class="lbl"></span>
                                        </label>
                                    </td>
                                    <td class="center"> <a href="#">${item.nickname}</a> </td>
                                    <td class="center">${item.accountname}</td>
                                    <td class="center">${item.phone}</td>
                                    <td class="center">${item.email}</td>
                                    <td class="center">${item.description}</td>
                                    <td class="center">
                                        <div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
                                                <a href="${basePath}/account/doEdit/${item.id}?keyword=${queryBean.keyword}&currentPage=${queryBean.currentPage}&pageSize=${queryBean.pageSize}" class="btn btn-minier btn-primary ">
                                                    <i class="icon-edit"></i>
                                                    编辑
                                                </a>
                                                <a href="${basePath}/account/doRoleForm/${item.id}?keyword=${queryBean.keyword}&currentPage=${queryBean.currentPage}&pageSize=${queryBean.pageSize}"  class="btn btn-minier btn-info ">
                                                <%--<a data-toggle="modal" href="www.baidu.com" data-target="#roleSetModel" class="btn btn-minier btn-info ">--%>
                                                    <i class="icon-wrench"></i>
                                                    角色设置
                                                </a>
                                                <button  onclick="deleteButton(${item.id})" class="btn btn-minier btn-danger">
                                                    <i class="icon-trash "></i>
                                                    删除
                                                </button>
                                        </div>
                                    </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>


                <!-- 频道信息新增 Modal start -->

            </div>
        </div>
    </div>

</div>
<script>
        function deleteButton(id){
            bootbox.confirm({
                buttons: {
                    confirm: {
                        label: '确认',
                    },
                    cancel: {
                        label: '取消',
                    }
                },
                message: '你确定要删除该用户吗?',
                callback: function(result) {
                    if(result) {
                        window.location = "${basePath}/account/deleteById/"+id + "?keyword=" + $("#keyword").val() + "&currentPage="+${queryBean.currentPage}+
                        "&pageSize=" +${queryBean.pageSize};
                    }
                },
            });
        }

</script>

</body>
</html>
