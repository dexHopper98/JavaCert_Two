package com.java.cert.chapter14.locks;
//concurrent libs
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**************************************************************************
 * <b>Title:</b> LockTester.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description: Tester class to help demonstrate use of 
 * java.util.concurrent.lock package locking behavior</b>
 * @author Devon Franklin
 * @version: 1.0
 * @since Sep 2, 2017
 ****************************************************/

public class LockTester {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LockTester lt = new LockTester();
		lt.testLocking();
	}
	
	/**
	 * Tester method for concurrent package locking
	 */
	protected void testLocking(){
		//create our runnable task to be ran
		Runnable task = fetchRunnableTask();
		
		//create several threads
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		t1.setName("Rebecca");
		t2.setName("Alfred");
		
		//start our threads
		t1.start();
		t2.start();
	}
	
	/**
	 * Creates our Runnable implementation with the task to be performed
	 * @return
	 */
	protected Runnable fetchRunnableTask(){
		Runnable runnable = new Runnable(){
			
			private final Lock uniqueLock = new ReentrantLock();

			public void run(){				
				//Attempt to acquire the lock
				boolean haveLock = false;
				String threadNm = Thread.currentThread().getName();
				try {
					haveLock = uniqueLock.tryLock(3, TimeUnit.SECONDS);
					
					if(haveLock){
						System.out.println("Task being executed by: " + threadNm);
						
						//force the current to sleep for longer than 3 seconds
						Thread.sleep(5000);
					}else{
						System.out.println("Failed to acquire lock. Thread name: " + threadNm);
					}
				} catch (InterruptedException e) {
					System.err.println("Error attempting to wait to acquire lock: " + e);
				}finally{
					if(haveLock){
						uniqueLock.unlock();
						System.out.println("Lock released by Thread: " + threadNm);
					}
				}			
			}
		};// end class declaration
		
		return runnable;
	}

}

