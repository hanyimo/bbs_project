package com.bbs.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.bbs.pojo.User;
import com.bbs.service.UserService;

@WebServlet("/register")
public class RegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 创建一个UserService对象
	private UserService userService = new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 接收数据
		String userId = request.getParameter("userId");
		String userPsw = request.getParameter("userPsw");
		String userAlice = request.getParameter("userAlice");
		String userEmail = request.getParameter("userEmail");
		String userSex = request.getParameter("userSex");
		// 加密密码
		userPsw = DigestUtils.md5Hex(userPsw);
		// System.out.println(userPsw);
		User user = new User(userId,userPsw,userAlice,userEmail,userSex,
				null,null,null,null,null,new Date());
		// 验证账户是否存在数据库中
		if(userService.findUser(userId) != null) {
			request.setAttribute("message","账户已经存在");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		// 把账户存入数据库中
		userService.addUser(user);
		request.setAttribute("message","注册新用户成功");
		request.getRequestDispatcher("register.jsp").forward(request, response);
		return;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
