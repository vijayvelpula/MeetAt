package com.stech.meetat.service;

import java.util.List;

import com.stech.meetat.pojo.UserDetails;

public interface UserService {
	  public String addUser(UserDetails userDetails);
	  public List<UserDetails> getUsers(int locationId);
	  public UserDetails getUser(int userId);
	  public String updateUser(UserDetails userDeatils);
	  public String deleteUser(int userId);
}
