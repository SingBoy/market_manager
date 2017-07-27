<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/22
  Time: 16:06
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
        <script type="text/javascript">
            try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
        </script>

        <ul class="breadcrumb">
            <li>
                <i class="icon-home home-icon"></i>
                <a href="#">首页</a>
            </li>
            <li class="active">控制台</li>
        </ul><!-- .breadcrumb -->

        <div class="nav-search" id="nav-search">
            <form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="icon-search nav-search-icon"></i>
								</span>
            </form>
        </div><!-- #nav-search -->
    </div>

    <div class="page-content">
        <div class="page-header">
            <h1>
                控制台
                <small>
                    <i class="icon-double-angle-right"></i>
                    查看
                </small>
            </h1>
        </div><!-- /.page-header -->

        <div class="row">
            <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->

                <div class="alert alert-block alert-success">
                    <button type="button" class="close" data-dismiss="alert">
                        <i class="icon-remove"></i>
                    </button>

                    <i class="icon-ok green"></i>

                    欢迎使用
                    <strong class="green">
                        Ace后台管理系统
                        <small>(v1.2)</small>
                    </strong>
                    ,轻量级好用的后台管理系统模版.
                </div>

                <div class="row">
                    <div class="space-6"></div>

                    <div class="col-sm-7 infobox-container">
                        <div class="infobox infobox-green  ">
                            <div class="infobox-icon">
                                <i class="icon-comments"></i>
                            </div>

                            <div class="infobox-data">
                                <span class="infobox-data-number">32</span>
                                <div class="infobox-content">2个评论</div>
                            </div>
                            <div class="stat stat-success">8%</div>
                        </div>

                        <div class="infobox infobox-blue  ">
                            <div class="infobox-icon">
                                <i class="icon-twitter"></i>
                            </div>

                            <div class="infobox-data">
                                <span class="infobox-data-number">11</span>
                                <div class="infobox-content">新粉丝</div>
                            </div>

                            <div class="badge badge-success">
                                +32%
                                <i class="icon-arrow-up"></i>
                            </div>
                        </div>

                        <div class="infobox infobox-pink  ">
                            <div class="infobox-icon">
                                <i class="icon-shopping-cart"></i>
                            </div>

                            <div class="infobox-data">
                                <span class="infobox-data-number">8</span>
                                <div class="infobox-content">新订单</div>
                            </div>
                            <div class="stat stat-important">4%</div>
                        </div>

                        <div class="infobox infobox-red  ">
                            <div class="infobox-icon">
                                <i class="icon-beaker"></i>
                            </div>

                            <div class="infobox-data">
                                <span class="infobox-data-number">7</span>
                                <div class="infobox-content">调查</div>
                            </div>
                        </div>

                        <div class="infobox infobox-orange2  ">
                            <div class="infobox-chart">
                                <span class="sparkline" data-values="196,128,202,177,154,94,100,170,224"></span>
                            </div>

                            <div class="infobox-data">
                                <span class="infobox-data-number">6,251</span>
                                <div class="infobox-content">页面查看次数</div>
                            </div>

                            <div class="badge badge-success">
                                7.2%
                                <i class="icon-arrow-up"></i>
                            </div>
                        </div>

                        <div class="infobox infobox-blue2  ">
                            <div class="infobox-progress">
                                <div class="easy-pie-chart percentage" data-percent="42" data-size="46">
                                    <span class="percent">42</span>%
                                </div>
                            </div>

                            <div class="infobox-data">
                                <span class="infobox-text">交易使用</span>

                                <div class="infobox-content">
                                    <span class="bigger-110">~</span>
                                    剩余58GB
                                </div>
                            </div>
                        </div>

                        <div class="space-6"></div>

                        <div class="infobox infobox-green infobox-small infobox-dark">
                            <div class="infobox-progress">
                                <div class="easy-pie-chart percentage" data-percent="61" data-size="39">
                                    <span class="percent">61</span>%
                                </div>
                            </div>

                            <div class="infobox-data">
                                <div class="infobox-content">任务</div>
                                <div class="infobox-content">完成</div>
                            </div>
                        </div>

                        <div class="infobox infobox-blue infobox-small infobox-dark">
                            <div class="infobox-chart">
                                <span class="sparkline" data-values="3,4,2,3,4,4,2,2"></span>
                            </div>

                            <div class="infobox-data">
                                <div class="infobox-content">获得</div>
                                <div class="infobox-content">$32,000</div>
                            </div>
                        </div>

                        <div class="infobox infobox-grey infobox-small infobox-dark">
                            <div class="infobox-icon">
                                <i class="icon-download-alt"></i>
                            </div>

                            <div class="infobox-data">
                                <div class="infobox-content">下载次数</div>
                                <div class="infobox-content">1,205</div>
                            </div>
                        </div>
                    </div>

                    <div class="vspace-sm"></div>

                    <div class="col-sm-5">
                        <div class="widget-box">
                            <div class="widget-header widget-header-flat widget-header-small">
                                <h5>
                                    <i class="icon-signal"></i>
                                    访问来源
                                </h5>

                                <div class="widget-toolbar no-border">
                                    <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown">
                                        本周
                                        <i class="icon-angle-down icon-on-right bigger-110"></i>
                                    </button>

                                    <ul class="dropdown-menu pull-right dropdown-125 dropdown-lighter dropdown-caret">
                                        <li class="active">
                                            <a href="#" class="blue">
                                                <i class="icon-caret-right bigger-110">&nbsp;</i>
                                                本周
                                            </a>
                                        </li>

                                        <li>
                                            <a href="#">
                                                <i class="icon-caret-right bigger-110 invisible">&nbsp;</i>
                                                上周
                                            </a>
                                        </li>

                                        <li>
                                            <a href="#">
                                                <i class="icon-caret-right bigger-110 invisible">&nbsp;</i>
                                                本月
                                            </a>
                                        </li>

                                        <li>
                                            <a href="#">
                                                <i class="icon-caret-right bigger-110 invisible">&nbsp;</i>
                                                上月
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>

                            <div class="widget-body">
                                <div class="widget-main">
                                    <div id="piechart-placeholder"></div>

                                    <div class="hr hr8 hr-double"></div>

                                    <div class="clearfix">
                                        <div class="grid3">
															<span class="grey">
																<i class="icon-facebook-sign icon-2x blue"></i>
																&nbsp; likes
															</span>
                                            <h4 class="bigger pull-right">1,255</h4>
                                        </div>

                                        <div class="grid3">
															<span class="grey">
																<i class="icon-twitter-sign icon-2x purple"></i>
																&nbsp; tweets
															</span>
                                            <h4 class="bigger pull-right">941</h4>
                                        </div>

                                        <div class="grid3">
															<span class="grey">
																<i class="icon-pinterest-sign icon-2x red"></i>
																&nbsp; pins
															</span>
                                            <h4 class="bigger pull-right">1,050</h4>
                                        </div>
                                    </div>
                                </div><!-- /widget-main -->
                            </div><!-- /widget-body -->
                        </div><!-- /widget-box -->
                    </div><!-- /span -->
                </div><!-- /row -->


                <div class="hr hr32 hr-dotted"></div>

                <!-- PAGE CONTENT ENDS -->
            </div><!-- /.col -->
        </div><!-- /.row -->
    </div><!-- /.page-content -->
</div><!-- /.main-content -->
</body>
</html>
