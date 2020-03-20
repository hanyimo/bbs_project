package com.bbs.dao;

import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.bbs.pojo.ClientInvitation;
import com.bbs.pojo.Invitation;
import com.bbs.pojo.InvitationAns;
import com.bbs.pojo.InvitationAnsUser;
import com.bbs.pojo.UserInvitation;
import com.bbs.tools.BaseDao;

public class ClientDao {
	/**
	 * 把帖子保存到数据库中
	 * @param invitation--帖子
	 * @return 1-成功 0-失败
	 */
	public int saveInvitation(Invitation invitation) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = BaseDao.getCon();
			String sql = "insert into bbs_invitation("
				+ "invitationId,invitationTitle,invitationMessage,"
				+ "userId,plateId,invitationCreate,invitationModify) "
				+ "values(?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			return BaseDao.update(ps,new Object[] {
				invitation.getInvitationId(),invitation.getInvitationTitle(),
				invitation.getInvitationMessage(),invitation.getUserId(),
				invitation.getPlateId(),invitation.getInvitationCreate(),
				invitation.getInvitationModify()
			});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.close(con, ps, null);
		}
		return 0;
	}
	/**
	 * 得到所有符合要求的帖子
	 * @param plateId--版块id
	 * @return 帖子列表
	 */
	public List<ClientInvitation> listInvitations(Integer plateId){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 保存所有帖子的列表
		List<ClientInvitation> invitations = new ArrayList<>();
		try {
			con = BaseDao.getCon();
			// 增加了条件，必须通过审核，才能显示
			String sql = "select invitationId,userAlice,invitationTitle,"
					+ "invitationCreate"
					+ " from bbs_invitation left join bbs_user"
					+ " on bbs_invitation.userId=bbs_user.userId"
					+ " where bbs_invitation.isPass=1";
			if(plateId != null) {
				sql += " and plateId="+plateId;
			}
			sql += " order by invitationCreate desc";
			ps = con.prepareStatement(sql);
			rs = BaseDao.query(ps,null);
			// 格式化日期时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// 逐行把信息读取出来，放入列表中
			while(rs.next()) {
				invitations.add(
					new ClientInvitation(
							rs.getString("invitationId"),
							rs.getString("userAlice"),
							URLDecoder.decode(rs.getString("invitationTitle"),"UTF-8"),
							sdf.parse(rs.getString("invitationCreate")))
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.close(con, ps, rs);
		}
		return invitations;
	}
	/**
	 * 根据invitationId获取对应账户和帖子信息
	 * @param invitationId
	 * @return 成功返回信息 失败返回Null
	 */
	public UserInvitation findUserInvitationById(String invitationId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserInvitation result = null;
		try {
			con = BaseDao.getCon();
			String sql = "select invitationId,userAlice,invitationTitle,"
					+ "invitationMessage,userPhoto,invitationCreate"
					+ " from bbs_invitation left join bbs_user"
					+ " on bbs_invitation.userId=bbs_user.userId"
					+ " where invitationId=?";
			ps = con.prepareStatement(sql);
			rs = BaseDao.query(ps,new Object[] {invitationId});
			// 格式化日期时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(rs.next()) {
				result = new UserInvitation(
					invitationId,
					rs.getString("userAlice"),rs.getString("userPhoto"),
					URLDecoder.decode(rs.getString("invitationTitle"),"UTF-8"),
					URLDecoder.decode(rs.getString("invitationMessage"),"UTF-8"),
					sdf.parse(rs.getString("invitationCreate")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.close(con, ps, rs);
		}
		return result;
	}
	/**
	 * 保存回复信息到数据库
	 * @param invitationAns
	 * @return 1-成功 0-失败
	 */
	public int addInvitationAns(InvitationAns invitationAns) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = BaseDao.getCon();
			String sql = "insert into bbs_invitation_ans("
				+ "ansId,ansMessage,invitationId,"
				+ "userId,ansDate) "
				+ "values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			return BaseDao.update(ps,new Object[] {
				invitationAns.getAnsId(),invitationAns.getAnsMessage(),
				invitationAns.getInvitationId(),invitationAns.getUserId(),
				invitationAns.getAnsDate()
			});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.close(con, ps, null);
		}
		return 0;
	}
	/**
	 * 列出这个帖子所有的回复列表
	 * @param invitationId--帖子id
	 * @return 这个帖子所有回复的信息列表
	 */
	public List<InvitationAnsUser> listInvitationAnsById(String invitationId){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<InvitationAnsUser> invitationAnsUsers = new ArrayList<>();
		try {
			con = BaseDao.getCon();
			String sql = "select bbs_invitation_ans.*,userAlice,userPhoto from"
					+ " bbs_invitation_ans left join bbs_user"
					+ " on bbs_invitation_ans.userId=bbs_user.userId"
					+ " where bbs_invitation_ans.invitationId=?"
					+ " order by ansDate desc";
			ps = con.prepareStatement(sql);
			rs = BaseDao.query(ps,new Object[] {invitationId});
			// 格式化日期时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			while(rs.next()) {
				invitationAnsUsers.add(
					new InvitationAnsUser(
						rs.getString("ansId"),
						URLDecoder.decode(rs.getString("ansMessage"),"UTF-8"),
						rs.getString("invitationId"),
						rs.getString("userAlice"),
						sdf.parse(rs.getString("ansDate")),
						rs.getString("userPhoto")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.close(con, ps, rs);
		}
		return invitationAnsUsers;
	}
}
