package com.java.cert.chapter13.artist;
/**************************************************************************
 * <b>Title:</b> ArtistThreadRunner.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description:</b>
 * @author Devon Franklin
 * @version: 1.0
 * @since Aug 13, 2017
 ****************************************************/

public class ArtistThreadRunner {
	
	public static void main(String[] args){
		//create our task to run
		ArtistLineUp lineUp = new ArtistLineUp();
		
		//create a couple of threads
		Thread t1 = new Thread(lineUp);
		Thread t2 = new Thread(lineUp);
		t1.setName("ThreadOne");
		t2.setName("ThreadTwo");
				
		//start our threads
		t2.start();
		
		//force first thread to wait until the second completes
		try {
			t2.join();
		} catch (InterruptedException e) {
			System.err.println("Thread was interrupted: " + e);
		}
		t1.start();
		
	}
}

