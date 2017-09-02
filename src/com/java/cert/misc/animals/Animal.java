package com.java.cert.misc.animals;
/**************************************************************************
 * <b>Title:</b> Animal.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description: The base definition of what an Animal is and does</b>
 * @author Devon Franklin
 * @version: 1.0
 * @since Jun 5, 2017
 ****************************************************/

public interface Animal {
	
	/**
	 * The process/logic and which an animal eats
	 */
	public abstract void eat();
	
	/**
	 * The process/logic in which an animal talks/communicates
	 */
	public abstract void speak();
}

