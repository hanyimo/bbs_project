package com.bbs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.pojo.Plate;
import com.bbs.service.ManageService;

@WebServlet("/alter_plate")
public class AlterPlateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManageService manageService = new ManageService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 获取参数
		Integer plateId = Integer.valueOf(request.getParameter("plateId"));
		String plateTitle = request.getParameter("plateTitle");
		String plateMessage = request.getParameter("plateMessage");
		// 封装为对象
		Plate plate = new Plate(plateId, plateTitle, plateMessage,null);
		// 使用对象，修改数据库信息
		manageService.alterPlate(plate);
		// 跳转到plate_manage.jsp
		response.sendRedirect("plate_manage.jsp");
		return;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
