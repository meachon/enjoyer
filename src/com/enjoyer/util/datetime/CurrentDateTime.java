package com.enjoyer.util.datetime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *��ǰʱ����
 * @author yxg
 *
 */
public class CurrentDateTime {
	
	private static String strDateTime= null;
	
	public CurrentDateTime()
	{
	}
	
	
	/**
	 * �ⲿ��ȡ��ǰʱ���ַ���
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
