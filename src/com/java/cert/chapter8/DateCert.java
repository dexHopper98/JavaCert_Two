package com.java.cert.chapter8;

//jdk 1.7.x
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

//chapter 8 cert

import com.java.cert.chapter8.codes.CountryCodeConstant;
import com.java.cert.chapter8.codes.LanguageCodeConstant;

/**************************************************************************
 * <b>Title:</b> DateCert.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description: Class to help ensure understanding of certification item: Date, Calendars 
 * and Formatting Dates</b>
 * @author Devon Franklin
 * @since Sep 19, 2016 2016
 ****************************************************/

public class DateCert {
	
	//member variables
	public static final long milli = 1_000_000_000L;
	public static final long trilli = 1_000_000_000_000L;
	
	//time variation variables
	public static final long HOUR = 60*60*1000L;
	public static final long DAY = 24*HOUR;
	public static final long WEEK = 7*DAY;
	public static final long MONTH = 4*WEEK;
	public static final long YEAR = 12*MONTH;
	
	/**
	 * The reusable Date object 
	 */
	public Date dt = null;
	
	/**
	 * No arg constructor
	 */
	public DateCert(){
		this.dt = new Date();
	}
	
	/**
	 * Constructor takes a time argument as primitive long 
	 * @param time
	 */
	public DateCert(long time){
		this.dt = new Date(time);
	}
	
	/**
	 * Outputs the current date with time from Date object
	 */
	public void getCurrentDate(){
		System.out.println("The current date and time: " + dt);
	}
	
	/**
	 * Manipulates dates using primitive longs
	 */
	public void dateManipulate(){
		dt = new Date(milli);
		System.out.println("A million milliseconds since December 31, 1969: " + dt.toString());
		dt = new Date(trilli);
		System.out.println("A trillion milliseconds since December 31, 1969: " + dt.toString());
		
		//attempt to add five years
		long fiveYears = 5 * YEAR;
		dt = new Date(fiveYears);
		System.out.println("Five years since December 31, 1969: " + new Date(1000L).toString());
		System.out.println("Five years since December 31, 1969: " + dt.toString());
		
		//print out the different time manipulations
		System.out.println("Out printing the different time manipulations via milliseconds...");
		printTimeVariations();
	}
	
	/**
	 * Manipulates dates using the (much easier)Calendar object
	 */
	public void calendarManipulate(){
		dt = new Date(1000L);
		System.out.println("The manipulated before being manipulated: " + dt.toString());
		Calendar cl = Calendar.getInstance();
		cl.setTime(dt);
		//manipulate the date(zero based index)
		cl.roll(Calendar.MONTH, 11);//doesn't affect the bigger parts
		cl.add(Calendar.YEAR, 5);
		
		//convert back to date
		Date dt2 = cl.getTime();
		System.out.println("The manipulated after being manipulated: " + dt2.toString());
	}
	
	/**
	 * Helper function to help print out time variations of class
	 */
	private void printTimeVariations(){
		System.out.println("The variaton output for hour: " + HOUR);
		System.out.println("The variaton output for day: " + DAY);
		System.out.println("The variaton output for week: " + WEEK);
		System.out.println("The variaton output for month: " + MONTH);
		System.out.println("The variaton output for year: " + YEAR);
	}
	
	public void setDateLocale(){
		//create several different country locales
		Locale locHome = Locale.getDefault();
		Locale locCree = new Locale(LanguageCodeConstant.CREE);
		Locale locBrazil = new Locale(LanguageCodeConstant.SPANISH, CountryCodeConstant.BRAZIL);
		
		//create several calendar objects
		Calendar calHome =  Calendar.getInstance(locHome);
		Calendar calCree = Calendar.getInstance(locCree);
		Calendar calBrazil =  Calendar.getInstance(locBrazil);
		
		//set the date to year may 26 ,3005,
		calHome.set(3005, 4, 26);		
		calCree.set(3005, 4, 26);	
		calBrazil.set(3005, 4, 26);	
		
		//print the date using standard format and the two different locales
		Map<Locale, Calendar> calObjects = new HashMap<>();
		for (Calendar cal : calObjects.values()) {
			//System.out.print("Outputting the date with locale: " + cal.get);
			System.out.println(" : " + cal.getTime());			
		}

	}
	
}

