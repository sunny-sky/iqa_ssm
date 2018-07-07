<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
	<meta name="keywords" content="">
    <meta name="description" content="">
	<link rel="shortcut icon" href="favicon.ico"> 
	<link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
	<title>烟草公司运维管理系统</title>
</head>
<!-- 全局js -->
<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.6"></script>
<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="js/plugins/layer/layer.min.js"></script>

<!-- 自定义js -->
<script src="js/hAdmin.js?v=4.1.0"></script>
<script type="text/javascript" src="js/index.js"></script>

<!-- 第三方插件 -->
<script src="js/plugins/pace/pace.min.js"></script>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
	<!-- 引入左侧导航栏 -->
	<%@include file="../admin/inc/incTop.jsp"%>


	<!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
      <div class="row border-bottom">
          <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
              <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-info " href="#"><i class="fa fa-bars"></i> </a>
                  
              </div>              
          </nav>
      </div>
     
      <!-- 其余模块都要嵌入其中 -->
      <!-- homePage.html为首页 -->
      <div class="row J_mainContent" id="content-main">
          <iframe id="J_iframe" width="100%" height="100%" src="homePage"  data-id="index_v1.html" seamless></iframe>
      </div>
   
    </div>
    <!--右侧部分结束-->
    
</div>
</body>
</html>