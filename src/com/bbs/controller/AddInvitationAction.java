package com.bbs.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.pojo.Invitation;
import com.bbs.pojo.User;
import com.bbs.service.ClientService;
import com.mysql.jdbc.StringUtils;

@WebServlet("/add_invitation")
public class AddInvitationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientService clientService = new ClientService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取参数
		String sPlateId = request.getParameter("plateId");
		String invitationTitle = request.getParameter("invitationTitle");
		String invitationMessage = request.getParameter("invitationMessage");
		// 去除两端空格
		sPlateId = sPlateId.trim();
		invitationTitle = invitationTitle.trim();
		invitationMessage = invitationMessage.trim();
		// 验证内容是否都有
		if(StringUtils.isNullOrEmpty(sPlateId) 
				|| StringUtils.isNullOrEmpty(invitationTitle) 
				|| StringUtils.isNullOrEmpty(invitationMessage)) {
			request.setAttribute("message", "发帖内容不能为空");
			request.getRequestDispatcher("/send_invitation_access").forward(request, response);
			return;
		}
		Integer plateId = Integer.valueOf(sPlateId);
		// 获取发帖用户id
		User user = (User)request.getSession().getAttribute("user");
		Random random = new Random();
		// 封装为帖子对象
		Invitation invitation = new Invitation(
				user.getUserId()+new Date().getTime()+random.nextInt(9),
				invitationTitle, invitationMessage,
				user.getUserId(), plateId,null,0,0,0,new Date(),new Date());
		// 把帖子保存到数据库
		clientService.saveInvitation(invitation);
		request.setAttribute("message", "发帖成功");
		request.getRequestDispatcher("/send_invitation_access").forward(request, response);
		return;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
