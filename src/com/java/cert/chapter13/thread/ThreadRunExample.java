package com.java.cert.chapter13.thread;
/**************************************************************************
 * <b>Title:</b> ThreadRunExample.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description: The executable class that will run an example of threads.</b>
 * <b>Copyright:</b>Copyright (c) 2016
 * @author Devon Franklin
 * @since Aug 15, 2016 2016
 ****************************************************/

public class ThreadRunExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Starting the thread run example");
		//Have a separate thread of execution running
		RunTarget rt = new RunTarget();
		Thread t = new Thread(rt, "The First Avenger");
		Thread t2 = new Thread(rt, "Beast Boy");
		Thread t3 = new Thread(rt, "The Last Avenger");
		
		//Start our threads
		t.start();
		t2.start();
		t3.start();
	}
}

