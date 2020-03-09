package com.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.BBSUser;
import com.service.BBSService;

@WebServlet("/register")
public class RegisterService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BBSService  bbsService= new BBSService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取数据
		String userId = request.getParameter("userId");
		String userPsw = request.getParameter("userPsw");
		String userAlice = request.getParameter("userAlice");
		String userEmail = request.getParameter("userEmail");
		String userSex = request.getParameter("userSex");
		//判断姓名是否重复
		if(bbsService.findUserId(userId) != null) {
			request.setAttribute("error", "该用户名已存在！");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}else {
			//创建对象
			BBSUser user = new BBSUser(userId,userPsw,userAlice,userEmail,userSex,null,0,null,null,null,new Date()); 
			//添加数据进数据库
			bbsService.addUser(user);
			request.setAttribute("error", "注册成功！");
			//跳转回注册页面
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
