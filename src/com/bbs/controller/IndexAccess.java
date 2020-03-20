package com.bbs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.pojo.ClientInvitation;
import com.bbs.pojo.Invitation;
import com.bbs.service.ClientService;
import com.mysql.jdbc.StringUtils;

@WebServlet("/index")
public class IndexAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientService clientService = new ClientService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 接收 plateId
		String sPlateId = request.getParameter("plateId");
		// 默认为null
		Integer plateId = null;
		if(!StringUtils.isNullOrEmpty(sPlateId)) {
			plateId = Integer.valueOf(sPlateId);
		}
		// 获取所有的帖子列表
		List<ClientInvitation> invitations = clientService.listInvitations(plateId);
		// 把帖子作为request的属性
		request.setAttribute("invitations", invitations);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}


