package com.cognizant.truyum.util;

/**
 * @author Sai Kiran
 *
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
public class DateUtil {
	
	public static Date convertToDateDD(String date) {
		
		Date dt = null;
		
		try {
			dt = new SimpleDateFormat("dd-MM-yyyy").parse(date);
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}
		
		return dt;
	}
	
	
	public static Date convertToDateYY(String date) {
		
		Date dt = null;
		
		try {
			dt = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}
		
		return dt;
	}
	
}
