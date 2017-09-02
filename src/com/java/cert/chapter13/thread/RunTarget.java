package com.java.cert.chapter13.thread;
/**************************************************************************
 * <b>Title:</b> RunTarget.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description: A custom thread class that helps 
 * demonstrate threads</b>
 * <b>Copyright:</b>Copyright (c) 2016
 * @author Devon Franklin
 * @since Aug 15, 2016 2016
 ****************************************************/

public class RunTarget implements Runnable{

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		//Our job code to be ran
		Thread current = Thread.currentThread();
		for(int x = 0; x < 100; x++){
			System.out.println("The current loop count " + x);
			if(x % 10 == 0){
				System.out.println("Attempting to pause the executing thread of: " + current.getName());
				System.out.println("This threads priority is: " + current.getPriority());
				try {
					Thread.sleep(5  * 1000);//Tell our thread to sleep
				} catch (InterruptedException e) {
					System.out.println("Error attempting to pause the executing thread " + e);
				}
			}
		}
	}

}

