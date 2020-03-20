package com.bbs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.pojo.InvitationAnsUser;
import com.bbs.pojo.UserInvitation;
import com.bbs.service.ClientService;

@WebServlet("/invitation_byid")
public class InvitationByIdAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientService clientService = new ClientService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取invitationId
		String invitationId = request.getParameter("invitationId");
		UserInvitation ui = clientService.findUserInvitationById(invitationId);
		// 把数据放入request
		request.setAttribute("ui", ui);
		// 把这个帖子所有回复的信息，获取出来
		List<InvitationAnsUser> invitationAnsUsers = clientService.listInvitationAnsById(invitationId);
		// 把所有回复放入request中
		request.setAttribute("anss", invitationAnsUsers);
		request.getRequestDispatcher("invitation_answer.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
