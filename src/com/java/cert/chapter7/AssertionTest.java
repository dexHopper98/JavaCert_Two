package com.java.cert.chapter7;
/**************************************************************************
 * <b>Title:</b> AssertionTest.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description:</b>
 * <b>Copyright:</b>Copyright (c) 2016
 * @author Devon Franklin
 * @since Apr 11, 2016 
 ****************************************************/

public class AssertionTest {

	public static void main(String args[]){
		int x=  2;  
		int y = 5;
		
		y = 2 * 10;
		x = ++x * 5;
		
		assert(y < 0);		
		System.out.println("Value of y " + y);
	}
}

