package com.bbs.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.pojo.Invitation;
import com.bbs.service.ManageService;
import com.mysql.jdbc.StringUtils;

@WebServlet("/add_invitation")
public class AddInvitationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ManageService manageService = new ManageService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取参数
		String isplateId = request.getParameter("plateId");
		String userId = request.getParameter("userId");
		String invitationTitle = request.getParameter("invitationTitle");
		String invitationMessage = request.getParameter("invitationMessage");
		Integer plateId = Integer.valueOf(isplateId);
		String invitationId = isplateId + new Date();
		// 去除两端空格
		invitationMessage = invitationMessage.trim();
		if(StringUtils.isNullOrEmpty(invitationMessage)) {
			request.setAttribute("mesg", "发帖内容不能为空");
			request.getRequestDispatcher("send_invitation.jsp").forward(request, response);
			return;
		}
		// 封装为帖子对象
		Invitation invitation = new Invitation(invitationId,invitationTitle, invitationMessage,
				userId, plateId,null,0,0,0,new Date(),new Date());
		//添加帖子内容
		manageService.addInvitation(invitation);
		request.getRequestDispatcher("send_invitation.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
