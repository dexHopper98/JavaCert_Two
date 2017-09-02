package com.java.cert.chapter14.atomic;
/**************************************************************************
 * <b>Title:</b> IncrementerThread.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description:</b>
 * @author Devon Franklin
 * @version: 1.0
 * @since Aug 20, 2017
 ****************************************************/

public class IncrementerThread extends Thread {
	//member variables
	private Counter counter;
	
	/**
	 * Constructor for initialization 
	 * @param counter
	 */
	public IncrementerThread(Counter counter){
		this.setCounter(counter);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run(){
		if (counter == null) {
			return; //no work to do
		}
		
		for (int i = 0; i < 1000; i++) {
			counter.atomicIncrement();
			/*The following is not thread safe due to the natural of the non-atomic increment(++) action
			 * Image this scenario: Two threads are looping 1000 times each
			 * Thread 1: Increments value up 500, then attempts to increment again, it copies original value(500) 
			 * to a temporary value then increments the temp to 501, but before it can copy it back to original value, 
			 * Thread 2 steps in. It increments the current value(500) all the way up to 805. Then allows Thread 1 to 
			 * continue, Thread 1 now resumes, the current value is now 805, but Thread 1 proceeds to copy 501 
			 * into the original value reducing, not increasing, the current value. Polluting our final count. */
			counter.normalIncrement();
		} 
	}

	/**
	 * @return the counter
	 */
	public Counter getCounter() {
		return counter;
	}

	/**
	 * @param counter the counter to set
	 */
	public void setCounter(Counter counter) {
		this.counter = counter;
	}
}

