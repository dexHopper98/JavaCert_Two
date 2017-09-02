package com.java.cert.chapter9.Serialization;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**************************************************************************
 * <b>Title:</b> CatDog.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description:</b>
 * @author Devon Franklin
 * @version: 1.0
 * @since Feb 8, 2017
 ****************************************************/

/*
 * Class extends a non-serializable super class while implementing Serializable itself. 
 * Also has-a object reference to a class that is also not serializable.
 */
public class CatDog extends Dog implements Serializable{

	private static final long serialVersionUID = 3134299151359613500L;
	
	final protected String name;
	public static String BARK = "bark"; //static variables are NOT serialized
	/*mark transient to skip serialization. Variables marked transient will not be
	serialized, however when this CatDog object is deserialized its transient values
	will be restored back to it's initial default value, in this case null. */
	private transient Collar theCollar = new Collar("black", false); 
	
	/**
	 * No arg constructor
	 */
	public CatDog(String name, int age, Collar collar){
		this.name = name; //overriden inherited variable
		this.age = age; //inherited
		this.theCollar = collar;
	}
	
	public Collar getCollar(){
		return this.theCollar;
	}
	public void setCollar(Collar collar){
		this.theCollar = collar;
	}
	
	/*====Override the "secret" methods from the Serializable interface===
	 * When overriding these methods the ordering of custom serialization and 
	 * java normal serialization is important! If writing custom serialization first,
	 * must read back custom serialization first, and vice versa.
	 * */
	
	private void writeObject(ObjectOutputStream os) throws Exception{
		//write out custom serialization
		os.writeBoolean(theCollar.hasNameSlot());
		
		//continue with normal serialization
		os.defaultWriteObject();
	}
	
	private void readObject(ObjectInputStream ois) throws Exception{
		//read back custom deserialization
		theCollar = new Collar("black", ois.readBoolean());
		
		//continue with normal deserialization
		ois.readObject();
	}
}

