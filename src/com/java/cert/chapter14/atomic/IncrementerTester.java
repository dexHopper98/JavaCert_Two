package com.java.cert.chapter14.atomic;
/**************************************************************************
 * <b>Title:</b> IncrementerTester.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description:</b>
 * @author Devon Franklin
 * @version: 1.0
 * @since Aug 20, 2017
 ****************************************************/

public class IncrementerTester {

	public static void main(String[] args){
		//create a share resource
		Counter counter = new Counter();
		//create several threads
		IncrementerThread t1 = new IncrementerThread(counter);
		IncrementerThread t2 = new IncrementerThread(counter);
		t1.setName("ThreadOne");
		t2.setName("ThreadTwo");
		
		//start the threads
		t1.start();
		t2.start();
		
		//allow this thread(main) to wait for the other threads to complete
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			System.err.println("Error attempting to join to other thread: " + e);
		}

		//log our final count
		System.out.println("Our final normal count is: " + counter.getNormalCount());
		System.out.println("Our final atomic count is: " + counter.getAtomicCount());
	}
}

