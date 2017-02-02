package com.stech.meetat.dao.impl;

import org.junit.Test;

import com.stech.meetat.pojo.RoomDetails;

public class RoomDaoTest {

	@Test
	public void addRoomTest(){
		
	}
	
	private RoomDetails getRoomDetails(){
		RoomDetails roomDetails = new RoomDetails();
			roomDetails.setName("C-1");
			roomDetails.setCapacity(20);
			roomDetails.setDescription("1 Floor, 1 Left, Near HR Cabin");
			roomDetails.setLocationId(1);
		return roomDetails;
	}
	
}
