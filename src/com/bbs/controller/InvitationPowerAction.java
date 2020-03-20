package com.bbs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.pojo.Invitation;
import com.bbs.service.ManageService;

@WebServlet("/invitation_power_action")
public class InvitationPowerAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManageService manageService = new ManageService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取参数值
		String invitationId = request.getParameter("invitationId");
		Integer isPass = Integer.valueOf(request.getParameter("isPass"));
		// 把上面的数据封装为Invitation对象
		Invitation invitation = new Invitation(invitationId,null,null,
				null,null,null,isPass,null,null,null,null);
		// 调用服务，去修改对应invitationId的isPass值
		manageService.alterInvitationPower(invitation);
		request.getRequestDispatcher("/invitation_power").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
