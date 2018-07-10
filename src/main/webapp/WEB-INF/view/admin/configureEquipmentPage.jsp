<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
 <head> 
  <meta charset="utf-8" /> 
  <meta name="viewport" content="width=device-width, initial-scale=1.0" /> 
  <title>设备资源库</title> 
  <link rel="shortcut icon" href="favicon.ico" /> 
  <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet" /> 
  <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet" /> 
  <!-- Data Tables --> 
  <link href="css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet" /> 
  <link href="css/style.css?v=4.1.0" rel="stylesheet" /> 
  <!-- BEGIN GLOBAL MANDATORY STYLES --> 
  <link href="media/css/style.css" rel="stylesheet" type="text/css" /> 
 </head> 
 <body class="gray-bg"> 
  <input type="hidden" id="base" value="${basePath}" />
  <div class="wrapper wrapper-content animated fadeIn"> 
   <div class="row" style="height: 100%"> 
    <div class="col-sm-6" style="width: 100%; height: 100%"> 
     <div class="tabs-container"> 
      <div class="tab-content"> 
       <div id="tab-1" class="tab-pane active"> 
        <!--360浏览器优先以webkit内核解析--> 
        <div class="wrapper wrapper-content animated fadeIn"> 
         <div class="row"> 
          <div class="col-sm-6" style="width: 100%"> 
           <div class="tabs-container"> 
            <ul class="nav nav-tabs"> 
             <li class="active"><a data-toggle="tab" href="#tab-31" aria-expanded="true">用户设备【${equipmentsSize}】</a></li> 
            </ul> 
            <div class="tab-content"> 
             
             <!-- 用户设备信息 --> 
             <div id="tab-31" class="tab-pane active"> 
              <div class="ibox-title"> 
               <h5>用户设备信息</h5> 
               <div class="ibox-tools"> 
	               <!-- 模态框弹出权限 -->
	               <a href="configureUploadPage"><button class="btn btn-primary ">添加设备</button></a> 
               </div> 
              </div> 
              <div class="ibox-content"> 
	            
		       
		       <table class="table table-striped table-bordered table-hover dataTables-example"> 
		        <thead> 
                 <tr> 
                  <th style="text-align: center;">序号</th> 
                  <th style="text-align: center;">使用人员</th> 
                  <th style="text-align: center;">部门</th>
                  <th style="text-align: center;">品牌</th> 
                  <th style="text-align: center;">配置时间</th>
                  <th style="text-align: center;">CPU</th>
                  <th style="text-align: center;">内存</th>
                  <th style="text-align: center;">硬盘</th>                   
                  <th style="text-align: center;">操作系统</th> 
                  <th style="text-align: center;">浏览器</th> 
                  <th style="text-align: center;">办公软件及版本</th>                   
                  <th style="text-align: center;">主要业务应用</th> 
                  <th style="text-align: center;">IP地址</th> 
                  <th style="text-align: center;">MAC地址</th>
                  <th style="text-align: center;">地区</th>
                  <th style="text-align: center;">操作</th>
                 </tr> 
                </thead> 
                
                <tbody id = "option1">    
                 <!-- <#list equipmentsList as a> -->
                 <c:forEach items="${equipmentsList}" var="a" varStatus="status">
	                 <tr class="gradeX"> 
	                  <td style="text-align: center;width: 4%">${status.index+1 }</td>
	                  <td style="text-align: center;width: 6%">${a.USER }</td> 
	                  <td style="text-align: center;width: 6%">${a.DEPARTMENT }</td>
	                  <td style="text-align: center;width: 6%">${a.BRAND }</td> 
	                  <td style="text-align: center;width: 6%">${a.CONFIGURE_TIME }</td>
	                  <td style="text-align: center;width: 6%">${a.CPU }</td>
	                  <td style="text-align: center;width: 5%">${a.RAM }</td>
	                  <td style="text-align: center;width: 5%">${a.ROM }</td>              
	                  <td style="text-align: center;width: 8%">${a.OS }</td>
	                  <td style="text-align: center;width: 5%">${a.BROWSER }</td>
	                  <td style="text-align: center;width: 8%">${a.OFFICE_SOFTWARE }</td> 
	                  <td style="text-align: center;width: 13%">${a.USED_FOR }</td>
	                  <td style="text-align: center;width: 6%">${a.IP_ADDRESS }</td> 
	                  <td style="text-align: center;width: 6%">${a.MAC_ADDRESS }</td>
	                  <td style="text-align: center;width: 6%">${a.REGION }</td> 
	                  <td style="text-align: center;width: 10%">                  
	                  	<button class="btn btn-white btn-sm" type="button" id="computerEdit_${a.EQUIPMENT_ID}" onclick="editComputerInfo('${a.USER }','${a.DEPARTMENT}')" title="编辑" data-toggle="modal" data-target="#myModalEditComputer" ><i class="glyphicon glyphicon-pencil"></i></button> 
	                    <button class="btn btn-white btn-sm fa fa-trash-o" data-toggle="tooltip" data-placement="top" title="从标准配置移除" id="equipmentDelete_${a.EQUIPMENT_ID }" onclick="deleteEquipment(this.id)"></button> 
	                  </td> 
	                 </tr>
                 </c:forEach>
                 <!-- </#list>  -->
                 
                </tbody> 
		       </table>  
              </div> 
             </div> 
             
  
             
             
              <!-- 编辑计算机信息_模态框（Modal） --> 
		      <div class="modal fade" id="myModalEditComputer" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> 
		       <div class="modal-dialog"> 
		        <div class="modal-content" style="vertical-align: middle;margin-top: 100px"> 
		         <div class="modal-header"> 
		          <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button> 
		          <h4 class="modal-title" id="myModalLabel"> 编辑用户设备信息 </h4> 
		         </div> 
		         
		         <form class="form-horizontal m-t" method="post" action="add" > 
		          <div class="modal-body"> 
		           <div class="form-group" style="display: none;"> 
		            <div class="col-sm-8"> 
		             <input id="editEquiomentId" type="text" class="form-control" aria-required="true"></input>
		            </div> 
		           </div>
		           		          	           
		           <div class="form-group"> 
		            <label class="col-sm-3 control-label">使用人员：</label> 
		            <div class="col-sm-8"> 
		             <input id="user"  type="text" class="form-control"   aria-required="true" /> 
		             <div class="validate_faqadd spa1"></div>
		            </div> 
		           </div> 
		           
		           <div class="form-group"> 
		            <label class="col-sm-3 control-label">部门：</label> 
		            <div class="col-sm-8"> 
		             <input id="department"  type="text" class="form-control"   aria-required="true"  /> 
		           <div class="validate_faqadd spa2"></div>
		            </div> 
		           </div> 
		          
		           <div class="form-group"> 
		            <label class="col-sm-3 control-label">品牌：</label> 
		            <div class="col-sm-8"> 
		             <input id="band" type="text" class="form-control"   aria-required="true"  /> 
		            </div> 
		           </div>
		           
		           <div class="form-group"> 
		            <label class="col-sm-3 control-label">配置时间：</label> 
		            <div class="col-sm-8"> 
		             <input type="text" id="hello" class="laydate-icon form-control layer-date"   aria-required="true" /> 
		            </div> 
		           </div>
		           
		           
		           <div class="form-group"> 
		            <label class="col-sm-3 control-label">CPU：</label> 
		            <div class="col-sm-8"> 
		             <input id="CPU"  type="text" class="form-control"   aria-required="true" /> 
		            </div> 
		           </div>
		           
		           
		           <div class="form-group"> 
		            <label class="col-sm-3 control-label">内存：</label> 
		            <div class="col-sm-8"> 
		             <input id="RAM"  type="text" class="form-control"   aria-required="true"  /> 
		            </div> 
		           </div>
		           
		           
		           <div class="form-group"> 
		            <label class="col-sm-3 control-label">硬盘：</label> 
		            <div class="col-sm-8"> 
		             <input id="ROM"  type="text" class="form-control"   aria-required="true" /> 
		            </div> 
		           </div>
		           
		           <div class="form-group"> 
		            <label class="col-sm-3 control-label">操作系统：</label> 
		            <div class="col-sm-8"> 
		             <input id="os" type="text" class="form-control"   aria-required="true"/> 
		            </div> 
		           </div>
		           
		           <div class="form-group"> 
		            <label class="col-sm-3 control-label">浏览器：</label> 
		            <div class="col-sm-8"> 
		             <input id="browser"  type="text" class="form-control"   aria-required="true"/> 
		            </div> 
		           </div>
		           
		           <div class="form-group"> 
		            <label class="col-sm-3 control-label">办公软件及版本：</label> 
		            <div class="col-sm-8"> 
		             <input id="office_software"  type="text" class="form-control"   aria-required="true" /> 
		            </div> 
		           </div>
		           
		           <div class="form-group"> 
		            <label class="col-sm-3 control-label">主要业务应用：</label> 
		            <div class="col-sm-8"> 
		             <input id="used_for"  type="text" class="form-control"   aria-required="true"  /> 
		            </div> 
		           </div>
		           
		           
		           <div class="form-group"> 
		            <label class="col-sm-3 control-label">IP地址：</label> 
		            <div class="col-sm-8"> 
		             <input id="IP" type="text" class="form-control"   aria-required="true"  /> 
		            <div class="validate_faqadd spa12"></div>
		            </div> 
		           </div>
		           
		           <div class="form-group"> 
		            <label class="col-sm-3 control-label">MAC地址：</label> 
		            <div class="col-sm-8"> 
		             <input id="MAC"  type="text" class="form-control"   aria-required="true" placeholder="格式如下:64-31-50-37-C5-13"/> 
		             <div class="validate_faqadd spa13"></div>
		            </div> 
		           </div>
		           		    
		           <div class="form-group"> 
		            <label class="col-sm-3 control-label">地区：</label> 
		            <div class="col-sm-8"> 
		             <input id="region"  type="text" class="form-control"   aria-required="true" /> 
		            </div> 
		           </div>
		           		          		          		         		        
		          </div> 
		          <div class="modal-footer"> 
		           <button type="button" class="btn btn-default" data-dismiss="modal"> 关闭 </button> 
		           <button type="button" class="btn btn-primary" onclick="updateComputer()"> 提交 </button> 
		          </div> 
		         </form> 
		        </div>
		        <!-- /.modal-content --> 
		       </div>
		       <!-- /.modal-dialog --> 
		      </div>
		      <!-- /.modal -->
                                
            </div> 
           </div> 
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
    <script src="js/plugins/jeditable/jquery.jeditable.js"></script> 
    <!-- Data Tables --> 
    <script src="js/plugins/dataTables/jquery.dataTables.js"></script> 
    <script src="js/plugins/dataTables/dataTables.bootstrap.js"></script> 
    <!-- 自定义js --> 
    <script src="js/content.js?v=1.0.0"></script> 
    
     <!-- layerDate plugin javascript -->
    <script src="js/plugins/layer/laydate/laydate.js"></script>
    <!-- Page-Level Scripts --> 
    <script>
        $(document).ready(function () {
            $('.dataTables-example').dataTable();

            /* Init DataTables */
            var oTable = $('#editable').dataTable();

            /* Apply the jEditable handlers to the table */
            oTable.$('td').editable('../example_ajax.php', {
                "callback": function (sValue, y) {
                    var aPos = oTable.fnGetPosition(this);
                    oTable.fnUpdate(sValue, aPos[0], aPos[1]);
                },
                "submitdata": function (value, settings) {
                    return {
                        "row_id": this.parentNode.getAttribute('id'),
                        "column": oTable.fnGetPosition(this)[2]
                    };
                },

                "width": "90%",
                "height": "100%"
            });


        });

        function fnClickAddRow() {
            $('#editable').dataTable().fnAddData([
                "Custom row",
                "New row",
                "New row",
                "New row",
                "New row"]);

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
    </script> 
    
<script>
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
</script>
   
    
   <script>
   
    /* 获取要编辑的计算机信息 */
    function editComputerInfo(user,department) {
    	var user = user;
        var department = department;
    	if(user!=null&&department!=null){
    	 	$.ajax({
                type: "POST",
                url: "editEquipmentsInfo",
                data: {
                    "user":user,
                    "department":department
                },
                dataType: "json",
                success: function(data) {
                	
                	var editComputerInfo = data.editEquipmentsInfo; //获取后台json'
                	
                	/* var obj = document.getElementById("introduction");        
                    obj.innerText= moreSoftInfo.iNTRODUCTION; */
                    $("#editEquiomentId").val(editComputerInfo.eQUIPMENT_ID);
                	$("#user").val(editComputerInfo.uSER);
                	$("#department").val(editComputerInfo.dEPARTMENT);
                	$("#band").val(editComputerInfo.bRAND);
                	$("#hello").val(editComputerInfo.cONFIGURE_TIME);
                	$("#CPU").val(editComputerInfo.cPU);
                	$("#RAM").val(editComputerInfo.rAM);
                	$("#ROM").val(editComputerInfo.rOM);
                    
                	$("#os").val(editComputerInfo.oS);
                	$("#browser").val(editComputerInfo.bROWSER);
                	$("#office_software").val(editComputerInfo.oFFICE_SOFTWARE);
                	$("#used_for").val(editComputerInfo.uSED_FOR);
                	$("#IP").val(editComputerInfo.iP_ADDRESS);
                	$("#MAC").val(editComputerInfo.mAC_ADDRESS);
                	$("#region").val(editComputerInfo.rEGION);
                }           
            })
    	}  
     }
    
    
    /* 提交计算机更改  */ 
    function updateComputer() { 
    	var kw = /^\S{2,4}$/  
        	var dp = /^\S{2,20}$/
        	var ipadd = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/
        	var macadd = /^[A-F0-9]{2}(-[A-F0-9]{2}){5}$/
        if(kw.test($("#user").val())&&dp.test($("#department").val())&&dp.test($("#region").val())&&ipadd.test($("#IP").val())&&macadd.test($("#MAC").val())){
    	//获取模态框数据  
    	var equipmentId = $('#editEquiomentId').val(); 
        var user = $('#user').val();  
        var department = $('#department').val();
        var band = $('#band').val();
        var cfg_time = $('#hello').val();
        var CPU = $('#CPU').val();
        var RAM = $('#RAM').val();
        var ROM = $('#ROM').val();
        var os = $('#os').val();
        var browser = $('#browser').val();
        var office_software = $('#office_software').val();
        var used_for = $('#used_for').val();
        var IP = $('#IP').val();
        var MAC = $('#MAC').val();
        var region = $('#region').val();

        $.ajax({
            type: "POST",
            url: "updateEquipments",
            data: {
            	"equipmentId":equipmentId,
            	"user":user,
                "department":department,
                "band":band,
                "cfg_time":cfg_time,
                "CPU":CPU,
                "RAM":RAM,
                "ROM":ROM,
                "os":os,
                "browser":browser,
                "office_software":office_software,
                "used_for":used_for,
                "IP":IP,
                "MAC":MAC,
                "region":region
            },
            dataType: "json",
            success: function(data) {
            	
            	alert("更改成功");
            	window.location.reload();
            }
           
        }) 	        
    }else{
    	 
    	if(!kw.test($("#user").val())){
			$(".spa1").text('请填写您的姓名')
		}
		if(dp.test($("#department").val())){
			$(".spa2").text('请填写您的部门')
		}
		if(!ipadd.test($("#IP").val())){
			$(".spa12").text('请您填写正确的IP地址')
		}
		if(!macadd.test($("#MAC").val())){
			$(".spa13").text('请您填写正确的MAC地址')
		} 
		if(!dp.test($("#region").val())){
			$(".spa14").text('请您填写所属区域')
		}
		
     }  
    }
 
    //删除   
    function deleteEquipment(id) {
    	var equipment_id = document.getElementById(id).id;

    	if(equipment_id!=null){
    		if (confirm("确认删除？")) {
    	 	$.ajax({
                type: "POST",
                url: "deleteEquipment",
                data: {
                    "equipment_id":equipment_id
                },
                dataType: "json",
                success: function(data) {
                	if(data == "1"){
			        	   alert("删除成功");
			               window.location.reload();
			           }else {
			        	   alert("删除失败");
				           window.location.reload();
			           }
                }           
            }) 
     }
    }
    }
   </script> 
   
   
  
	
   </div> 
  </div>  
 </body>
</html>