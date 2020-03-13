package com.bbs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.service.ManageService;

@WebServlet("/delete_plate")
public class DeletePlateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManageService manageService = new ManageService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		// 接收请求数据
		Integer plateId = Integer.valueOf(request.getParameter("plateId"));
		// 从数据库中删除版块
		manageService.deltePlateById(plateId);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
