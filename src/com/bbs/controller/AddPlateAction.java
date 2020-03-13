package com.bbs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.bbs.pojo.Plate;
import com.bbs.service.ManageService;

@WebServlet("/add_plate")
public class AddPlateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManageService manageService = new ManageService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 响应数据为JSON数据
		response.setContentType("application/json");
		// 获取请求信息
		String plateTitle = request.getParameter("plateTitle");
		String plateMessage = request.getParameter("plateMessage");
		// 把plate封装为对象
		Plate plate = new Plate(null, plateTitle, plateMessage, null);
		// 把plate存入数据库中
		Plate result = manageService.addPlate(plate);
		// 获取out对象
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(result));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
