package com.stech.meetat.core;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.stech.meetat.pojo.RoomDetails;

public class RoomDetailsRowMapper implements RowMapper<RoomDetails>{

	public RoomDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		RoomDetails roomDetails = new RoomDetails();
		roomDetails.setId(rs.getInt("id"));
		roomDetails.setName(rs.getString("name"));
		roomDetails.setCapacity(rs.getInt("capacity"));
		roomDetails.setDescription(rs.getString("description"));
		roomDetails.setLocationId(rs.getInt("location_Id"));
		return roomDetails;
	}

}
