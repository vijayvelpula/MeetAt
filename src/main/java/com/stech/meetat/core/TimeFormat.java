package com.stech.meetat.core;

public enum TimeFormat {
	Hrs12(1), Hrs24(2);

	private int timeFormatValue;

	TimeFormat(int x) {
		this.timeFormatValue = x;
	}

	public int value() {
		return this.timeFormatValue;
	}
}


