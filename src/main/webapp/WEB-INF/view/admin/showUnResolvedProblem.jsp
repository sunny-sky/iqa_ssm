<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>问题信息展示</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body class="gray-bg">
 <!-- <#list unResolvedProblemDetail as a> -->
 
    <div class="wrapper wrapper-content animated fadeInRight">
         
       
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
               
                    <div class="ibox-title">
                        <h5>问题信息</h5>
                         
                    </div>
                    <div class="ibox-content" style="padding-bottom: 50px">
                        <form method="get" class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">问题标题</label>

                                <div class="col-sm-10">
                                    <p class="form-control-static">${unResolvedProblemDetail.problemTitle}</p>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                           
                            <div class="form-group">
                                <label class="col-sm-2 control-label">提问内容</label>

                                <div class="col-sm-10">
                                    <p class="form-control-static">${unResolvedProblemDetail.problemContent}</p>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                                                  
                            <div class="form-group">
                                <label class="col-sm-2 control-label">问题类别</label>

                                <div class="col-sm-10">
                                    <p class="form-control-static">${unResolvedProblemDetail.problemClassifyName}</p>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            
                            <div class="form-group">
                                <label class="col-sm-2 control-label">提问用户</label>

                                <div class="col-sm-10">
                                    <p class="form-control-static">${unResolvedProblemDetail.problemUserName}</p>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                           
                            <div class="form-group">
                                <label class="col-sm-2 control-label">提问时间</label>

                                <div class="col-sm-10">
                                    <p class="form-control-static">${unResolvedProblemDetail.problemTime}</p>
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                        
                        </form>
                        

                         <div class="col-sm-4 col-sm-offset-2">
                             <button class="btn btn-primary" onclick="window.history.back(-1)">返回</button>                                   
                         </div>

                    </div>
					
                </div>
            </div>
        </div>
    </div>
 
<!-- </#list> -->
    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>

    <!-- 自定义js -->
    <script src="js/content.js?v=1.0.0"></script>

    <!-- iCheck -->
    <script src="js/plugins/iCheck/icheck.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>

    
     

</body>
</html>