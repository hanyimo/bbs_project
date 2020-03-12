package com.service;

import java.util.ArrayList;

import com.dao.UserDao;
import com.pojo.Plate;
import com.pojo.User;

public class UserService {
	// 创建UserDao对象
	private UserDao userDao = new UserDao();
	/**
	 * 根据账户查找用户
	 * @param userId--账户
	 * @return 成功返回账户 失败返回null
	 */
	public User findUser(String userId) {
		return userDao.findUser(userId);
	}
	/**
	 * 把账户存入数据库中
	 * @param user
	 * @return 0-失败 1-成功
	 */
	public int addUser(User user) {
		return userDao.addUser(user);
	}
	/**
	 * 根据账户和密码查找对应账户
	 * @param userId
	 * @param userPsw
	 * @return 找到返回账户 失败返回null
	 */
	public User findUserByIdAndPsw(String userId,String userPsw) {
		return userDao.findUserByIdAndPsw(userId, userPsw);
	}
	
	/**
	 * 添加板块到数据库
	 * @param plate
	 * @return 1-成功 0-失败
	 */
	public int addPlate(Plate plate) {
		return userDao.addPlate(plate);
	}
	/**
	 * 查询出所有的板块信息
	 * @return
	 */
	public ArrayList<Plate> listPlate(){
		return userDao.listPlate();
	}
}
