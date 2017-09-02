package com.java.cert.chapter13.artist;
/**************************************************************************
 * <b>Title:</b> Artist.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description:</b>
 * @author Devon Franklin
 * @version: 1.0
 * @since Aug 12, 2017
 ****************************************************/

public class Artist {
	
	public enum Genre{
		HIP_HOP, RNB, SOUL, ROCK, POP, COUNTRY
	}
	
	//member variables
	private String name;
	private String alias;
	private Genre genre;
	
	/**
	 * 
	 * @param alias
	 */
	public Artist(String alias){
		this.alias = alias;
	}
	/**
	 * 
	 * @param name
	 * @param alias
	 * @param genre
	 */
	public Artist(String name, String alias, Genre genre){
		this.name = name;
		this.alias = alias;
		this.genre = genre;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * @return the genre
	 */
	public Genre getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
}

