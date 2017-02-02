package com.stech.meetat.dao;

import java.util.List;

import com.stech.meetat.pojo.UserDetails;

public interface UserDao {
	public String addUser(UserDetails userDetails);
	public List<UserDetails> getUsers(int locationId);
	public UserDetails getUser(int userId);
	public String updateUser(UserDetails userDetails);
	public String deleteUser(int userId);
}
