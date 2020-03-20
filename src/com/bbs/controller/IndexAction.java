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
import com.bbs.pojo.ClientInvitation;
import com.bbs.pojo.Invitation;
import com.bbs.service.ClientService;

@WebServlet("/index_action")
public class IndexAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientService clientService = new ClientService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("appliction/json");
		// 获取符合要求的帖子
		List<ClientInvitation> invitations = clientService.listInvitations(null);
		// 把invitations以JSON方式输出给前端
		PrintWriter out = response.getWriter();
		out.write(JSON.toJSONString(invitations));
		return;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
