package com.java.cert.chapter11;

//jdk 1.7
import java.util.ArrayList;
import java.util.List;




import com.java.cert.misc.animals.Dog;
import com.java.cert.misc.animals.Dog.Breed;
//cert libs
import com.java.cert.misc.plant.Plant;

/**************************************************************************
 * <b>Title:</b> OldSchoolGenerics.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description: Demonstrates the pre java 5(old school) using generics</b>
 * @author Devon Franklin
 * @version: 1.0
 * @since Jun 4, 2017
 ****************************************************/

/*
 * A one-off class type
 */
public class OldSchoolGenerics {

	//member variables
	@SuppressWarnings("rawtypes")
	private List intBucket;
	
	/**
	 * No arg constructor
	 */
	@SuppressWarnings("rawtypes")
	public OldSchoolGenerics(){
		intBucket = new ArrayList();
	}
	
	/**
	 * Ruins the supposed collection of Integers by placing
	 * other objects(besides Integers) inside of it
	 */
	@SuppressWarnings("unchecked")
	public void ruinTheCollection(){
		intBucket.add(42); //autoboxing in the house
		intBucket.add(new Integer(52)); //add another int
		intBucket.add(100); //yet another
		intBucket.add("82"); //wait what??
		intBucket.add(new Plant());//come on now, that doesn't even make sense
		intBucket.add(8422);
	}
	
	/**
	 * Returns the collection of Integers(hopefully)
	 */
	@SuppressWarnings("rawtypes")
	public List getIntBucket(){
		return this.intBucket;
	}
	
	/**
	 * Returns back a List of Dogs...maybe.
	 * (Do you really want to trust this method? :)
	 * @param Dog
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List modifyDogs(List dogs){
		for (Object object : dogs) {
			if(object instanceof Dog){
				Dog d = (Dog) object;
				//provide each dog with a bad-ass name
				if(d.getName() == null || d.getName().length() == 0){
					d.setName("killer");
					d.setAge(3);
					d.setBreed(Breed.PUG);
				}
			}
			//throw in a random object or two
			dogs.add(new String("I am a dog"));
			dogs.add(new Integer(45));
		}
		return dogs;
	}
		
	/**
	 * Main method useful for testing/debugging
	 * @param args
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		OldSchoolGenerics og = new OldSchoolGenerics();
		og.ruinTheCollection(); //populate the collection
		
		//loop over and perform Integer specific logic
		int total = 0;
		List vals = og.getIntBucket();
		for (int i = 0; i < vals.size(); i++) {
			try{
				//foolishly assume all values are integers
				total += (Integer)vals.get(i);
				System.out.println("The total of values in collection: "+ total);
			}catch(Exception e){
				System.err.println("Silly programmer, non-generics are for kids");
			}
		}
	}

}

