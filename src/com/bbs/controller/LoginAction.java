package com.bbs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.bbs.pojo.User;
import com.bbs.service.UserService;

@WebServlet("/login")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 创建服务层对象
	private UserService userService = new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 接收数据
		String userId = request.getParameter("userId");
		String userPsw = request.getParameter("userPsw");
		// 加密密码
		userPsw = DigestUtils.md5Hex(userPsw);
		// 判断账户和密码是否存在并正确
		User user = userService.findUserByIdAndPsw(userId, userPsw);
		if(user == null) {
			request.setAttribute("message","账户或密码不正确");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		// 把user保存到session
		request.getSession().setAttribute("user",user);
		// 判断是管理员还是一般用户
		if(user.getUserLevel() == 4) {// 管理员
			response.sendRedirect("manager.jsp");
			return;
		}
		else {// 一般用户
			response.sendRedirect("index.jsp");
			return;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
