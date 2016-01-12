package com.stech.meeta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DisplayController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getHomePage(){
		System.out.println("Welcome to Home Page");
		return "home";
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String getHomePage2(){
		return "home";
	}
}
