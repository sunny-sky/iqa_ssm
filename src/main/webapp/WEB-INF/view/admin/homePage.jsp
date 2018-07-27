<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!--360浏览器优先以webkit内核解析-->


<title>首页</title>

<link rel="shortcut icon" href="favicon.ico">
<link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">

<!-- echarts JS -->
<script src="media/js/echarts.js"></script>

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content">
		<input type="hidden" id="base" value="${basePath}" />
		<div class="row">
			<div class="col-sm-9">
				<div class="row">
					<div class="col-sm-3">
						<div class="row row-sm text-center">
							<div class="col-xs-6">
								<div class="panel padder-v item">
									<div class="h1 text-info font-thin h1">
										<a href="${basePath}/eventPage.html"> ${ eventUnresolvedCounts}
										</a>
									</div>
									<span class="text-muted text-xs">待处理事件</span>



									<div class="top text-right w-full">
										<i class="fa fa-caret-down text-warning m-r-sm"></i>
									</div>
								</div>
							</div>
							<div class="col-xs-6">
								<div class="panel padder-v item bg-info">
									<div class="h1 text-fff font-thin h1">
										<a href="${basePath}/problemPage.html">${problemUnresolvedCounts }</a>
									</div>
									<span class="text-muted text-xs">待处理问题</span>
									<div class="top text-right w-full">
										<i class="fa fa-caret-down text-warning m-r-sm"></i>
									</div>
								</div>
							</div>
							<div class="col-xs-6">
								<div class="panel padder-v item bg-primary">
									<div class="h1 text-fff font-thin h1">
										<a href="${basePath}/faqPage.html">${pendCounts}</a>
									</div>
									<span class="text-muted text-xs">待审核FAQ</span>
									<div class="top text-right w-full">
										<i class="fa fa-caret-down text-warning m-r-sm"></i>
									</div>
								</div>
							</div>
							<div class="col-xs-6">
								<div class="panel padder-v item">
									<div class="font-thin h1">
										<a href="${basePath}/userPage.html">${pendingAuditCounts }</a>
									</div>
									<span class="text-muted text-xs">待审核用户</span>
									<div class="top text-right w-full">
										<i class="fa fa-caret-down text-warning m-r-sm"></i>

									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-9">
						<div class="ibox float-e-margins">
							<div class="ibox-title">
								<h5>近一周待处理事件/问题数呈现</h5>
								<div class="ibox-tools">
									<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
									</a> <a class="dropdown-toggle" data-toggle="dropdown"
										href="graph_flot.html#"> <i class="fa fa-wrench"></i>
									</a>
									<ul class="dropdown-menu dropdown-user">
										<li><a href="graph_flot.html#">选项1</a></li>
										<li><a href="graph_flot.html#">选项2</a></li>
									</ul>
									<a class="close-link"> <i class="fa fa-times"></i>
									</a>
								</div>
							</div>
							<div class="ibox-content">
								<div class="echarts" id="echarts-line-chart"></div>
							</div>
						</div>

					</div>
				</div>
				<div class="row">
					<div class="col-sm-8" style="padding-right: 0;">
						<div class="ibox float-e-margins">
							<div class="ibox-title">
								<h5>设备分配情况</h5>
								<div class="ibox-tools">
									<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
									</a> <a class="dropdown-toggle" data-toggle="dropdown"
										href="graph_flot.html#"> <i class="fa fa-wrench"></i>
									</a>
									<ul class="dropdown-menu dropdown-user">
										<li><a href="graph_flot.html#">选项1</a></li>
										<li><a href="graph_flot.html#">选项2</a></li>
									</ul>
									<a class="close-link"> <i class="fa fa-times"></i>
									</a>
								</div>
							</div>
							<div class="ibox-content" style="border-top: none;">
								<div id="equipments" style="height: 400px;"></div>
							</div>
						</div>
					</div>


					<div class="col-sm-4" style="padding-left: 0;">
						<div class="ibox float-e-margins">
							<div class="ibox-title">
								<h5></h5>
								<div class="ibox-tools">
									<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
									</a> <a class="dropdown-toggle" data-toggle="dropdown"
										href="graph_flot.html#"> <i class="fa fa-wrench"></i>
									</a>
									<ul class="dropdown-menu dropdown-user">
										<li><a href="graph_flot.html#">选项1</a></li>
										<li><a href="graph_flot.html#">选项2</a></li>
									</ul>
									<a class="close-link"> <i class="fa fa-times"></i>
									</a>
								</div>
							</div>
							<div class="ibox-content"
								style="border-top: none; background-color: #e4eaec;">
								<div class="echarts" id="echarts-pie-chart"
									style="height: 400px;"></div>
							</div>
						</div>
					</div>
				</div>

			</div>
			<div class="col-sm-3">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>任务列表</h5>
					</div>
					<div class="ibox-content">
						<ul class="todo-list m-t small-list ui-sortable">
							<c:forEach items="${lists}" var="list">
								<li><a
									href="showUnResolvedEvent.html?q=${list.userQuestionId}"
									class="check-link"><i class="fa fa-square-o"></i> </a> <span>${list.how}</span>
									<small class="label label-primary"><i
										class="fa fa-clock-o"></i> ${list.time}</small></li>

							</c:forEach>
							<%-- <#assign n = lists?size />
						<#if n gt 20>
						<#assign n =20 />
						</#if>
						<#if n!=0>
						<#list 0..(n-1) as i>
						<#assign ls = lists[i] />
                        <#if ls.how=="待处理事件">
                        <li>
                            <a href="${basePath}/showUnResolvedEvent.html?q=${ls.userQuestionId}" class="check-link"><i class="fa fa-square-o"></i> </a>
                            <span >${ls.how}</span>
                            <small class="label label-primary"><i class="fa fa-clock-o"></i> ${ls.time}</small>
                        </li>
                        
                        <#elseif ls.how=="待处理问题">
                        <li>
                            <a href="${basePath}/showUnResolvedProblem.html?p=${ls.communityQuestionId}" class="check-link"><i class="fa fa-square-o"></i> </a>
                            <span >${ls.how}</span>
                            <small class="label label-primary"><i class="fa fa-clock-o"></i> ${ls.time}</small>
                        </li>
                        
                        <#elseif ls.how=="待审核用户">
                        <li>
                            <a href="${basePath}/userPage.html" class="check-link"><i class="fa fa-square-o"></i> </a>
                            <span >${ls.how}</span>
                            <small class="label label-primary"><i class="fa fa-clock-o"></i> ${ls.time}</small>
                        </li>
                        
                        <#elseif ls.how=="待审核FAQ">
                        <li>
                            <a href="${basePath}/faqPage.html" class="check-link"><i class="fa fa-square-o"></i> </a>
                            <span >${ls.how}</span>
                            <small class="label label-primary"><i class="fa fa-clock-o"></i> ${ls.time}</small>
                        </li>
                        
                         </#if>
                        </#list>
                        </#if> --%>


						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 全局js -->
	<script src="js/jquery.min.js?v=2.1.4"></script>
	<script src="js/bootstrap.min.js?v=3.3.6"></script>
	<script src="js/plugins/layer/layer.min.js"></script>
	<!-- Flot -->
	<script src="js/plugins/flot/jquery.flot.js"></script>
	<script src="js/plugins/flot/jquery.flot.tooltip.min.js"></script>
	<script src="js/plugins/flot/jquery.flot.resize.js"></script>
	<script src="js/plugins/flot/jquery.flot.pie.js"></script>
	<!-- 自定义js -->
	<script src="js/content.js"></script>
	<script type="text/javascript">

</script>

	<script type="text/javascript">

//近一周待处理事件/问题数呈现
$(document).ready(
function(){
	 var categories=[];  
	 var eventCount=[];
	 var problemCount=[]; 
	$.ajax({
	 type: "POST",
	 url: "eventAndProblem",            
	 dataType: "json",
	 success: function(data){
		 for(var i in data.time){			
			 categories[i] = data.time[i].time;
			 eventCount[i] = data.time[i].eventCount;
			 problemCount[i] = data.time[i].problemCount;
		 }
		 var myChart = echarts.init(document.getElementById("echarts-line-chart"));
		 option = {
		 	    title: {
		 	       // text: '近一周待处理事件/问题数',
		 	        //subtext: '纯属虚构'
		 	    },
		 	    tooltip: {
		 	        trigger: 'axis'
		 	    },
		 	    legend: {
		 	        data:['待处理事件数','待处理问题数']
		 	    },
		 	    toolbox: {
		 	        show: true,
		 	        feature: {
		 	            dataZoom: {
		 	                yAxisIndex: 'none'
		 	            },
		 	            dataView: {readOnly: false},
		 	            magicType: {type: ['line', 'bar']},
		 	            restore: {},
		 	            saveAsImage: {}
		 	        }
		 	    },
		 	    xAxis:  {
		 	        type: 'category',
		 	        boundaryGap: false,
		 	        data: categories
		 	    },
		 	    yAxis: {
		 	        type: 'value',
		 	        axisLabel: {
		 	            formatter: '{value}'
		 	        }
		 	    },
		 	    series: [
		 	        {
		 	            name:'待处理事件数',
		 	            type:'line',
		 	            data: eventCount,
		 	            markPoint: {
		 	                data: [
		 	                    {type: 'max', name: '最大值'},
		 	                    {type: 'min', name: '最小值'}
		 	                ]
		 	            },
		 	            markLine: {
		 	                data: [
		 	                    {type: 'average', name: '平均值'}
		 	                ]
		 	            }
		 	        },
		 	        {
		 	            name:'待处理问题数',
		 	            type:'line',
		 	            data: problemCount,
		 	            markPoint: {
		 	                data: [
		 	                    {name: '周最低', value: -2, xAxis: 1, yAxis: -1.5}
		 	                ]
		 	            },
		 	            markLine: {
		 	                data: [
		 	                    {type: 'average', name: '平均值'},
		 	                    [{
		 	                        symbol: 'none',
		 	                        x: '90%',
		 	                        yAxis: 'max'
		 	                    }, {
		 	                        symbol: 'circle',
		 	                        label: {
		 	                            normal: {
		 	                                position: 'start',
		 	                                formatter: '最大值'
		 	                            }
		 	                        },
		 	                        type: 'max',
		 	                        name: '最高点'
		 	                    }]
		 	                ]
		 	            }
		 	        }
		 	    ]
		 	};

		 myChart.setOption(option);
	      }
	 });
})

</script>
	<script type="text/javascript">

$(document).ready(
	function(){
		 var names = [];    //类别数组（用于存放饼图的类别）
		 var brower = [];
		$.ajax({
		 type: "POST",
		 url: "classifyCount",            
		 dataType: "json",
		 success: function(data){
			//请求成功时执行该函数内容，result即为服务器返回的json对象
            $.each(data.classifyList, function (index, item) {
               // names.push(item.classifyName);    //挨个取出类别并填入类别数组 
                brower.push({
                    name: item.classifyName,
                    value: item.classifyCount
                });
            });
			 
			 var myChart = echarts.init(document.getElementById("echarts-pie-chart"));

			 option1 = {
			 	    title : {
			 	        text: 'FAQ分类情况',
			 	        //subtext: '纯属虚构',
			 	        x:'center'
			 	    },
			 	    tooltip : {
			 	        trigger: 'item',
			 	        formatter: "{a} <br/>{b} : {c} ({d}%)"
			 	    },
			 	    legend: {
			 	        orient: 'vertical',
			 	        left: 'left',
			 	        //data: names
			 	    },
			 	    series : [
			 	        {
			 	            name: '分类名',
			 	            type: 'pie',
			 	            radius : '55%',
			 	            center: ['50%', '60%'],
			 	            data:
			 	                
										brower
			 	            ,
			 	            itemStyle: {
			 	                emphasis: {
			 	                    shadowBlur: 10,
			 	                    shadowOffsetX: 0,
			 	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
			 	                }
			 	            }
			 	        }
			 	    ]
			 	};

			 myChart.setOption(option1);
		      }
		 });
	})

	var myChart2 = echarts.init(document.getElementById("echarts-pie-chart"));
		 myChart2.on('click', function (){  
			 window.location.href=base+"/faqPage.html";                       
         }); 
</script>

	<script>

$(document).ready(
		function(){
			 var categories = [];    //用于存放地区名（用于存放饼图的类别）
			 var eventCount = [];	//存放各地区设备数量
			 $.ajax({
			 type: "POST",
			 url: "regionCount",            
			 dataType: "json",
			 success: function(data){
				//请求成功时执行该函数内容，result即为服务器返回的json对象
				console.log(data)
				 for(var i in data.regionList){			
					 categories[i] = data.regionList[i].regions;
					 eventCount[i] = data.regionList[i].equipmentCounts;
					 
				 }
				 
				 var myChart = echarts.init(document.getElementById("equipments"));


				 option3 = {
				     color: ['#3398DB'],
				     tooltip : {
				         trigger: 'axis',
				         axisPointer : {            // 坐标轴指示器，坐标轴触发有效
				             type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
				         }
				     },
				     grid: {
				         left: '3%',
				         right: '4%',
				         bottom: '3%',
				         containLabel: true
				     },
				     xAxis : [
				         {
				             type : 'category',
				             data : categories,
				             axisTick: {
				                 alignWithLabel: true
				             }
				         }
				     ],
				     yAxis : [
				         {
				             type : 'value'
				         }
				     ],
				     series : [
				         {
				             name:'设备数量',
				             type:'bar',
				             barWidth: '60%',
				             data:eventCount
				         }
				     ]
				 };


				 myChart.setOption(option3);
			      }
			 });
		})
		var myChart1 = echarts.init(document.getElementById("equipments"));
		 myChart1.on('click', function (){  
			 window.location.href=base+"/configureEquipmentPage.html";                       
         });  
          
</script>




</body>

</html>