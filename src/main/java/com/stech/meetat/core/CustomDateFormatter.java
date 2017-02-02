package com.stech.meetat.core;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.datetime.DateFormatter;

public class CustomDateFormatter {
	private final static DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
	private final static DateFormat inputFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
	DateFormatter dateFormatter = new DateFormatter();

	public Date parseToDate(String inputDate){
		try {
			System.out.println("Input from UI: "+inputDate);
			return inputFormatter.parse(inputDate);
		} catch (ParseException parseEx) {
			parseEx.printStackTrace();
		}
		return null;
	}

	public String formatToString(Date date){
		return outputFormatter.format(date);
	}

}
