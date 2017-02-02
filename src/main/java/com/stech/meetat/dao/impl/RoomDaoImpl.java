package com.stech.meetat.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.stech.meetat.core.RoomDetailsRowMapper;
import com.stech.meetat.dao.RoomDao;
import com.stech.meetat.pojo.RoomDetails;

@PropertySource("classpath:application.properties")
@Repository("roomDao")
public class RoomDaoImpl implements RoomDao {
	
	 @Autowired
	 JdbcTemplate jdbcTemplate;
	 
	 @Autowired
	 Environment environment;
	 
	public String addRoom(RoomDetails roomDetails) {
		int effectedRows = 0;
		Object[] args = {roomDetails.getName(), 
				roomDetails.getCapacity(), 
				roomDetails.getDescription() , 
				roomDetails.getLocationId()};
		effectedRows = jdbcTemplate.update(environment.getProperty("room.insert"), args );
		
		if(effectedRows > 0){
			return environment.getProperty("room.insert.success");
		} else {
			return environment.getProperty("room.insert.fail");
		}
	}

	public List<RoomDetails> getRooms(int locationId) {
		List<RoomDetails> result = null;
		String message = environment.getProperty("room.list.fail");
		try {
			Object[] args = { locationId };
			result = jdbcTemplate.query(environment.getProperty("room.list"),
					args, new RoomDetailsRowMapper());
			if (result.size() > 0) {
				message = environment.getProperty("room.list.success");
			}
		} catch (DataAccessException dataAccEx) {
			dataAccEx.printStackTrace();
		}
		return result;
	}

	public RoomDetails getRoom(int roomId) {
		List<RoomDetails> result;
		String message = environment.getProperty("room.fetch.fail");
		Object[] args = {roomId};
		result = jdbcTemplate.query(environment.getProperty("room.fetch"), args, new RoomDetailsRowMapper());
		if(result.size() > 0 && result.size() == 1){
			message = environment.getProperty("room.fetch.success");
			return result.get(0);
		} else if(result.size() > 1) {
			message = environment.getProperty("room.fetch.duplicate");
		}
		return null;
	}

	public String updateRoom(RoomDetails roomDetails) {
		int effectedRows = 0;
		Object[] args = {roomDetails.getName(), 
				roomDetails.getCapacity(), 
				roomDetails.getDescription() , 
				roomDetails.getId()};
		effectedRows = jdbcTemplate.update(environment.getProperty("room.update"), args );
		if(effectedRows > 0){
			return environment.getProperty("room.update.success");
		} else {
			return environment.getProperty("room.update.fail");
		}
	}

	public String deleteRoom(int roomId) {
		int effectedRows = 0;
		Object[] args = { roomId };
		effectedRows = jdbcTemplate.update(environment.getProperty("room.delete"), args );
		if(effectedRows > 0){
			return environment.getProperty("room.delete.success");
		} else {
			return environment.getProperty("room.delete.fail");
		}
	}

}
