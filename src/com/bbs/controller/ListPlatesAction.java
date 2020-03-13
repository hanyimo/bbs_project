package com.bbs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.bbs.pojo.Plate;
import com.bbs.service.ManageService;

@WebServlet("/list_plates")
public class ListPlatesAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManageService manageService = new ManageService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 响应数据为JSON数据
		response.setContentType("application/json");
		// 查询数据库，获取到所有版块的列表
		List<Plate> plates = manageService.listPlates();
		// 把此列表以JSON方式发送到前端
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(plates));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
