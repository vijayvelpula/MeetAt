package com.stech.meetat.util;

import java.util.Date;
import java.util.List;

public interface EventOccurrenceDatesX {
	List<String> calculateForDaily();
	List<Date> calculateForWeekly();
	List<Date> calculateForMonthly();
	List<Date> calculateForMonthlyWeekWise();
	List<Date> calculateForYearly();
}
