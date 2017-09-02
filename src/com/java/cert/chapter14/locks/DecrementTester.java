package com.java.cert.chapter14.locks;
/**************************************************************************
 * <b>Title:</b> DecrementTester.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description:</b>
 * @author Devon Franklin
 * @version: 1.0
 * @since Aug 24, 2017
 ****************************************************/

public class DecrementTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean isSafe = false;
		//create our shared resource
		Decrementer dmt = new Decrementer();
		//dmt.setDecrementSafetly(isSafe);
		dmt.setDecrementWithLock(true);
		
		//create several threads
		Thread t1 = new Thread(dmt);
		Thread t2 = new Thread(dmt);
		t1.setName("threadOne");
		t2.setName("threadTwo");
		
		//start our threads
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			System.err.println("Error attempting to join behind referenced threads: " + e);
		}
		
		//print our final count(our final count should be -1000 - if done safely)
		if(isSafe)
			System.out.println("Our final atomic count  " + dmt.getCount().getAtomicCount());
		else
			System.out.println("Our final normal count  " + dmt.getCount().getNormalCount());
		
	}
}

