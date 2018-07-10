package com.xjtu.iqa.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.xjtu.iqa.mapper.RoleMapper;
import com.xjtu.iqa.mapper.UserMapper;
import com.xjtu.iqa.po.Role;
import com.xjtu.iqa.po.User;
import com.xjtu.iqa.service.UserService;
import com.xjtu.iqa.util.JsonUtil;
import com.xjtu.iqa.util.MD5;
import com.xjtu.iqa.vo.UserView;

@Controller
public class UserController {
	@Autowired
	UserMapper userMapper;
	@Autowired
	UserService userService;
	@Autowired
	RoleMapper roleMapper;

	// login admin
	@ResponseBody
	@RequestMapping(value = "adminLogin", method = RequestMethod.POST)
	public String adminLogin(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("nameOrEmail");
		String psw = request.getParameter("userPassword");
		String password = StringToMd5(psw);
		Boolean isExist = userMapper.isLogin(username, password);
		JSONObject jsonObject = new JSONObject();
		if (isExist == false) {
			jsonObject.put("value", "0");
			String result = JsonUtil.toJsonString(jsonObject);
			return result;
			// return "redirect:login.html";
		} else {
			// zzl_查找登录用户信息
			List<User> list = userMapper.getUserInfo(username);

			session.setAttribute("nameOrEmail", username);
			session.setAttribute("username", list.get(0).getUSERNAME());
			session.setAttribute("testSession", "测试session添加");
			request.getSession().setAttribute("username", username);

			jsonObject.put("value", "1");
			String result = JsonUtil.toJsonString(jsonObject);
			return result;
			// return "redirect:index.html" ;
		}
	}

	// psw转md5
	public static String StringToMd5(String psw) {
		{
			try {
				MessageDigest md5 = MessageDigest.getInstance("MD5");
				md5.update(psw.getBytes("UTF-8"));
				byte[] encryption = md5.digest();

				StringBuffer strBuf = new StringBuffer();
				for (int i = 0; i < encryption.length; i++) {
					if (Integer.toHexString(0xff & encryption[i]).length() == 1) {
						strBuf.append("0").append(Integer.toHexString(0xff & encryption[i]));
					} else {
						strBuf.append(Integer.toHexString(0xff & encryption[i]));
					}
				}

				return strBuf.toString();
			} catch (NoSuchAlgorithmException e) {
				return "";
			} catch (UnsupportedEncodingException e) {
				return "";
			}
		}
	}

	/**
	 * @abstract:用户管理_userPage.ftl
	 */
	@RequestMapping(value = "userPage", method = RequestMethod.GET)
	public ModelAndView userPage() {
		ModelAndView mv = new ModelAndView("admin/userPage");

		// !!! 分页
		// userstate:0--无效用户；1--待审核用户；2--正常用户

		// 获取所有待审核员工信息 (userstate,startnum,count)
		List<UserView> pendingAuditUsers = userService.getAllPendingAuditUsers(1);
		// 获取各类员工数量
		int pendingAuditCounts = userMapper.getPendingUserCount(1);

		// 获取所有普通用户信息 (userstate,rolename,startnum,count)
		List<UserView> ordinaryUsers = userService.getAllUsers(2, "普通用户");
		// 获取各类员工数量
		int ordinaryUserCounts = userMapper.getUserCount(2, "普通用户");

		// 获取所有运维人员信息
		List<UserView> ITUsers = userService.getAllUsers(2, "运维人员");
		int ITUserCounts = userMapper.getUserCount(2, "运维人员");

		// 获取所有管理员信息
		List<UserView> adminUsers = userService.getAllUsers(2, "管理员");
		int adminUserCounts = userMapper.getUserCount(2, "管理员");

		// 获取所有无效用户信息
		List<UserView> inValidtUsers = userService.getAllPendingAuditUsers(0);
		int inValidtUserCounts = userMapper.getPendingUserCount(0);

		mv.addObject("pendingAuditUsers", pendingAuditUsers);
		mv.addObject("pendingAuditCounts", pendingAuditCounts);

		mv.addObject("ordinaryUsers", ordinaryUsers);
		mv.addObject("ordinaryUserCounts", ordinaryUserCounts);

		mv.addObject("ITUsers", ITUsers);
		mv.addObject("ITUserCounts", ITUserCounts);

		mv.addObject("adminUsers", adminUsers);
		mv.addObject("adminUserCounts", adminUserCounts);

		mv.addObject("inValidtUsers", inValidtUsers);
		mv.addObject("inValidtUserCounts", inValidtUserCounts);
		return mv;

	}

	/**
	 * 用户通过审核
	 */
	@ResponseBody
	@RequestMapping(value = "throughAudit", method = RequestMethod.POST)
	public String throughAudit(HttpServletRequest request, HttpSession session) {

		String userId = request.getParameter("userId");

		// 更新user表用户状态 -- "2"为管理员审核通过状态
		userService.updateUserState(userId, 2);

		return "1";
	}

	/**
	 * 用户未通过审核
	 */
	@ResponseBody
	@RequestMapping(value = "noAudit", method = RequestMethod.POST)
	public String noAudit(HttpServletRequest request, HttpSession session) {

		String userId = request.getParameter("userId");

		// 更新user表用户状态 -- "2"为管理员审核通过状态
		userService.updateUserState(userId, 0);

		return "1";
	}

	/**
	 * 查看用户详情
	 */
	@RequestMapping(value = "showUserInfo", method = RequestMethod.GET)
	public ModelAndView showUserInfo(String u) {
		ModelAndView mv = new ModelAndView("admin/showUserInfo");

		// 获取指定用户信息
		UserView userInfo = userService.getUserInfoById(u);

		mv.addObject("userInfo", userInfo);
		return mv;
	}

	/**
	 * 批量审核用户通过
	 */
	@ResponseBody
	@RequestMapping(value = "selectUserPass", method = RequestMethod.GET)
	public String selectUserPass(HttpServletRequest request) {
		System.out.println("进入批量审核");

		String id = request.getParameter("checkedIds"); // 获取前台隐藏域存着的选中的复选框的value
		String checkedIds[] = id.split(","); // 进行分割存到数组

		for (int i = 0; i < checkedIds.length; i++) {
			if (!checkedIds[i].equals("")) {
				// System.out.println(checkedIds[i]);
				userService.updateUserState(checkedIds[i], 2);
			}
		}
		return "1";
	}

	/**
	 * 批量审核用户不通过
	 */
	@ResponseBody
	@RequestMapping(value = "selectUserUnPass", method = RequestMethod.GET)
	public String selectUserUnPass(HttpServletRequest request) {
		System.out.println("进入批量审核");

		String id = request.getParameter("checkedIds"); // 获取前台隐藏域存着的选中的复选框的value
		String checkedIds[] = id.split(","); // 进行分割存到数组

		for (int i = 0; i < checkedIds.length; i++) {
			if (!checkedIds[i].equals("")) {
				// System.out.println(checkedIds[i]);
				userService.updateUserState(checkedIds[i], 0);
			}
		}
		return "1";
	}

	// 更换员工角色
	@ResponseBody
	@RequestMapping(value = "changeRole", method = {
			org.springframework.web.bind.annotation.RequestMethod.POST }, produces = "application/json;charset=UTF-8")
	public String changeRole(HttpServletRequest request, HttpSession session) {
		// 获取ajax传来数据
		String userId = request.getParameter("userId");

		// 获取该员工本身角色外的其他角色
		List<Role> list = roleMapper.getUnGotRoleList(userId);

		System.out.println("长度" + list.size());

		JSONObject jsonObject = new JSONObject();

		if (list.size() != 0) {
			jsonObject.put("value", "1");
			jsonObject.put("list", list);
			jsonObject.put("userId", userId);
			String result = JsonUtil.toJsonString(jsonObject);
			return result;
		} else {
			jsonObject.put("value", "2");
			jsonObject.put("userId", userId);
			String result = JsonUtil.toJsonString(jsonObject);
			return result;
		}
	}

	// 更新员工角色
	@ResponseBody
	@RequestMapping(value = "updateUserRole", method = {
			org.springframework.web.bind.annotation.RequestMethod.POST }, produces = "application/json;charset=UTF-8")
	public String updateUserRole(HttpServletRequest request, HttpSession session) {
		// 获取ajax传来数据
		String userId = request.getParameter("userId");
		String roleId = request.getParameter("roleId");

		JSONObject jsonObject = new JSONObject();

		if (userId != null && roleId != null) {
			// 更新员工角色
			userMapper.updateUserRole(userId, roleId);
			jsonObject.put("value", "1");
			String result = JsonUtil.toJsonString(jsonObject);
			return result;
		} else {
			jsonObject.put("value", "0");
			String result = JsonUtil.toJsonString(jsonObject);
			return result;
		}

	}

	// 密码重置
	@ResponseBody
	@RequestMapping(value = "resetPass", method = RequestMethod.POST)
	public String deleteFAQ(HttpServletRequest request, HttpSession session)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String username = (String) session.getAttribute("username");
		JSONObject jsonObject = new JSONObject();
		if (username == null) {
			jsonObject.put("value", "0");
			String result = JsonUtil.toJsonString(jsonObject);
			return result;
		} else {
			String userId = request.getParameter("userId");
			String[] str = userId.split("_");
			String userid = str[1];
			// 重置密码
			userService.resetPass(userid, "000000");
			jsonObject.put("value", "1");
			String result = JsonUtil.toJsonString(jsonObject);
			return result;
		}
	}

	/*
	 * personal_个人密码修改
	 */
	@ResponseBody
	@RequestMapping(value = { "updateUserPassword" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST }, produces = "text/html;charset=UTF-8")
	public String updateUserPassword(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {

		String username = (String) session.getAttribute("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");

		if (username == null) {

			return "redirect:login.html";
		} else {
			if (password.equals(password2)) {
				// 新密码和旧密码重复

				return "0";
			} else {
				boolean islogin = userService.isLogin(username, password);
				if (islogin == false) {
					// 密码错误

					return "1";
				} else {
					// 登录成功
					password2 = MD5.EncoderByMd5(password2);
					// 修改密码
					userMapper.updateUserPassword(username, password2);
					System.out.println("返回2");

					return "2";
				}
			}
		}
	}

}
