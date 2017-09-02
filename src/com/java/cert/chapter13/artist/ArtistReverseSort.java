package com.java.cert.chapter13.artist;

import java.util.Comparator;

/**************************************************************************
 * <b>Title:</b> ArtistComparator.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description: Compares Artist objects and sorts them accordingly</b>
 * @author Devon Franklin
 * @version: 1.0
 * @since Aug 12, 2017
 ****************************************************/

public class ArtistReverseSort implements Comparator<Artist> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Artist a1, Artist a2) {
		//safety check
		if(a1 == null || a2 == null){
			return 0;
		}
		
		return a2.getAlias().compareTo(a1.getAlias());
		
	}

}

