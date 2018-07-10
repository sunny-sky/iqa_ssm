<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - 您还没有此权限</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">

<input type="hidden" id="base" value="${basePath}" />
   <div class="middle-box text-center loginscreen   animated fadeInDown">
        <div style="margin-top: 60%">
            
            <h3>密码修改</h3>
            <form class="m-t" role="form">
               	<div class="form-group">
                   	 当前用户名：${username}
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="请输入原始密码"  id="password" oninput="_password()">
                    <label class="focus valid spa1"></label>
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="请输入新密码"  id="password2" oninput="_password2()">
                    <label class="focus valid error spa2"></label>
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="请再次输入密码"  id="repassword2" oninput="_repassword2()">
                    <label class="focus valid error spa3"></label>
                </div>
                
                <button type="submit" class="btn btn-primary block full-width m-b" id="submitupdatePassword">确认提交</button>
                
            </form>
        </div>
    </div>
	<div class="success" id="success" style="z-index:1001;position:fixed;top:40%;left:45%;width:220px;background: #f3f3f3;text-align: center;border:1px solid black;border-radius:3px;display:none"><div style="margin-top:30px; margin-bottom:30px;"><img src="images/true.png" style="width:20px;height:20px;margin-right:10px;"><h2 style="font-size:16px;display:inline-block;line-height:22px;vertical-align:top">密码修改成功</h2></div></div>
    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
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

	<script>

	function _password(){
		if($("#password").val()!=""){
			var pw = /^\w{6,16}$/;
			if(!(pw.test($("#password").val()))){
				$(".spa1").text("密码由字母、数字、下划线组成且6-16位");
				return false;
			}else if (pw){
				$(".spa1").text("");
				return true;
			}
		}else{
			$(".spa1").text("");
		}
	}

	function _password2(){
		if($("#password2").val()!=""){
			var pw = /^\w{6,16}$/;
			if(!(pw.test($("#password2").val()))){
				$(".spa2").text("密码由字母、数字、下划线组成且6-16位");
				return false;
			}else if (pw){
				$(".spa2").text("");
				return true;
			}
		}else{
			$(".spa2").text("");
		}
	}

	function _repassword2(){
		if($("#repassword2").val()!=""){
			var pw = $("#password2").val();
			if(!(pw==$("#repassword2").val())){
				$(".spa3").text("两次输入的密码不一致");
				return false;
			}else if (pw){
				$(".spa3").text("");
				return true;
			}
		}else{
			$(".spa3").text("");
		}
	}
	
	$("#submitupdatePassword").click(function(){
		var pw = /^\w{6,16}$/;
		var rpw = $("#repassword2").val();
		if(pw.test($("#password").val())&&pw.test($("#password2").val())&&(rpw==($("#password2").val()))){
		$.ajax({
			type:"POST",
			url:"updateUserPassword",
			data:{
				"password":$("#password").val(),
				"password2":$("#password2").val(),
				"repassword2":$("#repassword2").val()
			},
			dataType:"json",
			success:function(data){
				if(data=="0"){
					$(".spa2").text('新密码不能与原密码相同');
					alert("新密码不能与原密码相同")
				}
				else if(data=="1"){
					$(".spa1").text('原密码错误');	
					alert("原密码错误")
				}
				else{
					
					alert("密码更改成功")					
				}
			}
			})
			return true;
		}else{
		if($("#password").val()==""){
			$(".spa1").text('请填写密码');
		}
		if($("#password2").val()==""){
			$(".spa2").text('请填写新密码');
		}
		if($("#repassword2").val()==""){
			$(".spa3").text('请再次填写密码');
			}
			return false;
		}
	});
	
	//提交成功
	function codefans(){
		var box=document.getElementById("success");
		box.style.display="none"; 
	}
	</script>
    
    

</body>

</html>
