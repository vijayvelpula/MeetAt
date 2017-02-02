package com.stech.meetat.dao;

import java.util.List;

import com.stech.meetat.pojo.RoomDetails;

public interface RoomDao {
	public String addRoom(RoomDetails roomDetails);
	public List<RoomDetails> getRooms(int locationId);
	public RoomDetails getRoom(int roomId);
	public String updateRoom(RoomDetails roomDetails);
	public String deleteRoom(int roomId);
}
