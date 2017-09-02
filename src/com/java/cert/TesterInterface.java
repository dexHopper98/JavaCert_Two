package com.java.cert;
/**************************************************************************
 * <b>Title:</b> TesterInterface.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description: Defines the common contract for implementing
 *  classes to abide by. </b>
 * @author Devon Franklin
 * @version: 1.0
 * @since Mar 5, 2017
 ****************************************************/

public interface TesterInterface {
	
	/**
	 * Should be used in  implementing classes to demonstrate the chapter
	 * in question, overall knowledge of concepts presented.
	 * @throws Exception
	 */
	public abstract void runTest() throws Exception;
}

