package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.pojo.Plate;
import com.pojo.User;
import com.service.UserService;

@WebServlet("/add_plate")
public class AddPlateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 创建服务层对象
	private UserService userService = new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 接收数据
		String plateTitle = request.getParameter("plateTitle");
		String plateMessage = request.getParameter("plateMessage");
		//创建类
		Plate plate = new Plate(null,plateTitle,plateMessage,null); 
		//添加板块
		userService.addPlate(plate);
		//跳转
		response.sendRedirect("grid.jsp");
		return;
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
