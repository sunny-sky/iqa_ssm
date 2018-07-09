<%@ page pageEncoding="UTF-8" %>
<html>
 <head>
 	
 </head>
 <body>
	<nav class="navbar-default navbar-static-side" role="navigation">
		<div class="nav-close">
			<i class="fa fa-times-circle"></i>
		</div>
		<div class="sidebar-collapse">
			<ul class="nav" id="side-menu">
				<li class="nav-header">
					<div class="dropdown profile-element">
						<a data-toggle="dropdown" class="dropdown-toggle" href="#"> <span
							class="clear"> <span class="block m-t-xs"
								style="font-size: 16px;"> <i class="fa fa-area-chart"></i>
									<strong class="font-bold">烟草公司IT管理系统</strong>
							</span>
						</span>
						</a>
					</div>
					<div class="logo-element"></div>
				</li>
				<li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
					<span class="ng-scope"></span>
				</li>
				<li class="loginLinkLi" id="userNameText">您好：${username}</li>
				<li><a class="J_menuItem" href="homePage"> <i
						class="fa fa-home"></i> <span class="nav-label">首页</span>
				</a></li>

				<li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
					<span class="ng-scope"></span>
				</li>
				<li><a href=""> <i class="fa fa-paste"></i> <span
						class="nav-label">ITIL管理流程</span> <span class="fa arrow"></span>
				</a>
					<ul class="nav nav-second-level">
						<li><a class="J_menuItem" href="eventPage"> <i
								class="fa fa-paste"></i> <span class="nav-label">事件管理</span>
						</a></li>
						<li><a class="J_menuItem" href="problemPage"> <i
								class="fa fa-warning"></i> <span class="nav-label">问题管理</span>
						</a></li>
						<li><a href=""> <i class="fa fa-edit"></i>&nbsp;设备管理<span
								class="fa arrow"></span>
						</a>
							<ul class="nav nav-third-level">
								<li><a class="J_menuItem" href="configureEquipmentPage">设备信息库</a></li>
								<li><a class="J_menuItem" href="configureUploadPage">新增设备信息</a></li>
							</ul></li>
						<li><a href=""> <i class="fa fa-edit"></i>&nbsp;知识管理<span
								class="fa arrow"></span>
						</a>
							<ul class="nav nav-third-level">
								<li><a class="J_menuItem" href="faqPage.html">知识库</a></li>
								<li><a class="J_menuItem" href="faqCommendPage.html">faq推荐栏</a></li>
							</ul></li>
					</ul></li>

				<li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
					<span class="ng-scope"></span>
				</li>

				<li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
					<span class="ng-scope"></span>
				</li>
				<li><a class="J_menuItem" href="logindex.html"> <i
						class="fa fa-user-md"></i> <span class="nav-label">日志管理</span>
				</a></li>
				<li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
					<span class="ng-scope"></span>
				</li>
				<li><a href=""> <i class="fa fa-rebel"></i> <span
						class="nav-label">用户管理</span> <span class="fa arrow"></span>
				</a>
					<ul class="nav nav-second-level">
						<li><a class="J_menuItem" href="userPage.html"> <i
								class="fa fa-table"></i> <span class="nav-label">用户管理</span>
						</a></li>
					</ul>
					<ul class="nav nav-second-level">
						<li><a class="J_menuItem" href="changePasswordPage.html">
								<i class="fa fa-table"></i> <span class="nav-label">admin密码修改</span>
						</a></li>
					</ul></li>
				<!--  <li>
             <a class="J_menuItem" href="userPage.html">
                 <i class="fa fa-user-plus"></i>
                 <span class="nav-label">用户管理</span>
             </a>
         </li> -->
				<li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
					<span class="ng-scope"></span>
				</li>
				<!-- 
         <li>
             <a class="J_menuItem" href="">
                 
                 <span class="nav-label">权限管理</span>
             </a>
         </li> -->
				<li><a href=""> <i class="fa fa-rebel"></i> <span
						class="nav-label">权限管理</span> <span class="fa arrow"></span>
				</a>
					<ul class="nav nav-second-level">
						<li><a class="J_menuItem" href="permissionPage.html"> <i
								class="fa fa-table"></i> <span class="nav-label">权限列表</span>
						</a></li>
						<li><a class="J_menuItem" href="permissionAssignPage.html">
								<i class="fa fa-warning"></i> <span class="nav-label">权限分配</span>
						</a></li>
					</ul></li>
				<li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
					<span class="ng-scope"></span>
				</li>
				<li><a class="J_menuItem" href="" onclick="logout()"> <i
						class="fa fa-warning"></i> <span class="nav-label">退出</span>
				</a></li>
			</ul>
		</div>
	</nav>
</body>
</html>