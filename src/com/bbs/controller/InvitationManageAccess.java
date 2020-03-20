package com.bbs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.pojo.Invitation;
import com.bbs.service.ManageService;

@WebServlet("/invitation_manage")
public class InvitationManageAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManageService manageService = new ManageService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 从数据库中获取帖子列表
		List<Invitation> invitations = manageService.listiInvitations();
		// 把帖子放入request属性中
		request.setAttribute("invitations", invitations);
		request.getRequestDispatcher("invitation_manage.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
