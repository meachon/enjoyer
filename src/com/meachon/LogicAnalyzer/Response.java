package com.meachon.LogicAnalyzer;

import com.enjoyer.util.datetime.CurrentDateTime;

public class Response {

	public String contextValue;
	
	public Response(String value) {
		// TODO Auto-generated constructor stub
		this.contextValue = value;
	}
	
	public String getCurrentTime()
	{
		CurrentDateTime time = new CurrentDateTime();
		return time.getCurrentTimeString();
	}

}
