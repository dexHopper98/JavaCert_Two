package com.java.cert.chapter11;

import java.util.Date;

/**************************************************************************
 * <b>Title:</b> ComparableBook.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description: A book object that implements comparable(I.E normally you need not reference
 * that object itself is comparable in the name)</b>
 * @author Devon Franklin
 * @version: 1.0
 * @since Mar 5, 2017
 ****************************************************/

public class ComparableBook implements Comparable<ComparableBook> {

	//member variables
	private String title;
	private String author;
	private Date releaseDate;
	
	/**
	 * No arg constructor for initialization 
	 */
	public ComparableBook(){
		super();
	}
	
	/**
	 * Constructor to initialize member variables
	 * @param title
	 * @param author
	 * @param releaseDate
	 */
	public ComparableBook(String title, String author, Date releaseDate){
		this();
		this.title = title;
		this.author = author;
		this.releaseDate = releaseDate;
	}
	
	/*Overrides the required method from Comparable Interface. 
	 * Allows two ComparableBook instances to be compared to each
	 * for sorting. 
	 * Key: 
	 * Negative number: thisObject < passedObject
	 * Zero number: thisObject == passedObject
	 * Positive number: thisObject > passedObject
	 * */
	@Override
	public int compareTo(ComparableBook book) {
		//safety check. If null return and assume thisObject is greater
		if(book == null) return 1;
		
		//compare titles, since String objects just use it's version of compareTo
		return this.title.compareTo(book.getTitle());
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the releaseDate
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
}

