<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <li class="active">${account eq null ?"新增":"修改"}用户角色</li>
        </ul><!-- .breadcrumb -->

        <!-- #nav-search -->
    </div>
    <div class="page-content">
        <div class="page-header">

        </div><!-- /.page-header -->

        <div class="row">
            <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->

                <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/account/saveOrUpdateRole" method="post">
                    <input type="hidden" name="id" id="id" value="${account.id}">
                    <input type="hidden" name="keyword" id="keyword" value="${queryBean.keyword}">
                    <input type="hidden" name="currentPage" id="currentPage" value="${queryBean.currentPage}">
                    <input type="hidden" name="pageSize" id="pageSize" value="${queryBean.pageSize}">


                    <c:forEach items="${roles}" var="item">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"></label>
                            <div class="col-sm-9">
                                <input type="checkbox" name="rolecheckbox"  value="${item.id}"><span>${item.name}</span>
                            </div>

                        </div>
                        <div class="space-4"></div>
                    </c:forEach>


                    <div class=" ">
                        <div class="col-md-offset-3 col-md-9">
                            <button class="btn btn-info" type="button" onclick="sumbitRole()">
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
<script>
    function sumbitRole() {
        var roleIds = "";
        $("input[name='rolecheckbox']:checkbox:checked").each(function(){
            roleIds+=$(this).val()+"&"
        })
        $.ajax({
            url: "${pageContext.request.contextPath}/account/saveOrUpdateRole",
            type :"GET",
            data:{roleIds:roleIds,accountId:$("#id").val()},
            async: false,
            dataType : "text",
            success: function(data){
                if(data){
                    window.location=history.back();
                }
            }
        });

    }

</script>
</body>
</html>
