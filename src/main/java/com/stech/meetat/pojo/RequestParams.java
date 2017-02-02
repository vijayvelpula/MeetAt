package com.stech.meetat.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class RequestParams {
	private String str;
	private Date startDate;
	private Date endDate;
}
