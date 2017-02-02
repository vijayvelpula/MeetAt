package com.stech.meetat.dao.impl;

import java.util.List;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import com.stech.meetat.dao.UserDao;
import com.stech.meetat.pojo.UserDetails;
@PropertySource("classpath:application.properties")
@Repository("userDao")
public class UserDaoImpl implements UserDao {

	public String addUser(UserDetails userDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserDetails> getUsers(int locationId) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDetails getUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateUser(UserDetails userDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
