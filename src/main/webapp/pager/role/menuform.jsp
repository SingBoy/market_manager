<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: yuxiangjie
  Date: 2017/7/22
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

</head>

<body>

<div class="main-container" id="main-container">


    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#">
            <span class="menu-text"></span>
        </a>
        <div class="main-content">
            <div class="page-content">

                    <div class="col-sm-6">

                        <div class="widget-body">
                            <c:forEach items="${menuMapList}" var="map">
                                    <div class="widget-main padding-8">
                                        <input type="checkbox" />
                                        <c:out value="${map.key.name }"></c:out>
                                       <%-- <span>${map.name}</span>--%>
                                       <c:forEach items="${map.value}" var="list">
                                            <input id="" value="">${list.name}</input>
                                        </c:forEach>
                                    </div>
                            </c:forEach>

                        </div>


                        <div class="widget-box">
                            <div class="widget-header header-color-blue2">
                            <h4 class="lighter smaller">Choose Categories</h4>
                        </div>
                            <div class="widget-body">
                                <div class="widget-main padding-8">
                                    <div id="tree1" class="tree"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                        <!-- PAGE CONTENT ENDS -->
            </div><!-- /.page-content -->
        </div><!-- /.main-content -->
    </div><!-- /.main-container-inner -->


</div><!-- /.main-container -->

<script type="text/javascript">
    window.jQuery || document.write("<script src='${pageContext.request.contextPath}/plugins/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>
<script src="${pageContext.request.contextPath}/plugins/js/fuelux/data/fuelux.tree-sampledata.js"></script>
<script src="${pageContext.request.contextPath}/plugins/js/fuelux/fuelux.tree.min.js"></script>
<script type="text/javascript">
    jQuery(function($){
        $('#tree1').ace_tree({
            dataSource: treeDataSource ,
            multiSelect:false,
            loadingHTML:'<div class="tree-loading"><i class="icon-refresh icon-spin blue"></i></div>',
            'open-icon' : 'icon-minus',
            'close-icon' : 'icon-plus',
            'selectable' : true,
            'selected-icon' : 'icon-ok',
            'unselected-icon' : 'icon-remove'
        });
    });
</script>
</body>
</html>
