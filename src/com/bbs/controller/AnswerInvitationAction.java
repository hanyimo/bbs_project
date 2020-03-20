package com.bbs.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbs.pojo.InvitationAns;
import com.bbs.pojo.User;
import com.bbs.service.ClientService;
import com.mysql.jdbc.StringUtils;

@WebServlet("/answer_invitation")
public class AnswerInvitationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientService clientService = new ClientService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 获取请求的参数
		String invitationId = request.getParameter("invitationId");
		String ansMessage = request.getParameter("ansMessage");
		// 去除回复信息的两端空格
		ansMessage = ansMessage.trim();
		if(StringUtils.isNullOrEmpty(ansMessage)) {
			request.setAttribute("message", "不能回复空信息");
			request.getRequestDispatcher("/invitation_byid").forward(request,response);
			return;
		}
		String userId = ((User)request.getSession().getAttribute("user")).getUserId();
		Random rand = new Random();
		// 把信息封装为对象
		InvitationAns invitationAns = new InvitationAns(
			invitationId+userId+new Date().getTime()+rand.nextInt(9), 
			ansMessage, invitationId, userId, new Date());
		// 使用Service保存数据库
		clientService.addInvitationAns(invitationAns);
		request.setAttribute("message", "回复内容成功");
		request.getRequestDispatcher("/invitation_byid").forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
