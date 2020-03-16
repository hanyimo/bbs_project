package com.bbs.pojo;

import java.util.Date;

public class Invitation {
	private String invitationId;
	private String invitationTitle;
	private String invitationMessage;
	private String userId;
	private Integer plateId;
	private Integer categoryId;
	private Integer isPass;
	private Integer isEnable;
	private Integer isCream;
	private Date invitationCreate;
	private Date invitationModify;
	public Invitation() {
		super();
	}
	public Invitation(String invitationId, String invitationTitle, String invitationMessage, String userId,
			Integer plateId, Integer categoryId, Integer isPass, Integer isEnable, Integer isCream,
			Date invitationCreate, Date invitationModify) {
		super();
		this.invitationId = invitationId;
		this.invitationTitle = invitationTitle;
		this.invitationMessage = invitationMessage;
		this.userId = userId;
		this.plateId = plateId;
		this.categoryId = categoryId;
		this.isPass = isPass;
		this.isEnable = isEnable;
		this.isCream = isCream;
		this.invitationCreate = invitationCreate;
		this.invitationModify = invitationModify;
	}
	public String getInvitationId() {
		return invitationId;
	}
	public void setInvitationId(String invitationId) {
		this.invitationId = invitationId;
	}
	public String getInvitationTitle() {
		return invitationTitle;
	}
	public void setInvitationTitle(String invitationTitle) {
		this.invitationTitle = invitationTitle;
	}
	public String getInvitationMessage() {
		return invitationMessage;
	}
	public void setInvitationMessage(String invitationMessage) {
		this.invitationMessage = invitationMessage;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getPlateId() {
		return plateId;
	}
	public void setPlateId(Integer plateId) {
		this.plateId = plateId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getIsPass() {
		return isPass;
	}
	public void setIsPass(Integer isPass) {
		this.isPass = isPass;
	}
	public Integer getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}
	public Integer getIsCream() {
		return isCream;
	}
	public void setIsCream(Integer isCream) {
		this.isCream = isCream;
	}
	public Date getInvitationCreate() {
		return invitationCreate;
	}
	public void setInvitationCreate(Date invitationCreate) {
		this.invitationCreate = invitationCreate;
	}
	public Date getInvitationModify() {
		return invitationModify;
	}
	public void setInvitationModify(Date invitationModify) {
		this.invitationModify = invitationModify;
	}
}
