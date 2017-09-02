package com.java.cert.chapter9.Serialization;
/**************************************************************************
 * <b>Title:</b> Collar.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description:</b>
 * @author Devon Franklin
 * @version: 1.0
 * @since Feb 8, 2017
 ****************************************************/

public class Collar {
	
	private String color;
	private boolean hasNameSlot;
	
	/**
	 * 
	 * @param color
	 * @param hasNameSlot
	 */
	public Collar(String color, boolean hasNameSlot){
		this.color = color;
		this.setHasNameSlot(hasNameSlot);
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the hasNameSlot
	 */
	public boolean hasNameSlot() {
		return hasNameSlot;
	}
	/**
	 * @param hasNameSlot the hasNameSlot to set
	 */
	public void setHasNameSlot(boolean hasNameSlot) {
		this.hasNameSlot = hasNameSlot;
	}

}

