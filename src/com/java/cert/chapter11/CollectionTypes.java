package com.java.cert.chapter11;

//jdk 1.7
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

//cert libs

import com.java.cert.OCPInterface;

/**************************************************************************
 * <b>Title:</b> CollectionTypes.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description: Demonstrates OCP certification knowledge for 
 * collections. This class focuses on the high level view of the 4
 * collection types and underlying concepts.</b>
 * @author Devon Franklin
 * @version: 1.0
 * @since Mar 5, 2017
 ****************************************************/

public class CollectionTypes implements OCPInterface {

	/* (non-Javadoc)
	 * @see com.java.cert.certification.OCPInterface#executeLogic()
	 */
	@Override
	public void executeLogic() {
		setDemo();
	}
	
	/**
	 * Demonstrates the various implementations of Set interface. 
	 * Note: Sets care about uniqueness
	 */
	protected void setDemo(){
		//create and use a HashSet
		HashSet<String> jobs = new HashSet<>();
		jobs.add("lawyer");
		jobs.add("doctor");
		jobs.add(null); //add a null
		jobs.add("artist");
		jobs.add("lawyer");
		//print out what we have in our set
		//Note: order is determined by hashcode here
		for (String j : jobs) {
			System.out.println("Set item: " +  j);
		}
		System.out.println("");//print out space between each listing
		
		//create and use a LinkedHashSet
		LinkedHashSet<String> jobsLinked = new LinkedHashSet<>();
		jobsLinked.add("lawyer");
		jobsLinked.add("doctor");
		jobsLinked.add(null); //add a null
		jobsLinked.add("artist");
		jobsLinked.add("lawyer");
		//print out what we have in our set
		//Note: order is determined by insertion here
		for (String j : jobsLinked) {
			System.out.println("LinkedSet item: " +  j);
		}
		System.out.println("");//print out space between each listing
		
		//create and use a TreeSet
		TreeSet<String> jobsTree = new TreeSet<>();
		jobsTree.add("lawyer");
		jobsTree.add("doctor");
		//jobsTree.add(null); //ERROR: cannot add nulls
		jobsTree.add("artist");
		jobsTree.add("lawyer");
		//print out what we have in our set
		//Note: order is determined by "natural order" here
		for (String j : jobsTree) {
			System.out.println("Set item: " +  j);
		}
		System.out.println("");//print out space between each listing
	}
	
	public static void main(String[] args){
		CollectionTypes colTypes = new CollectionTypes();
		colTypes.executeLogic();
	}
}

