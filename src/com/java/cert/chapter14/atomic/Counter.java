package com.java.cert.chapter14.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**************************************************************************
 * <b>Title:</b> Counter.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description: Performs the job of incrementing/decrementing 
 * a counter value in both a normal and thread-safe manner.</b>
 * @author Devon Franklin
 * @version: 1.0
 * @since Aug 20, 2017
 ****************************************************/

public class Counter {
	//member variables
	private AtomicInteger atomicCount;
	private int normalCount;
	
	/**
	 * 
	 */
	public Counter(){
		this.atomicCount = new AtomicInteger(0);
	}
	
	/**
	 * 
	 * @param initialVal
	 */
	public Counter(int initialVal){
		this.atomicCount = new AtomicInteger(initialVal);
		this.normalCount = initialVal;
	}
	
	public void atomicIncrement(){		
		//instead use an atomic integer
		atomicCount.incrementAndGet();
	}
	
	public void normalIncrement(){
		normalCount++; //Caution! More steps than you believe.
	}
	
	public void atomicDecrement(){
		atomicCount.decrementAndGet();
	}
	
	public void normalDecrement(){
		normalCount--;//Caution! More steps than you believe.
	}

	/**
	 * 
	 * @return
	 */
	public int getAtomicCount(){
		return atomicCount.get();
	}
	
	/**
	 * @return the normalCount
	 */
	public int getNormalCount() {
		return normalCount;
	}
	
}

