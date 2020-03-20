package com.bbs.service;

import java.util.List;

import com.bbs.dao.ManageDao;
import com.bbs.pojo.Invitation;
import com.bbs.pojo.Plate;

public class ManageService {
	// 创建一个ManageDao 对象
	private ManageDao manageDao = new ManageDao();
	/**
	 * 添加新的板块
	 * @param plate
	 * @return 成功返回新添加的Plate对象 失败返回null
	 */
	public Plate addPlate(Plate plate) {
		return manageDao.addPlate(plate);
	}
	/**
	 * 获取所有版块的列表
	 * @return 获取到的所有版块列表信息
	 */
	public List<Plate> listPlates(){
		return manageDao.listPlates();
	}
	/**
	 * 根据plateId删除对应版块信息
	 * @param plateId
	 * @return 1-成功 0-失败
	 */
	public int deltePlateById(Integer plateId) {
		return manageDao.deltePlateById(plateId);
	}
	/**
	 * 修改plate的Title和Message
	 * @param plate
	 * @return 1-成功 0-失败
	 */
	public int alterPlate(Plate plate) {
		return manageDao.alterPlate(plate);
	}
	/**
	 * 获取所有帖子的列表
	 * @return 帖子列表
	 */
	public List<Invitation> listiInvitations(){
		return manageDao.listInvitations();
	}
	/**
	 * 根据帖子id查询帖子
	 * @param invitationId--帖子id
	 * @return 成功返回找到的帖子对象，失败返回null
	 */
	public Invitation findInvitationById(String invitationId) {
		return manageDao.findInvitationById(invitationId);
	}
	/**
	 * 修改帖子的权限
	 * @param invitation--帖子
	 * @return 1-成功 0-失败
	 */
	public int alterInvitationPower(Invitation invitation) {
		return manageDao.alterInvitationPower(invitation);
	}
}
