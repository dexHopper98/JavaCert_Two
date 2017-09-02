package com.java.cert.chapter8;
/**************************************************************************
 * <b>Title:</b> Chapter8Test.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description:</b> Serves as the runnable application point for 
 * testing certification chapter knowledge
 * @author Devon Franklin
 * @version: 1.0
 * @since Sep 19, 2016
 ****************************************************/

public class Chapter8Test {

	/**
	 * The test method name enum
	 */
	public enum TEST_METHOD{
		TEST_DATE, TEST_DATE_LOCALE, TEST_NUMBER_FORMAT,
		TEST_NUMBER_FORMAT_LOCALE
	}
	
	/**
	/*Main method
	 * @param args
	 */
	public static void main(String[] args) {
		Chapter8Test chpt = new Chapter8Test();
		
		//test each one of the possible methods
		for (TEST_METHOD method :  TEST_METHOD.values()) {
			chpt.test(method);
		}

	}
	
	/**
	 * Calls a test method to run based upon the test enum name passed
	 * @param methodName
	 */
	public void test(TEST_METHOD methodName ){
		switch(methodName){
		case TEST_DATE:
			testDate();
			break;
		case TEST_DATE_LOCALE:
			testDateLocale();
			break;
		case TEST_NUMBER_FORMAT:
			testNumberFormat();
			break;
		case TEST_NUMBER_FORMAT_LOCALE:
			testNumberFormatLocale();
			break;
		}
	}
	
	/**
	 * Test knowledge of dates and calendars
	 */
	protected void testDate(){
		System.out.println("Starting test date method....");
		DateCert dtc = new DateCert();
		
		//test knowledge of date creation
		dtc.getCurrentDate();
		
		//test knowledge of date manipulation
		dtc.dateManipulate();
		
		//test knowledge of date localization
		dtc.calendarManipulate();
		
		System.out.println("");
	}
	
	protected void testDateLocale(){
		System.out.println("Starting test date locale method....");
		System.out.println("");
	}
	
	protected void testNumberFormat(){
		System.out.println("Starting test number format method....");
		System.out.println("");
	}
	
	protected void testNumberFormatLocale(){
		System.out.println("Starting test number format locale method....");
		System.out.println("");
	}

}

