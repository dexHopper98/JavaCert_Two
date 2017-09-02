package com.java.cert.chapter14.locks;

import java.util.concurrent.locks.ReentrantLock;

import com.java.cert.chapter14.atomic.Counter;

/**************************************************************************
 * <b>Title:</b> Decrementer.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description: Our runnable that demonstrates decrementing our
 * Counter object in both a thread-safe and non-thread safe fashion</b>
 * @author Devon Franklin
 * @version: 1.0
 * @since Aug 24, 2017
 ****************************************************/

public class Decrementer implements Runnable {
	private Counter count;
	private final ReentrantLock lock = new ReentrantLock(); //our one and only lock!!
	private boolean isDecrementSafetly = Boolean.TRUE;//set to false to override(at your own risk :)
	private boolean isDecrementWithLock = Boolean.FALSE; //set to allow threads to take turns
	
	/**
	 * 
	 * @param isDecrementSafetly
	 */
	public Decrementer(){
		this.count = new Counter(1000);
	}
	
	/**
	 * Loops 100 times and decrements 
	 */
	@Override
	public void run(){
		if(isDecrementWithLock){
			decrementReentrantLock();
		}else if(isDecrementSafetly){
			decrementSafetly();
		}else{
			decrementRisky();
		}
	}
	
	protected void decrementSafetly(){
		//decrement until we reach zero
		for (int i = 0; i < 1000; i++) {
			count.atomicDecrement();
		}
	}
	
	protected void decrementRisky(){
		//decrement until we reach zero
		for (int i = 0; i < 1000; i++) {
			count.normalDecrement();
		}
	}
	
	/**
	 * Decrements down but forces Threads to obtain lock before
	 * another Thread can take over
	 */
	protected void decrementReentrantLock(){
		//force the thread to obtain a lock before working
		lock.lock();
		
		try{
			//decrement until we reach zero
			for (int i = 0; i < 1000; i++) {
				count.normalDecrement();
			}		
			//print out our final count
			System.out.println("Our final normal count with lock: " + count.getNormalCount());
			System.out.println("Printed by: " + Thread.currentThread().getName());
		}finally{
			lock.unlock(); //ensure we release our lock
		}
		
	}

	/**
	 * @return the isDecrementSafetly
	 */
	public boolean isDecrementSafetly() {
		return isDecrementSafetly;
	}

	/**
	 * @param isDecrementSafetly the isDecrementSafetly to set
	 */
	public void setDecrementSafetly(boolean isDecrementSafetly) {
		this.isDecrementSafetly = isDecrementSafetly;
	}

	/**
	 * @return the isDecrementWithLock
	 */
	public boolean isDecrementWithLock() {
		return isDecrementWithLock;
	}

	/**
	 * @param isDecrementWithLock the isDecrementWithLock to set
	 */
	public void setDecrementWithLock(boolean isDecrementWithLock) {
		this.isDecrementWithLock = isDecrementWithLock;
	}

	/**
	 * @return the count
	 */
	public Counter getCount() {
		return count;
	}

}

