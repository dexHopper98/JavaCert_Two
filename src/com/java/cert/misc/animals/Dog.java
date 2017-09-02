package com.java.cert.misc.animals;
/**************************************************************************
 * <b>Title:</b> Dog.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description: The object representation of a Dog</b>
 * @author Devon Franklin
 * @version: 1.0
 * @since Jun 6, 2017
 ****************************************************/

public class Dog implements Animal {

	//member variables
	private String name;
	private int age;
	private Breed breed;
	
	public enum Breed{
		PITBULL, BOSTON_TERRIER, PUG, HUSKY
	}
	
	/**
	 * No-arg constructor
	 */
	public Dog(){
		//implemented for default construction
	}
	/**
	 * Constructor for initialization 
	 * @param name
	 * @param age
	 * @param breed
	 */
	public Dog(String name, int age, Breed breed){
		this.name = name;
		this.age = age;
		this.breed = breed;
	}
	
	/* (non-Javadoc)
	 * @see com.java.cert.misc.animals.Animal#eat()
	 */
	@Override
	public void eat() {
		System.out.println("Munch munch munch....(all full)");
	}

	/* (non-Javadoc)
	 * @see com.java.cert.misc.animals.Animal#speak()
	 */
	@Override
	public void speak() {
		System.out.println("Woof woof!");
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
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the breed
	 */
	public Breed getBreed() {
		return breed;
	}

	/**
	 * @param breed the breed to set
	 */
	public void setBreed(Breed breed) {
		this.breed = breed;
	}

}

