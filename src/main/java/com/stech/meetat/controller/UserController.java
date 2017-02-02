package com.stech.meetat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stech.meetat.pojo.UserDetails;
import com.stech.meetat.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public @ResponseBody String addUser(@RequestBody UserDetails userDetails) {
		return userService.addUser(userDetails);
	}

	@RequestMapping(value = "/getUsers/{locationId}", method = RequestMethod.GET)
	public @ResponseBody List<UserDetails> getUsers(@PathVariable("locationId") int locationId) {
		return userService.getUsers(locationId);
	}

	@RequestMapping(value = "/getUser/{userId}", method = RequestMethod.GET)
	public @ResponseBody UserDetails getUser(@PathVariable("userId") int userId) {
		return userService.getUser(userId);
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public @ResponseBody String updateUser(@RequestBody UserDetails userDetails) {
		return userService.updateUser(userDetails);
	}

	@RequestMapping(value = "/deleteUser/{userId}", method = RequestMethod.GET)
	public @ResponseBody String deleteUser(@PathVariable int userId) {
		return userService.deleteUser(userId);
	}
}
