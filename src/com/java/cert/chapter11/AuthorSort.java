package com.java.cert.chapter11;

import java.util.Comparator;

/**************************************************************************
 * <b>Title:</b> AuthorSort.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description: A comparator that compares two books based
 * on their authors. Useful during sorting within collections</b>
 * @author Devon Franklin
 * @version: 1.0
 * @since Mar 5, 2017
 ****************************************************/

public class AuthorSort implements Comparator<ComparableBook> {

	/**
	 * An overriden version of the compare(). Returns the int representing
	 * the result after comparing two Book objects. The key for int value
	 * is same as Comparable compareTo int value. 
	 */
	@Override
	public int compare(ComparableBook cb1, ComparableBook cb2) {
		//safety check
		if(cb1 == null || cb2 == null){
			return  -1;  //cannot determine so return a default
		}
		
		//compare the authors
		return cb1.getAuthor().compareTo(cb2.getAuthor());
	}

}

