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

import com.alibaba.fastjson.JSONObject;
import com.xjtu.iqa.mapper.UserMapper;
import com.xjtu.iqa.po.User;
import com.xjtu.iqa.util.JsonUtil;

@Controller
public class UserController {
	@Autowired
	UserMapper userMapper;
	

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
}
