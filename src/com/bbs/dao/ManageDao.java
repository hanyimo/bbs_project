package com.bbs.dao;

import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.bbs.pojo.Invitation;
import com.bbs.pojo.Plate;
import com.bbs.tools.BaseDao;

public class ManageDao {
	/**
	 * 添加新的板块
	 * @param plate
	 * @return @return 成功返回新添加的Plate对象 失败返回null
	 */
	public Plate addPlate(Plate plate) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = BaseDao.getCon();
			String sql = "insert into bbs_plate(plateTitle,plateMessage) values(?,?)";
			ps = con.prepareStatement(sql);
			BaseDao.update(ps,new Object[] {
				plate.getPlateTitle(),plate.getPlateMessage()
			});
			// 返回最后插入的那个自增的值
			sql = "select last_insert_id()";
			ps = con.prepareStatement(sql);
			rs = BaseDao.query(ps,null);
			if(rs.next())
				plate.setPlateId(rs.getInt(1));
			// 把屏蔽信息设置为不屏蔽
			plate.setIsEnable(0);
			return plate;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.close(con, ps, rs);
		}
		return null;
	}
	/**
	 * 获取所有版块的列表
	 * @return 获取到的所有版块列表信息
	 */
	public List<Plate> listPlates(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 保存所有版块信息(此处一定要初始化)
		List<Plate> plates = new ArrayList<>();
		try {
			con = BaseDao.getCon();
			String sql = "select * from bbs_plate order by plateId desc";
			ps = con.prepareStatement(sql);
			rs = BaseDao.query(ps,null);
			// 逐行把信息读取出来，放入列表中
			while(rs.next()) {
				plates.add(new Plate(
						rs.getInt("plateId"),rs.getString("plateTitle"),
						rs.getString("plateMessage"),rs.getInt("isEnable")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.close(con, ps, rs);
		}
		return plates;
	}
	/**
	 * 根据plateId删除对应版块信息
	 * @param plateId
	 * @return 1-成功 0-失败
	 */
	public int deltePlateById(Integer plateId) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = BaseDao.getCon();
			String sql = "delete from bbs_plate where plateId=?";
			ps = con.prepareStatement(sql);
			return BaseDao.update(ps, new Object[] {plateId});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.close(con, ps, null);
		}
		return 0;
	}
	/**
	 * 修改plate的Titleh和Message
	 * @param plate
	 * @return 1-成功 0-失败
	 */
	public int alterPlate(Plate plate) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = BaseDao.getCon();
			String sql = "update bbs_plate set plateTitle=?,plateMessage=? "
					+ "where plateId=?";
			ps = con.prepareStatement(sql);
			return BaseDao.update(ps, new Object[] {
				plate.getPlateTitle(),plate.getPlateMessage(),plate.getPlateId()
			});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.close(con, ps, null);
		}
		return 0;
	}
	/**
	 * 获取所有帖子的列表
	 * @return 帖子列表
	 */
	public List<Invitation> listInvitations(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 保存所有帖子的列表
		List<Invitation> invitations = new ArrayList<>();
		try {
			con = BaseDao.getCon();
			String sql = "select * from bbs_invitation order"
					+ " by isPass asc,invitationModify desc";
			ps = con.prepareStatement(sql);
			rs = BaseDao.query(ps,null);
			// 格式化日期时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// 逐行把信息读取出来，放入列表中
			while(rs.next()) {
				invitations.add(
					new Invitation(
							rs.getString("invitationId"),
							URLDecoder.decode(rs.getString("invitationTitle"),"UTF-8"),
							URLDecoder.decode(rs.getString("invitationMessage"),"UTF-8"),
							rs.getString("userId"),rs.getInt("plateId"),
							rs.getInt("categoryId"),rs.getInt("isPass"),
							rs.getInt("isEnable"),rs.getInt("isCream"),
							sdf.parse(rs.getString("invitationCreate")),
							sdf.parse(rs.getString("invitationModify")))
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
	 * 根据帖子id查询帖子
	 * @param invitationId--帖子id
	 * @return 成功返回找到的帖子对象，失败返回null
	 */
	public Invitation findInvitationById(String invitationId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Invitation invitation = null;
		try {
			con = BaseDao.getCon();
			String sql = "select * from bbs_invitation where invitationId=?";
			ps = con.prepareStatement(sql);
			rs = BaseDao.query(ps,new Object[] {invitationId});
			// 格式化日期时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// 逐行把信息读取出来，放入列表中
			if(rs.next()) {
				invitation = new Invitation(
							rs.getString("invitationId"),
							URLDecoder.decode(rs.getString("invitationTitle"),"UTF-8"),
							URLDecoder.decode(rs.getString("invitationMessage"),"UTF-8"),
							rs.getString("userId"),rs.getInt("plateId"),
							rs.getInt("categoryId"),rs.getInt("isPass"),
							rs.getInt("isEnable"),rs.getInt("isCream"),
							sdf.parse(rs.getString("invitationCreate")),
							sdf.parse(rs.getString("invitationModify"))
				);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.close(con, ps, rs);
		}
		return invitation;
	}
	/**
	 * 修改帖子的权限
	 * @param invitation--帖子
	 * @return 1-成功 0-失败
	 */
	public int alterInvitationPower(Invitation invitation) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = BaseDao.getCon();
			String sql = "update bbs_invitation set isPass=?"
					+ " where invitationId=?";
			ps = con.prepareStatement(sql);
			return BaseDao.update(ps, new Object[] {
				invitation.getIsPass(),invitation.getInvitationId()
			});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.close(con, ps, null);
		}
		return 0;
	}
}









