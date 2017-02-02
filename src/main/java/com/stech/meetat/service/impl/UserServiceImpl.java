package com.stech.meetat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stech.meetat.dao.UserDao;
import com.stech.meetat.pojo.UserDetails;
import com.stech.meetat.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	public String addUser(UserDetails userDetails) {
		return userDao.addUser(userDetails);
	}

	public List<UserDetails> getUsers(int locationId) {
		return userDao.getUsers(locationId);
	}

	public UserDetails getUser(int userId) {
		return userDao.getUser(userId);
	}

	public String updateUser(UserDetails userDetails) {
		return userDao.updateUser(userDetails);
	}

	public String deleteUser(int userId) {
		return userDao.deleteUser(userId);
	}

}
