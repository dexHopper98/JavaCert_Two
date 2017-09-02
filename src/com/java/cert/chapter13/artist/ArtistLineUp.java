package com.java.cert.chapter13.artist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**************************************************************************
 * <b>Title:</b> ArtistLineUp.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description: A unique task to be executed within a separate thread</b>
 * @author Devon Franklin
 * @version: 1.0
 * @since Aug 12, 2017
 ****************************************************/

public class ArtistLineUp implements Runnable {

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		//create a list of artist names
		List<Artist> musicArtist = populateArtistNames(true);
		
		for (Artist artist : musicArtist) {
			//allow thread to sleep 2 seconds between each  call
			System.out.println("Current thread, about to go to sleep: " + Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("artist name: " + artist.getAlias());
		}
	}
	
	/**
	 * Populates a list of artist, optionally reverse orders the listing
	 * @param reverseSort
	 * @return
	 */
	protected List<Artist> populateArtistNames(boolean reverseSort){
		List<Artist> artistNames = new ArrayList<>();
		
		//populate list
		artistNames.add(new Artist("Lil Wayne"));
		artistNames.add(new Artist("Jay-z"));
		artistNames.add(new Artist("Nas"));
		artistNames.add(new Artist("Tupac"));
		artistNames.add(new Artist("Biggie"));
		
		if(reverseSort)
			Collections.sort(artistNames, new ArtistReverseSort());
		
		return artistNames;
	}

}

