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
<%--<script src="${pageContext.request.contextPath}/plugins/js/fuelux/data/fuelux.tree-sampledata.js"></script>--%>
<script src="${pageContext.request.contextPath}/plugins/js/fuelux/fuelux.tree.min.js"></script>
<script type="text/javascript">

    var DataSourceTree = function(options) {
        this._data 	= options.data;
        this._delay = options.delay;
    }

    DataSourceTree.prototype.data = function(options, callback) {
        var self = this;
        var $data = null;

        if(!("name" in options) && !("type" in options)){
            $data = this._data;//the root tree
            callback({ data: $data });
            return;
        }
        else if("type" in options && options.type == "folder") {
            if("additionalParameters" in options && "children" in options.additionalParameters)
                $data = options.additionalParameters.children;
            else $data = {}//no data
        }

        if($data != null)//this setTimeout is only for mimicking some random delay
            setTimeout(function(){callback({ data: $data });} , parseInt(Math.random() * 500) + 200);

        //we have used static data here
        //but you can retrieve your data dynamically from a server using ajax call
        //checkout examples/treeview.html and examples/treeview.js for more info
    };

    var tree_data = {
        'for-sale' : {name: 'For Sale', type: 'folder'}	,
        'vehicles' : {name: 'Vehicles', type: 'folder'}	,
        'rentals' : {name: 'Rentals', type: 'folder'}	,
        'real-estate' : {name: 'Real Estate', type: 'folder'}	,
        'pets' : {name: 'Pets', type: 'folder'}	,
        'tickets' : {name: 'Tickets', type: 'item'}	,
        'services' : {name: 'Services', type: 'item'}	,
        'personals' : {name: 'Personals', type: 'item'}
    }
    tree_data['for-sale']['additionalParameters'] = {
        'children' : {
            'appliances' : {name: 'Appliances', type: 'item'},
            'arts-crafts' : {name: 'Arts & Crafts', type: 'item'},
            'clothing' : {name: 'Clothing', type: 'item'},
            'computers' : {name: 'Computers', type: 'item'},
            'jewelry' : {name: 'Jewelry', type: 'item'},
            'office-business' : {name: 'Office & Business', type: 'item'},
            'sports-fitness' : {name: 'Sports & Fitness', type: 'item'}
        }
    }
    tree_data['vehicles']['additionalParameters'] = {
        'children' : {
            'cars' : {name: 'Cars', type: 'folder'},
            'motorcycles' : {name: 'Motorcycles', type: 'item'},
            'boats' : {name: 'Boats', type: 'item'}
        }
    }
    tree_data['vehicles']['additionalParameters']['children']['cars']['additionalParameters'] = {
        'children' : {
            'classics' : {name: 'Classics', type: 'item'},
            'convertibles' : {name: 'Convertibles', type: 'item'},
            'coupes' : {name: 'Coupes', type: 'item'},
            'hatchbacks' : {name: 'Hatchbacks', type: 'item'},
            'hybrids' : {name: 'Hybrids', type: 'item'},
            'suvs' : {name: 'SUVs', type: 'item'},
            'sedans' : {name: 'Sedans', type: 'item'},
            'trucks' : {name: 'Trucks', type: 'item'}
        }
    }

    tree_data['rentals']['additionalParameters'] = {
        'children' : {
            'apartments-rentals' : {name: 'Apartments', type: 'item'},
            'office-space-rentals' : {name: 'Office Space', type: 'item'},
            'vacation-rentals' : {name: 'Vacation Rentals', type: 'item'}
        }
    }
    tree_data['real-estate']['additionalParameters'] = {
        'children' : {
            'apartments' : {name: 'Apartments', type: 'item'},
            'villas' : {name: 'Villas', type: 'item'},
            'plots' : {name: 'Plots', type: 'item'}
        }
    }
    tree_data['pets']['additionalParameters'] = {
        'children' : {
            'cats' : {name: 'Cats', type: 'item'},
            'dogs' : {name: 'Dogs', type: 'item'},
            'horses' : {name: 'Horses', type: 'item'},
            'reptiles' : {name: 'Reptiles', type: 'item'}
        }
    }

    var treeDataSource = new DataSourceTree({data: tree_data});

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
