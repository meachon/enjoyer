package com.enjoyer.util.datetime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *当前时间类
 * @author yxg
 *
 */
public class CurrentDateTime {
	
	private static String strDateTime= null;
	
	public CurrentDateTime()
	{
	}
	
	
	/**
	 * 外部获取当前时间字符串
	 * @return
	 */
	public String getCurrentTimeString()
	{
		Date dat = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		strDateTime = dateFormat.format(dat);
		return strDateTime;
	}
}
