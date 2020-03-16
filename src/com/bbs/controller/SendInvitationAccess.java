package com.bbs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.pojo.Plate;
import com.bbs.service.ManageService;

@WebServlet("/send_invitation_access")
public class SendInvitationAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ManageService manageService = new ManageService(); 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取所有版块信息列表
		List<Plate> plates = manageService.listPlates();
		//封装
		request.setAttribute("plates", plates);
		request.getRequestDispatcher("send_invitation.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
