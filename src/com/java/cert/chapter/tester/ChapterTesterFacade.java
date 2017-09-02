package com.java.cert.chapter.tester;
/**************************************************************************
 * <b>Title:</b> ChapterTesterFacade.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description:</b>
 * @author Devon Franklin
 * @version: 1.0
 * @since Aug 12, 2017
 ****************************************************/

public class ChapterTesterFacade {

	/**
	 * Dynamically loads the appropriate tester class and executes it's test code
	 * @param testerName
	 * @throws Exception
	 */
	public void runTester(String testerName) throws Exception{
		
		//initialize the appropriate tester class
		
		//run the tester
	}
	
	
	/**
	 * Main method useful for testing and debugging
	 * @param args
	 */
	public static void main(String[] args){
		ChapterTesterFacade ctf = new ChapterTesterFacade();
		
		//get the class to run from the passed argument
		

		try {
			//Call the appropriate tester class
			//ctf.runTester();
		} catch (Exception e) {
			System.err.println("Error attempting to execute chapter knowledge: " + e);
		}
	}

}

