<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
 <head> 
  <meta charset="utf-8" /> 
  <meta name="viewport" content="width=device-width, initial-scale=1.0" /> 
  <title>问题管理</title> 
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
              <!-- !!! 修改 -->
            <!--  <li class="on"><a data-toggle="tab"  aria-expanded="true" onclick="getUnResolvedProblem()">待处理问题【${unResolvedCounts}】</a></li> 
             <li class=""><a data-toggle="tab"  aria-expanded="false" onclick="getResolvedProblem()">已处理问题【${resolvedCounts }】</a></li>  -->
             
             <li class="active"><a data-toggle="tab" href="#tab-31" aria-expanded="true">待处理问题【${unResolvedCounts}】</a></li> 
             <li class=""><a data-toggle="tab" href="#tab-32" aria-expanded="false">已处理问题【${resolvedCounts }】</a></li> 
            </ul> 
            <div class="tab-content"> 
             
             <!-- 待处理问题列表信息 --> 
             <div id="tab-31" class="tab-pane active"> 
              <div class="ibox-title"> 
               <div class="ibox-tools"> 
               </div> 
              </div> 
              <div class="ibox-content"> 	          	       
		       <table class="table table-striped table-bordered table-hover dataTables-example" id = "option1"> 
		        <thead>
					<tr>
						<th style="text-align: center;">序号</th>
						<th style="text-align: center;">问题标题</th>
						<th style="text-align: center;">内容</th>
						<th style="text-align: center;">问题分类</th>
						<th style="text-align: center;">提问用户</th>
						<th style="text-align: center;">提问时间</th>
						<th style="text-align: center;">查看</th>
						<th style="text-align: center;">忽略</th>																			
					</tr>
				</thead>
                
                <tbody>
                	<c:forEach items="${problemUnresolved }" var="a" varStatus="status"> 
					<!-- <#list problemUnresolved as a> -->
					<tr class="" id = "${a.problemId}">
						<td style="width: 6%;">${status.index+1}</td>
						<td style="width: 27%;">${a.problemTitle}</td>
						<td style="width: 27%;">
	
						<c:choose> 
							<c:when test="${fn:length(a.problemContent)}>100">  
							${fn:substring(a.problemContent, 0, 100)}...<span class="readMore">
								<a class="questioninfo" href="showUnResolvedProblem?p=${a.problemId}">查看更多</a></span>
							</c:when>

							<c:otherwise> 
							${a.problemContent}

							</c:otherwise>
						</c:choose>
						</td>
						<td style="width: 10%;" class="center">${a.problemClassifyName}</td>
						<td style="width: 10%;" class="center">${a.problemUserName}</td>														
						<td style="width: 10%;">${a.problemTime}</td>
						<td  style="width: 5%;text-align: center;">
							<a class="questioninfo" href="showUnResolvedProblem?p=${a.problemId}">查看详情</a>
						</td>
						<td  style="width: 5%;text-align: center;" >																				
							<button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="忽略此问题" id = "${a.problemId }" onclick="ignore(this.id)"><i class="fa fa-trash-o"></i></button>
						</td>					
					</tr>
					<!-- </#list> -->
					</c:forEach>
				</tbody>
		       </table>  
              </div> 
             </div> 
             
               <!-- 已处理问题列表信息 --> 
             <div id="tab-32" class="tab-pane"> 
              <div class="ibox-title"> 
               <div class="ibox-tools"> 
               </div> 
              </div> 
              <div class="ibox-content"> 	          	       
		       <table class="table table-striped table-bordered table-hover dataTables-example" id = "option2"> 
		        <thead>
					<tr>
						<th style="text-align: center;">序号</th>
						<th style="text-align: center;">问题标题</th>
						<th style="text-align: center;">内容</th>
						<th style="text-align: center;">问题分类</th>
						<th style="text-align: center;">提问用户</th>
						<th style="text-align: center;">提问时间</th>
						<th style="text-align: center;">回复者</th>
						<th style="text-align: center;">回复内容</th>	
						<th style="text-align: center;">查看详情</th>	
						<th style="text-align: center;">操作</th>																		
					</tr>
				</thead>
                
                <tbody>
                	<c:forEach items="${problemResolved }" var="a" varStatus="status">
					<!-- <#list problemResolved as a> -->
					<tr class="" id = "${a.problemId}">
						<td style="width: 5%;">${status.index+1}</td>
						<td style="width: 17%;">${a.problemTitle}</td>
						<td style="width: 18%;">
						
						<c:choose> 
							<c:when test="${fn:length(a.problemContent)}>100"> 
							${fn:substring(a.problemContent, 0, 100)}...<span class="readMore">
								<a class="questioninfo" href="showResolvedProblem?p=${a.problemId}">查看更多</a></span>
							</c:when>
							<c:otherwise> 
							${a.problemContent}
							</c:otherwise>
						</c:choose>
						</td>
						<td style="width: 7%;" class="center">${a.problemClassifyName}</td>
						<td style="width: 7%;" class="center">${a.problemUserName}</td>														
						<td style="width: 7%;">${a.problemTime}</td>
						<td style="width: 7%;">${a.answerUserName}</td>
						<td style="width: 18%;">
						<!-- <#if a.answerContent?length gt 100> -->
						<c:choose>
							<c:when test="${fn:length(a.answerContent)}>100"> 
							${fn:substring(a.answerContent, 0, 100)}...<span class="readMore">
								<a class="questioninfo" href="showResolvedProblem?p=${a.problemId}">查看更多</a></span>
							</c:when>
							<c:otherwise> 
								${a.answerContent}
							</c:otherwise>
						</c:choose>
						</td>
						<td style="width: 7%;text-align: center;">
							<a class="questioninfo" href="showResolvedProblem?p=${a.problemId}">查看详情</a>
						</td>
						<td  style="width: 7%;text-align: center;" >																				
							<button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="忽略此问题" id = "${a.problemId }" onclick="ignore(this.id)"><i class="fa fa-trash-o"></i></button>
						</td>					
					</tr>
					</c:forEach>
				</tbody>
		       </table>  
              </div> 
             </div> 
             
             
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
    <!-- Page-Level Scripts --> 
    
    <script src="js/view/problemPage.js"></script>
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
    </script> 
    <div class="success" id="success" style="z-index:1001;position:fixed;top:40%;left:45%;width:220px;background: #f3f3f3;text-align: center;border:1px solid black;border-radius:3px;display:none"><div style="margin-top:30px; margin-bottom:30px;"><img src="images/true.png" style="width:20px;height:20px;margin-right:10px;"><h2 style="font-size:16px;display:inline-block;line-height:22px;vertical-align:top">忽略成功</h2></div></div>
	
   </div> 
  </div>  
 </body>
</html>