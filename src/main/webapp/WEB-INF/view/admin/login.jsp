<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>登录</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
    <!--  
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
   <script>if(window.top !== window.self){ window.top.location = window.location;}</script> 
</head>

<body class="gray-bg">
<input type="hidden" id="base" value="${basePath}" />
    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>

              <h1 class="logo-name">hi</h1>

            </div>
            <h3>欢迎进入陕西烟草西安市公司运维后台</h3>


            <div class="m-t" role="form"  >
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="用户名" name="nameOrEmail" id="nameOrEmail" >
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="密码" name="userPassword" id="userPassword" >
                </div>
                <button  class="btn btn-primary block full-width m-b" id="sub">登 录</button>
            </div>
        </div>
    </div>

    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script> 

  <script>

	$("#sub").click(function(){
		
	var  nameOrEmail = document.getElementById("nameOrEmail").value;
    var  userPassword = document.getElementById("userPassword").value;
         
        $.ajax({
            type: "POST",
            url: "adminLogin",
            data: {
                "nameOrEmail":nameOrEmail,
                "userPassword": userPassword
            },
            dataType: "json",
            success: function(data) {
            	if(data.value=="0"){
            		alert("用户名或密码有误！");
				self.location='login';
			}else if(data.value=="1"){
				
				self.location = "index";
        	}                	
            }
           
        }) 
        return true;

	})
  
  </script>  
    

</body>

</html>