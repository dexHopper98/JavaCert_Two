package com.java.cert.misc.plant;
/**************************************************************************
 * <b>Title:</b> Flower.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description:</b>
 * @author Devon Franklin
 * @version: 1.0
 * @since Dec 13, 2016
 ****************************************************/

public class Flower extends Plant{

	/**
	 * Example of convariant overriding of method but with a sub-type
	 */
	public Tulip getType(){
		return new Tulip();
	}
}

