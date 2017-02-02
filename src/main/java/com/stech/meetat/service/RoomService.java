package com.stech.meetat.service;

import java.util.List;

import com.stech.meetat.pojo.RoomDetails;

public interface RoomService {
  public String addRoom(RoomDetails roomDetails);
  public List<RoomDetails> getRooms(int locationId);
  public RoomDetails getRoom(int roomId);
  public String updateRoom(RoomDetails roomDeatils);
  public String deleteRoom(int roomId);
}
