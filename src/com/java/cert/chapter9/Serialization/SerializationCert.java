package com.java.cert.chapter9.Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.java.cert.OCPInterface;

/**************************************************************************
 * <b>Title:</b> SerializationCert.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description: Demonstrates knowledge of serialization and 
 * it's underlying concepts</b>
 * @author Devon Franklin
 * @version: 1.0
 * @since Feb 8, 2017
 ****************************************************/

public class SerializationCert implements OCPInterface {

	private String serializeDir = "C:/Users/devon/workstation/java/serialize";
	
	/* (non-Javadoc)
	 * @see com.javaCert.certification.CertInterface#run()
	 */
	@Override
	public void executeLogic() {
		//create a collar
		Collar collar = new Collar("red", true);
		
		//create a catdog and give it the collar
		CatDog catDog = new CatDog("Samuel", 5, collar);
		System.out.println("CatDog name before: " + catDog.name);
		System.out.println("CatDog age before: " + catDog.age);
		System.out.println("CatDog collar color before: " + collar.getColor());
		
		ObjectOutputStream os = null;
		ObjectInputStream ois = null;
		try {//serialize the object	
			FileOutputStream fs = new FileOutputStream(serializeDir + "catDog.ser");
			os = new ObjectOutputStream(fs);
			os.writeObject(catDog);
			
			//de-serialize the object
			FileInputStream fis = new FileInputStream(serializeDir + "catDog.ser");
			ois = new ObjectInputStream(fis);
			CatDog deserializedCatDog = (CatDog) ois.readObject();
		
			//Read values after deserialization
			System.out.println("CatDog name after: " + deserializedCatDog.name);
			System.out.println("CatDog age after: " + deserializedCatDog.age);
			Collar collar2 = deserializedCatDog.getCollar();
			if( collar2 != null){
				System.out.println("CatDog collar color after: " + collar2.getColor());
			}else{
				System.out.println("Deserialized collar is null");
			}
		} catch (Exception e) {
			System.err.println("Error attempting to serialize object " + e);
		}finally{
			if(os != null || ois != null){
				try {//clean up
					os.close();
					ois.close();
				} catch (IOException e) { /*nothing can be done, ignore */}
			}
		}

	}
	
	/**
	 * Main method useful for testing and debugging
	 * @param args
	 */
	public static void main(String... args){
		SerializationCert sc = new SerializationCert();
		sc.executeLogic();
	}
	
}

