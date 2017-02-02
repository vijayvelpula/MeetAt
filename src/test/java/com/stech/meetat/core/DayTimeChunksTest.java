package com.stech.meetat.core;

import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.stech.meetat.core.DayTimeChunks;
import com.stech.meetat.core.TimeFormat;

public class DayTimeChunksTest {

	@Test
	public void testDayTimeChunks(){
		DayTimeChunks dayTimeChumks = new DayTimeChunks(TimeFormat.Hrs12);
		Map<String,Integer> timeChunks = dayTimeChumks.getTimeChunks();
		Set<String> keys = timeChunks.keySet();
		for(String key:keys){
			System.out.println(key+" : "+timeChunks.get(key));
		}
	}
	
}
