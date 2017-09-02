package com.java.cert.chapter11;

//cert libs
import com.java.cert.OCPInterface;

/**************************************************************************
 * <b>Title:</b> AutoBoxing.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description:</b>
 * @author Devon Franklin
 * @version: 1.0
 * @since Mar 5, 2017
 ****************************************************/

public class AutoBoxing implements OCPInterface {

	/* (non-Javadoc)
	 * @see com.java.cert.certification.OCPInterface#executeLogic()
	 */
	@Override
	public void executeLogic() {
		System.out.println("Demonstrating autoboxing demo....");
		autoBoxingDemo();
		
	}
	
	/**
	 * Demonstrates AutoBoxing referring to the wrapper classes.
	 * Includes the "gotcha" of ==, !=, and equals() when being used
	 * with AutoBoxing.
	 */
	private void autoBoxingDemo(){
		//Create two wrapper classes 
		Double d1 = new Double(15.0);
		Double d2 = new Double(15.0);
		
		//compare them using != and equals
		System.out.println("Values being used: " + d1 + " and " + d2 );
		if(d1 != d2) System.out.println("The objects are different!");
		if(d1.equals(d2)) System.out.println("The objects are meaningfully the same! ");
		
		/*Create two wrapper classes of one of the 
		 * following types: Boolean, Byte, Char, Short, Integer*/
		Integer i1 = 10;
		Integer i2 = 10;
		
		/*next compare them using == and equals. Notice that values
		  * will be consider "object" equals due to wrapper classes attempting
		  * to preserve memory. */
		System.out.println("Values being used: " + i1 + " and " + i2 );
		if(i1 == i2) System.out.println("The objects are the same!");
		if(d1.equals(d2)) System.out.println("The objects are meaningfully the same! ");
		
	}

}

