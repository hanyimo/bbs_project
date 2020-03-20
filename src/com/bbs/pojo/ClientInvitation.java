package com.bbs.pojo;

import java.util.Date;

public class ClientInvitation {
	private String invitationId;
	private String userAlice;
	private String invitationTitle;
	private Date invitationCreate;
	public ClientInvitation() {
		super();
	}
	public ClientInvitation(String invitationId, String userAlice, 
			String invitationTitle, Date invitationCreate) {
		super();
		this.invitationId = invitationId;
		this.userAlice = userAlice;
		this.invitationTitle = invitationTitle;
		this.invitationCreate = invitationCreate;
	}
	public String getInvitationId() {
		return invitationId;
	}
	public void setInvitationId(String invitationId) {
		this.invitationId = invitationId;
	}
	public String getUserAlice() {
		return userAlice;
	}
	public void setUserAlice(String userAlice) {
		this.userAlice = userAlice;
	}
	public String getInvitationTitle() {
		return invitationTitle;
	}
	public void setInvitationTitle(String invitationTitle) {
		this.invitationTitle = invitationTitle;
	}
	public Date getInvitationCreate() {
		return invitationCreate;
	}
	public void setInvitationCreate(Date invitationCreate) {
		this.invitationCreate = invitationCreate;
	}
}
