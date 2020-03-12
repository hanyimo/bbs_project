package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.pojo.Plate;
import com.pojo.User;
import com.tools.BaseDao;

public class UserDao {
	/**
	 * 根据账户查找用户
	 * @param userId--账户
	 * @return 成功返回账户 失败返回null
	 */
	public User findUser(String userId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from bbs_user where userId=?";
			ps = conn.prepareStatement(sql);
			rs = BaseDao.query(ps,new Object[]{userId});
			if(rs.next()) {
				user = new User(
					rs.getString("userId"),rs.getString("userPsw"),rs.getString("userAlice"),
					rs.getString("userEmail"),rs.getString("userSex"),
					rs.getString("userPhoto"),rs.getDouble("userScore"),
					rs.getInt("userLevel"),rs.getDate("levelDown"),
					rs.getDate("userLock"),rs.getDate("userCreateDate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				BaseDao.close(conn, ps, rs);
			} catch (Exception e2) {e2.printStackTrace();}
		}
		return user;
	}
	/**
	 * 把账户存入数据库中
	 * @param user
	 * @return 0-失败 1-成功
	 */
	public int addUser(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "insert into bbs_user(userId,userPsw,"
					+ "userAlice,userEmail,userSex,userCreateDate) values(?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			return BaseDao.alter(ps,new Object[] {
				user.getUserId(),user.getUserPsw(),
				user.getUserAlice(),user.getUserEmail(),
				user.getUserSex(),new Date()
			});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				BaseDao.close(conn, ps, null);
			} catch (Exception e2) {e2.printStackTrace();}
		}
		return 0;
	}
	/**
	 * 根据账户和密码查找对应账户
	 * @param userId
	 * @param userPsw
	 * @return 找到返回账户 失败返回null
	 */
	public User findUserByIdAndPsw(String userId,String userPsw) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from bbs_user where userId=? and userPsw=?";
			ps = conn.prepareStatement(sql);
			rs = BaseDao.query(ps,new Object[] {userId,userPsw});
			if(rs.next()) {
				user = new User(
					rs.getString("userId"),rs.getString("userPsw"),
					rs.getString("userAlice"),
					rs.getString("userEmail"),rs.getString("userSex"),
					rs.getString("userPhoto"),rs.getDouble("userScore"),
					rs.getInt("userLevel"),rs.getDate("levelDown"),
					rs.getDate("userLock"),rs.getDate("userCreateDate"));
			}
		} catch (Exception e) {e.printStackTrace();
		} finally {
			try {
				BaseDao.close(conn, ps, null);
			} catch (Exception e2) {e2.printStackTrace();}
		}
		return user;
	}
	/**
	 * 添加板块到数据库
	 * @param plate
	 * @return 1-成功 0-失败
	 */
	public int addPlate(Plate plate) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "insert into bbs_plate(plateId,plateTitle,plateMessage,isEnable) values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			return BaseDao.alter(ps, new Object[] {plate.getPlateId(),
					plate.getPlateTitle(),plate.getPlateMessage(),plate.getIsEnable()});
		} catch (Exception e) {e.printStackTrace();
		} finally {
			try {
				BaseDao.close(conn, ps, null);
			} catch (Exception e2) {e2.printStackTrace();}
		}
		return 0;
	}
	/**
	 * 查询出所有的板块信息
	 * @return
	 */
	public ArrayList<Plate> listPlate(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Plate> array = new ArrayList<>();
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from bbs_plate";
			ps = conn.prepareStatement(sql);
			rs = BaseDao.query(ps, null);
			while(rs.next()) {
				array.add(new Plate(rs.getInt("plateId"),rs.getString("plateTitle"),
						rs.getString("plateMessage"),rs.getInt("isEnable")));
			}
		} catch (Exception e) {e.printStackTrace();
		} finally {
			try {
				BaseDao.close(conn, ps, rs);
			} catch (Exception e2) {e2.printStackTrace();}
		}
		return array;
	}
	
}
