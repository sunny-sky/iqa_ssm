<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head> 
  <meta charset="utf-8" /> 
  <meta name="viewport" content="width=device-width, initial-scale=1.0" /> 
  <title>增加配置信息</title> 
  <meta name="keywords" content="" /> 
  <meta name="description" content="" /> 
  <link rel="shortcut icon" href="favicon.ico" /> 
  <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet" /> 
  <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet" /> 
  <link href="css/plugins/iCheck/custom.css" rel="stylesheet" /> 
  <link href="css/animate.css" rel="stylesheet" /> 
  <link href="css/style.css?v=4.1.0" rel="stylesheet" /> 
  <link rel="stylesheet" type="text/css" href="css/plugins/markdown/bootstrap-markdown.min.css" /> 
  
 </head> 
 <body class="gray-bg"> 
  <input type="hidden" id="base" value="${basePath}" />
  <div class="wrapper wrapper-content animated fadeInRight"> 
   <div class="row"> 
    <div class="col-sm-12"> 
     <div class="ibox float-e-margins"> 
      <div class="ibox-title"> 
       <h5>新增设备信息 <small> </small></h5> 
       <div class="ibox-tools"> 
        <a class="collapse-link"> <i class="fa fa-chevron-up"></i> </a> 
        <a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#"> <i class="fa fa-wrench"></i> </a> 
        <ul class="dropdown-menu dropdown-user"> 
         <li><a href="form_basic.html#">选项1</a> </li> 
         <li><a href="form_basic.html#">选项2</a> </li> 
        </ul> 
        <a class="close-link"> <i class="fa fa-times"></i> </a> 
       </div> 
      </div> 
      
      <div class="form-horizontal"> 
       <div class="form-group"> 
        <label class="col-sm-2 control-label">使用人员：</label> 
        <div class="col-sm-10"> 
         <input type="text" class="form-control" id="user" placeholder="请输入使用人员姓名" style="width:  69%;float: left;" /> 
         <div class="validate_faqadd spa1"></div> 
        </div> 
       </div> 
       <div class="hr-line-dashed"></div> 
       
       <div class="form-group"> 
        <label class="col-sm-2 control-label">部门：</label> 
        <div class="col-sm-10"> 
         <input type="text" class="form-control" id="department" placeholder="请输入部门名称" style="width:  69%;float: left;" /> 
         <div class="validate_faqadd spa2"></div> 
        </div> 
       </div> 
       <div class="hr-line-dashed"></div> 
      
       <div class="form-group"> 
        <label class="col-sm-2 control-label">品牌：</label> 
        <div class="col-sm-10"> 
          <input type="text" class="form-control" id="brand" placeholder="请输入品牌名称" style="width:  69%;float: left;" /> 
         <div class="validate_faqadd spa3"></div>       
        </div> 
       </div> 
       <div class="hr-line-dashed"></div> 
       
       <div class="form-group" > 
        <label class="col-sm-2 control-label">配置时间：</label> 
        <div class="col-sm-10"> 
          <input id="hello" class="laydate-icon form-control layer-date">
          <div class="validate_faqadd spa4"></div>
        </div> 
       </div> 
       <div class="hr-line-dashed"></div> 
       
       <div class="form-group"> 
        <label class="col-sm-2 control-label">CPU：</label> 
        <div class="col-sm-10"> 
         <input type="text" class="form-control" id="CPU" placeholder="eg:i5-4590" style="width:  69%;float: left;" /> 
         <div class="validate_faqadd spa5"></div> 
        </div> 
       </div> 
       <div class="hr-line-dashed"></div>
       
       <div class="form-group"> 
        <label class="col-sm-2 control-label">内存：</label> 
        <div class="col-sm-10"> 
         <input type="text" class="form-control" id="RAM" placeholder="eg:4G" style="width:  69%;float: left;" /> 
         <div class="validate_faqadd spa6"></div> 
        </div> 
       </div> 
       <div class="hr-line-dashed"></div>
       
       <div class="form-group"> 
        <label class="col-sm-2 control-label">硬盘：</label> 
        <div class="col-sm-10"> 
         <input type="text" class="form-control" id="ROM" placeholder="eg:500G" style="width:  69%;float: left;" /> 
         <div class="validate_faqadd spa7"></div>
        </div> 
       </div> 
       <div class="hr-line-dashed"></div> 
       
       <div class="form-group"> 
        <label class="col-sm-2 control-label">操作系统：</label> 
        <div class="col-sm-10"> 
        <input type="text" class="form-control" id="os" placeholder="eg:windows8.1 专业版" style="width:  69%;float: left;" /> 
         <div class="validate_faqadd spa8"></div>
        </div> 
       </div> 
       <div class="hr-line-dashed"></div>
       
       <div class="form-group"> 
        <label class="col-sm-2 control-label">浏览器及版本：</label> 
        <div class="col-sm-10"> 
         <input type="text" class="form-control" id="browser" placeholder="eg:IE 11" style="width:  69%;float: left;" /> 
         <div class="validate_faqadd spa9"></div>
        </div> 
       </div> 
       <div class="hr-line-dashed"></div>
      
      <div class="form-group"> 
        <label class="col-sm-2 control-label">办公软件及版本：</label> 
        <div class="col-sm-10"> 
         <input type="text" class="form-control" id="office_software" placeholder="eg:office2007" style="width:  69%;float: left;" /> 
         <div class="validate_faqadd spa10"></div>
        </div> 
       </div> 
       <div class="hr-line-dashed"></div>
       
       <div class="form-group"> 
        <label class="col-sm-2 control-label">主要业务应用：</label> 
        <div class="col-sm-10"> 
         <input type="text" class="form-control" id="used_for" placeholder="eg:专卖系统，内管系统（以逗号分隔）" style="width:  69%;float: left;" /> 
         <div class="validate_faqadd spa11"></div>
        </div> 
       </div> 
       <div class="hr-line-dashed"></div>
       
       <div class="form-group"> 
        <label class="col-sm-2 control-label">IP地址：</label> 
        <div class="col-sm-10"> 
         <input type="text" class="form-control" id="IP" placeholder="eg:10.0.0.1" style="width:  69%;float: left;" /> 
         <div class="validate_faqadd spa12"></div>
        </div> 
       </div> 
       <div class="hr-line-dashed"></div>
       
       <div class="form-group"> 
        <label class="col-sm-2 control-label">MAC地址：</label> 
        <div class="col-sm-10"> 
         <input type="text" class="form-control" id="MAC" placeholder="eg:44-37-E6-58-60-C3" style="width:  69%;float: left;" /> 
         <div class="validate_faqadd spa13"></div>
        </div> 
       </div> 
       <div class="hr-line-dashed"></div>
       
       <div class="form-group"> 
        <label class="col-sm-2 control-label">地区：</label> 
        <div class="col-sm-10"> 
         <input type="text" class="form-control" id="region"  placeholder="eg:灞桥区" style="width:  69%;float: left;" /> 
         <div class="validate_faqadd spa14"></div>
        </div> 
       </div> 
       <div class="hr-line-dashed"></div>
       
       
      
       <div class="form-group"> 
        <div class="col-sm-4 col-sm-offset-2">           
         <button class="btn btn-primary" type="submit" onclick="window.history.back(-1)">取消</button> 
         <button class="btn btn-primary" type="submit" onclick="addUserEquipments()" data-dialog="somedialog">保存内容</button>
        </div> 
       </div> 
      </div> 
     </div> 
    </div> 
   </div> 
  </div>  
 
 
 
  <!-- 全局js --> 
  <script src="js/jquery.min.js?v=2.1.4"></script> 
  <script src="js/bootstrap.min.js?v=3.3.6"></script> 
 
  <!-- 自定义js --> 
  <script src="js/content.js?v=1.0.0"></script> 
 
  <!-- simditor --> 
  <script type="text/javascript" src="js/plugins/markdown/markdown.js"></script> 
  <script type="text/javascript" src="js/plugins/markdown/to-markdown.js"></script> 
  <script type="text/javascript" src="js/plugins/markdown/bootstrap-markdown.js"></script> 
  <script type="text/javascript" src="js/plugins/markdown/bootstrap-markdown.zh.js"></script> 
 
  <!-- iCheck --> 
  <script src="js/plugins/iCheck/icheck.min.js"></script> 
  
   <!-- layerDate plugin javascript -->
    <script src="js/plugins/layer/laydate/laydate.js"></script>
  
  <script>
  var base = $('#base').val();
     $("input").blur(function() {
		$(".validate_faqadd").css("color", "#BD362F") 
		
		if ($(this).is("#user")) { 
			var na = /^\S{2,4}$/
			if ($("#user").val() != "") {
				if (! (na.test($("#user").val()))) {
					$(".spa1").text("请输入2-4个字符");
					$(this).css("border", "1px solid #BD362F") ;
					return false;
				} else if (na) {
					$(".spa1").text("");
					return true;
				}
			} else {
				$(".spa1").text("");
			}
		}
		
		if ($(this).is("#department")) { 
			var na = /^\S{2,20}$/
			if ($("#department").val() != "") {
				if (! (na.test($("#department").val()))) {
					$(".spa2").text("请输入2-20个字符");
					$(this).css("border", "1px solid #BD362F") ;
					return false;
				} else if (na) {
					$(".spa2").text("");
					return true;
				}
			} else {
				$(".spa2").text("");
			}
		}
		
		 if ($(this).is("#IP")) { 
			var kw = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/
			if ($("#IP").val() != "") {
				if (! (kw.test($("#IP").val()))) {
					$(".spa12").text("请输入正确的IP地址");
					$(this).css("border", "1px solid #BD362F");
					return false;
				} else if (kw) {
					$(".spa12").text("");
					return true;
				}
			} else {
				$(".spa12").text("");
			}
		}
		
		if ($(this).is("#MAC")) { 
			var kw = /^[A-F0-9]{2}(-[A-F0-9]{2}){5}$/
			if ($("#MAC").val() != "") {
				if (! (kw.test($("#MAC").val()))) {
					$(".spa13").text("请按标准格式输入");
					$(this).css("border", "1px solid #BD362F");
					return false;
				} else if (kw) {
					$(".spa13").text("");
					return true;
				}
			} else {
				$(".spa13").text("");
			}
		} 
		
		if ($(this).is("#region")) { 
			var kw = /^\S{2,15}$/
			if ($("#region").val() != "") {
				if (! (kw.test($("#region").val()))) {
					$(".spa14").text("请输入2-20个字符");
					$(this).css("border", "1px solid #BD362F");
					return false;
				} else if (kw) {
					$(".spa14").text("");
					return true;
				}
			} else {
				$(".spa14").text("");
			}
		}
	
	})



 	$("input").focus(function() {
		if ($(this).is("#user")) {
			$(".spa1").text("不超过4个字符").css("color", "#aaa") ;
			$(this).css("border", "1px solid #aaa");
		}
		if ($(this).is("#department")) {
			$(".spa2").text("请输入部门信息").css("color", "#aaa");
			$(this).css("border", "1px solid #aaa");
		}
		if ($(this).is("#IP")) {
			$(".spa12").text("请输入IP地址").css("color", "#aaa") ;
			$(this).css("border", "1px solid #aaa");
		}
		if ($(this).is("#MAC")) {
			$(".spa13").text("请输入MAC地址").css("color", "#aaa");
			$(this).css("border", "1px solid #aaa");
		}
		if ($(this).is("#region")) {
			$(".spa14").text("请输入所属区域").css("color", "#aaa") ;
			$(this).css("border", "1px solid #aaa");
		}
		
	}) 


	
	
	function addUserEquipments() {
		var kw = /^\S{2,4}$/  
    	var dp = /^\S{2,20}$/
    	var ipadd = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/
    	var macadd = /^[A-F0-9]{2}(-[A-F0-9]{2}){5}$/
    	if(kw.test($("#user").val())&&dp.test($("#department").val())&&dp.test($("#region").val())&&ipadd.test($("#IP").val())&&macadd.test($("#MAC").val())){
				var user = document.getElementById("user").value;
				var department = document.getElementById("department").value;
				var brand = document.getElementById("brand").value;
				var hello = document.getElementById("hello").value;		//时间
				var CPU = document.getElementById("CPU").value;
				var RAM = document.getElementById("RAM").value;
				var ROM = document.getElementById("ROM").value;
				var os = document.getElementById("os").value;			
				var browser = document.getElementById("browser").value;
				var office_software = document.getElementById("office_software").value;
				var used_for = document.getElementById("used_for").value;
				var IP = document.getElementById("IP").value;
				var MAC = document.getElementById("MAC").value;
				var region = document.getElementById("region").value;
				

				$.ajax({
					type:"POST",
					url:base+"/addUserEquipments.html",
					data:{
						"user":user,
						"department":department,
						"brand":brand,
						"hello":hello,
						"CPU":CPU,
						"RAM":RAM,
						"ROM":ROM,
						"os":os,
						"browser":browser,
						"office_software":office_software,
						"used_for":used_for,
						"IP":IP,
						"MAC":MAC,
						"region":region,
					},
					dataType:"json",
					success:function(data){
						 if(data == "1"){
				        	   alert("添加成功");
				               window.location.reload();
				           }else if(data == "0"){
				        	   alert("重复添加");
					           window.location.reload();
				           }
					}
				}) 
     }else{
    	 
    	if($("#user").val()==""){
			$(".spa1").text('请填写您的姓名')
		}
		if($("#department").val()==""){
			$(".spa2").text('请填写您的部门')
		}
		if($("#IP").val()==""){
			$(".spa12").text('请您填写IP地址')
		}
		if($("#MAC").val()==""){
			$(".spa13").text('请您填写MAC地址')
		} 
		if($("#region").val()==""){
			$(".spa14").text('请您填写所属区域')
		}
		
     }
     }
		
			
		
	
	//外部js调用
        laydate({
            elem: '#hello', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
            event: 'focus' //响应事件。如果没有传入event，则按照默认的click
        });
   //日期范围限制
     var start = {
         elem: '#start',
         format: 'YYYY/MM/DD hh:mm:ss',
         min: laydate.now(), //设定最小日期为当前日期
         max: '2099-06-16 23:59:59', //最大日期
         istime: true,
         istoday: false,
         choose: function (datas) {
             end.min = datas; //开始日选好后，重置结束日的最小日期
             end.start = datas //将结束日的初始值设定为开始日
         }
     };
     var end = {
         elem: '#end',
         format: 'YYYY/MM/DD hh:mm:ss',
         min: laydate.now(),
         max: '2099-06-16 23:59:59',
         istime: true,
         istoday: false,
         choose: function (datas) {
             start.max = datas; //结束日选好后，重置开始日的最大日期
         }
     };
     laydate(start);
     laydate(end);
	//提交成功
function codefans(){
	var box=document.getElementById("success");
	box.style.display="none"; 
}

//重复提交
function codefans2(){
	var box=document.getElementById("chongfu");
	box.style.display="none"; 
}
 </script>
  
  <div class="success" id="success" style="z-index:1001;position:fixed;top:40%;left:45%;width:220px;background: #f3f3f3;text-align: center;border:1px solid black;border-radius:3px;display:none">
   <div style="margin-top:30px; margin-bottom:30px;">
    <img src="images/true.png" style="width:20px;height:20px;margin-right:10px;" />
    <h2 style="font-size:16px;display:inline-block;line-height:22px;vertical-align:top">操作成功</h2>
   </div>
  </div> 
  <div class="success" id="chongfu" style="z-index:1001;position:fixed;top:40%;left:45%;width:220px;background: #f3f3f3;text-align: center;border:1px solid black;border-radius:3px;display:none">
   <div style="margin-top:30px; margin-bottom:30px;">
    <img src="images/cuo.png" style="width:20px;height:20px;margin-right:10px;" />
    <h2 style="font-size:16px;display:inline-block;line-height:22px;vertical-align:top">重复提交</h2>
   </div>
  </div>  
 </body>
</html>