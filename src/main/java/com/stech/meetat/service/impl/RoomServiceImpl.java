package com.stech.meetat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stech.meetat.dao.RoomDao;
import com.stech.meetat.pojo.RoomDetails;
import com.stech.meetat.service.RoomService;

@Service("roomService")
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	RoomDao roomDao;
	
	public String addRoom(RoomDetails roomDetails) {
		return roomDao.addRoom(roomDetails);
	}

	public List<RoomDetails> getRooms(int locationId) {
		return roomDao.getRooms(locationId);
	}

	public RoomDetails getRoom(int roomId) {
		return roomDao.getRoom(roomId);
	}

	public String updateRoom(RoomDetails roomDetails) {
		return roomDao.updateRoom(roomDetails);
	}

	public String deleteRoom(int roomId) {
		return roomDao.deleteRoom(roomId);
	}

}
