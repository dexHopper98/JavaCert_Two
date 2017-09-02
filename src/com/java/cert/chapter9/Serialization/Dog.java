package com.java.cert.chapter9.Serialization;
/**************************************************************************
 * <b>Title:</b> Dog.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description:</b>
 * @author Devon Franklin
 * @version: 1.0
 * @since Feb 8, 2017
 ****************************************************/

/*
 * Helps demonstrate the serialization and inheritance. Its important
 * to keep the following points in mind.
 * 1)The super class does NOT have to implement serializable but sub-class can
 * 2)However if superclass does not, it's constructor will be invoked
 * 3)When it's constructor is invoked it's member variables get their declare initialization values
 *   versus their default values
 * 4)Each of the subclasses' super classes' constructors will be invoked all the way up the inheritance tree
 * 5)If the super class does not implement Serializable, and the sub class does, then any inherited member
 *    variables from the super class WIILL be reset to their initial values(or declared values if set in superclass).
 *    This is because, again, the super class constructor runs, and when it runs all member variables receive
 *    their default values for it's data type.
 * 6)If the super class does implement Serializable then all of it's sub-classes also are serializable
 */
public class Dog {

	protected String name = "fido";
	protected int age = 1;
	
	public Dog(){
		//default constructor
	}
}

