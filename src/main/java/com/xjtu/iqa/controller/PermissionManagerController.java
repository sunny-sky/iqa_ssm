package com.xjtu.iqa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.xjtu.iqa.mapper.PermissionMapper;
import com.xjtu.iqa.service.PermissionManagerService;
import com.xjtu.iqa.service.RoleServece;
import com.xjtu.iqa.util.JsonUtil;
import com.xjtu.iqa.vo.PermissionView;
import com.xjtu.iqa.vo.Permission_RoleView;

@Controller
public class PermissionManagerController {
	@Autowired
	PermissionManagerService permissionManagerService;
	@Autowired
	RoleServece roleService;
	@Autowired
	PermissionMapper permissionMapper;

	// 权限列表页面_permissionPage.ftl
	@RequestMapping(value = "permissionPage", method = RequestMethod.GET)
	public ModelAndView permissionPage() {
		ModelAndView mv = new ModelAndView("admin/permissionPage");

		// 获取所有权限
		List<PermissionView> permissionList = permissionManagerService.getPermissionList();

		mv.addObject("permissionList", permissionList);
		return mv;
	}

	/************************ 权限分配部分 ****************************/
	@RequestMapping(value = "permissionAssignPage", method = RequestMethod.GET)
	public ModelAndView permissionAssignPage() {
		ModelAndView mv = new ModelAndView("admin/permissionAssignPage");
		// 获取所有角色
		List<Permission_RoleView> roleList = roleService.getAllRoles();
		// 首次展示第一个角色未获取的权限信息
		List<Permission_RoleView> notObtainRolePermission = permissionManagerService
				.notObtainRolePermission(roleList.get(0).getROLEID());
		// 首次展示第一个角色已获取的权限信息
		List<Permission_RoleView> obtainRolePermission = permissionManagerService
				.obtainRolePermission(roleList.get(0).getROLEID());
		mv.addObject("roleList", roleList);
		mv.addObject("notObtainRolePermission", notObtainRolePermission);
		mv.addObject("obtainRolePermission", obtainRolePermission);
		return mv;
	}

	// 为角色选择权限
	@ResponseBody
	@RequestMapping(value = "selectRolePermission", method = {
			org.springframework.web.bind.annotation.RequestMethod.POST }, produces = "application/json;charset=UTF-8")
	public String selectRolePermission(HttpServletRequest request, HttpSession session) {
		String roleId = request.getParameter("roleId");
		// 获取用户还未得到的权限
		List<Permission_RoleView> notObtainRolePermission = permissionManagerService.notObtainRolePermission(roleId);
		// 获取用户已得到的权限
		List<Permission_RoleView> obtainRolePermission = permissionManagerService.obtainRolePermission(roleId);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("notObtainRolePermission", notObtainRolePermission);
		jsonObject.put("obtainPermission", obtainRolePermission);
		String result = JsonUtil.toJsonString(jsonObject);
		return result;
	}

	/**
	 * 将左边未获取权限插入右边已获取
	 */
	@ResponseBody
	@RequestMapping(value = "permissionChecked", method = {
			org.springframework.web.bind.annotation.RequestMethod.POST }, produces = "application/json;charset=UTF-8")
	public String permissionChecked(HttpServletRequest request) {
		System.out.println("进入permissionChecked");

		String roleId = request.getParameter("roleId");
		String permissionId = request.getParameter("checkedIds"); // 获取前台隐藏域存着的选中的复选框的value

		String checkedIds[] = permissionId.split(","); // 进行分割存到数组

		for (int i = 0; i < checkedIds.length; i++) {
			if (!checkedIds[i].equals("")) {
				// 将选中权限插入到角色-权限表中
				permissionManagerService.addPermissionToRole(roleId, checkedIds[i]);
			}
		}

		// 获取用户还未得到的权限
		List<Permission_RoleView> notObtainRolePermission = permissionManagerService.notObtainRolePermission(roleId);

		// 获取用户已得到的权限
		List<Permission_RoleView> obtainRolePermission = permissionManagerService.obtainRolePermission(roleId);

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("notObtainRolePermission", notObtainRolePermission);
		jsonObject.put("obtainPermission", obtainRolePermission);

		return JsonUtil.toJsonString(jsonObject);
	}

	// 增加权限
	@ResponseBody
	@RequestMapping(value = "addPermission", method = RequestMethod.POST)
	public String addPermission(HttpServletRequest request, HttpSession session) {
		String username = (String) session.getAttribute("username");
		JSONObject jsonObject = new JSONObject();
		if (username == null) {
			jsonObject.put("value", "0");
			String result = JsonUtil.toJsonString(jsonObject);
			return result;
		} else {
			String logicName = request.getParameter("logicName");
			String physicalName = request.getParameter("physicalName");
			// 根据物理名查看权限是否已存在
			String permissionId = permissionMapper.getPermissionIdByPhysicalName(physicalName);
			// 根据逻辑名查看权限是否已存在
			String permissionId2 = permissionMapper.getPermissionIdByLogicName(logicName);

			if (permissionId != null) {
				jsonObject.put("value", "1");
				String result = JsonUtil.toJsonString(jsonObject);
				return result;
			} else if (permissionId2 != null) {
				jsonObject.put("value", "2");
				String result = JsonUtil.toJsonString(jsonObject);
				return result;
			} else {
				// 新增权限
				permissionManagerService.addPermission(logicName, physicalName);

				jsonObject.put("value", "3");
				String result = JsonUtil.toJsonString(jsonObject);
				return result;
			}
		}
	}

	// 更改权限信息
	@ResponseBody
	@RequestMapping(value = "/updatePermission", method = RequestMethod.POST)
	public String updatePermission(HttpServletRequest request, HttpSession session) {
		String username = (String) session.getAttribute("username");
		JSONObject jsonObject = new JSONObject();
		if (username == null) {
			jsonObject.put("value", "0");
			String result = JsonUtil.toJsonString(jsonObject);
			return result;
		} else {
			// 获取ajax传值
			String permissionId = request.getParameter("permissionId");
			String logicName = request.getParameter("logicName");
			String physicalName = request.getParameter("physicalName");

			// 根据物理名查看权限是否已存在
			String permissionId2 = permissionMapper.getPermissionIdByPhysicalName2(physicalName, permissionId);
			System.out.println("物理名：" + permissionId2);
			// 根据逻辑名查看权限是否已存在
			String permissionId3 = permissionMapper.getPermissionIdByLogicName2(logicName, permissionId);
			System.out.println("逻辑名：" + permissionId3);
			if (permissionId2 != null) {
				jsonObject.put("value", "1");
				String result = JsonUtil.toJsonString(jsonObject);
				return result;
			} else if (permissionId3 != null) {
				jsonObject.put("value", "2");
				String result = JsonUtil.toJsonString(jsonObject);
				return result;
			} else {
				// 更改权限信息
				permissionManagerService.updatePermission(permissionId, physicalName, logicName);

				jsonObject.put("value", "3");
				String result = JsonUtil.toJsonString(jsonObject);
				return result;
			}

		}
	}

	// 删除权限信息
	@ResponseBody
	@RequestMapping(value = "/deletePermission", method = RequestMethod.POST)
	public String deletePermission(HttpServletRequest request, HttpSession session) {
		String username = (String) session.getAttribute("username");
		JSONObject jsonObject = new JSONObject();
		if (username == null) {
			jsonObject.put("value", "0");
			String result = JsonUtil.toJsonString(jsonObject);
			return result;
		} else {
			// 获取ajax传值
			String permissionId = request.getParameter("permissionId");

			// 删除权限信息
			permissionManagerService.deletePermission(permissionId);
			jsonObject.put("value", "1");
			String result = JsonUtil.toJsonString(jsonObject);
			return result;
		}
	}

	/**
	 * 将角色已获取权限移除
	 */
	@ResponseBody
	@RequestMapping(value = "/permissionUnChecked", method = {
			org.springframework.web.bind.annotation.RequestMethod.POST }, produces = "application/json;charset=UTF-8")
	public String permissionUnChecked(HttpServletRequest request) {
		System.out.println("进入permissionUnChecked");

		String roleId = request.getParameter("roleId");
		String permissionId = request.getParameter("checkedIds"); // 获取前台隐藏域存着的选中的复选框的value

		String checkedIds[] = permissionId.split(","); // 进行分割存到数组

		for (int i = 0; i < checkedIds.length; i++) {
			if (!checkedIds[i].equals("")) {
				// 将选中权限从角色-权限表中移除
				permissionManagerService.deletePermissionToRole(roleId, checkedIds[i]);
			}
		}

		// 获取用户还未得到的权限
		List<Permission_RoleView> notObtainRolePermission = permissionManagerService.notObtainRolePermission(roleId);

		// 获取用户已得到的权限
		List<Permission_RoleView> obtainRolePermission = permissionManagerService.obtainRolePermission(roleId);

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("notObtainRolePermission", notObtainRolePermission);
		jsonObject.put("obtainPermission", obtainRolePermission);

		return JsonUtil.toJsonString(jsonObject);
	}
}
