package com.bbs.service;

import com.bbs.dao.UserDao;
import com.bbs.pojo.User;

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
}
