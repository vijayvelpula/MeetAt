package com.stech.meetat.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stech.meetat.pojo.ScheduleDetails;
import com.stech.meetat.service.DisplayService;

@Controller
public class DisplayController {

	@Autowired
	DisplayService displayService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getHomePage(){
		System.out.println("Welcome to Home Page");
		return "home";
	}
	
	@RequestMapping(value="/today", method=RequestMethod.GET)
	public @ResponseBody List<ScheduleDetails> getTodaySchedule(){
		return displayService.getTodaysSchedule();
	}
	
	@RequestMapping(value="/date/{date}", method=RequestMethod.GET)
	public @ResponseBody List<ScheduleDetails> getScheduleForDate(@RequestParam Date date) {
		return displayService.getScheduleForDate(date);
	}
	
	@RequestMapping(value="/dateRange", method=RequestMethod.GET)
	public @ResponseBody Map<Date,List<ScheduleDetails>> getScheduleForDateRange(@RequestBody Date date){
		return displayService.getScheduleForDateRange(date, date);
	}
}
 