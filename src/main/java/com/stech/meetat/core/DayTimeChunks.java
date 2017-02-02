package com.stech.meetat.core;

import java.util.HashMap;
import java.util.Map;

public class DayTimeChunks {

	private Map<String, Integer> timeChunks = new HashMap<String, Integer>();
	private int timeChunksCount = 48;

	public Map<String, Integer> getTimeChunks() {
		return timeChunks;
	}

	public void setTimeChunks(Map<String, Integer> timeChunks) {
		this.timeChunks = timeChunks;
	}

	public DayTimeChunks(TimeFormat timeFormat) {
		int hrs1 = 0, hrs2 = 0, mins = 0;

		if (timeFormat.value() == 2) {
			timeChunksCount = 96;
		}

		for (int i = 0; i < timeChunksCount; i++) {
			if (mins == 0) {
				timeChunks.put("" + hrs1 + hrs2 + ":" + mins + "0", i);
			} else {
				timeChunks.put("" + hrs1 + hrs2 + ":" + mins, i);
			}
			mins += 15;
			if (mins == 60) {
				mins = 0;
				hrs2 += 1;
				if (hrs2 == 10) {
					hrs2 = 0;
					hrs1 += 1;
				}
			}
		}
	}
}
