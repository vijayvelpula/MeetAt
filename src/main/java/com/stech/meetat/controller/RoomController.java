package com.stech.meetat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stech.meetat.pojo.RoomDetails;
import com.stech.meetat.service.RoomService;

@Controller
@RequestMapping("/conferenceRooms")
public class RoomController {
	
	@Autowired
	RoomService roomService;
	
	@RequestMapping(value = "/addRoom", method = RequestMethod.POST)
	public @ResponseBody String addRoom(@RequestBody RoomDetails roomDetails) {
		return roomService.addRoom(roomDetails);
	}

	@RequestMapping(value = "/getRooms/{locationId}", method = RequestMethod.GET)
	public @ResponseBody List<RoomDetails> getRooms(@PathVariable("locationId") int locationId) {
		return roomService.getRooms(locationId);
	}

	@RequestMapping(value = "/getRoom/{roomId}", method = RequestMethod.GET)
	public @ResponseBody RoomDetails getRoom(@PathVariable("roomId") int roomId) {
		return roomService.getRoom(roomId);
	}

	@RequestMapping(value = "/updateRoom", method = RequestMethod.POST)
	public @ResponseBody String updateRoom(@RequestBody RoomDetails roomDetails) {
		return roomService.updateRoom(roomDetails);
	}

	@RequestMapping(value = "/deleteRoom/{roomId}", method = RequestMethod.GET)
	public @ResponseBody String deleteRoom(@PathVariable int roomId,
			@CookieValue("c") String c, @RequestHeader("h") String h) {
		return roomService.deleteRoom(roomId);
	}
}
