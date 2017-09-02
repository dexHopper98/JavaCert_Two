package com.java.cert.chapter9;

//NIO.2
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;



//certification libs


import com.java.cert.OCPInterface;

/**************************************************************************
 * <b>Title:</b> PathCert.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description: Class helps demonstrate knowledge and 
 * understanding of NIO.2 concepts. These include Path, Paths, Files
 * DirectoryStream, PathMatcher and more. </b>
 * @author Devon Franklin
 * @version: 1.0
 * @since Jan 22, 2017
 ****************************************************/

public class PathCert implements OCPInterface{

	/*
	 * Here to demonstrate the difference between operating systems and their file systems.
	 * Windows uses "\" to denote directories
	 * Unix/Linux uses "/" to denote directories
	 * When dealing with window system paths have to escape with a extra backslash
	 * Note: UNIX paths typically work on both OS. So it is good practice to use as a general usage.
	 */
	private static final String WINDOWS_HOME_PATH = "C:\\Users\\devon\\";
	private static final String UNIX_HOME_PATH = "C:/Users/devon/";
	
	/* (non-Javadoc)
	 * @see com.javaCert.certification.CertInterface#run()
	 */
	@Override
	public void executeLogic() {
		testManipulatePaths();
		
		try {
			pathBasics();
		} catch (IOException e) {
			System.err.println("Error attempting to complete path basics method: " + e);
		}
	}
	
	/**
	 * Test knowledge of manipulating path locations. Resolving, normalizing,
	 * and relativizing these paths. 
	 * NOTE: All of these methods do NOT actually check 
	 * if the files actually exist on the file system.
	 */
	private void testManipulatePaths(){
		//normalize a path(removes the unnecessary parts of a path)
		Path orgPath = Paths.get(WINDOWS_HOME_PATH + "documents\\users", "..\\..\\", "sample.text");
		Path normalizePath = orgPath.normalize();
		System.out.println("The original path: " + orgPath);
		System.out.println("The normalized path: " + normalizePath);
		
		//resolve a path(combines multiple paths)
		Path absolute  = Paths.get(UNIX_HOME_PATH, "documents/");
		Path relative = Paths.get("dir");
		Path file = Paths.get("sample.txt");
		System.out.println();System.out.println("Resolving Paths...");
		System.out.println("1: " + absolute.resolve(relative));
		System.out.println("2: " + absolute.resolve(file));
		System.out.println("3: " + relative.resolve(file));
		System.out.println("4: " + relative.resolve(absolute)); //BAD
		System.out.println("5: " + file.resolve(absolute)); //BAD
		System.out.println("6: " + file.resolve(relative)); //BAD
		
		//relativize a path(opposite of resolve. Show me a path from path1 to path2)
		System.out.println();System.out.println("Relativizling Paths...");
		Path absolute2 = Paths.get(UNIX_HOME_PATH, "documents/");
		Path absolute3 = Paths.get(UNIX_HOME_PATH, "documents/sample/music.pdf");
		Path relative2 = Paths.get("documents/sample/");
		Path file2 = Paths.get("music.pdf");
		Path relative3 = Paths.get("documents/sample/test.pdf");
		
		/*When it can't tell the paths similarities, it will either assume to go all the up from
		 * the path that was passed to the relativized path(#2, #4). Or it throw an error(#6)*/
		System.out.println("1: " + absolute2.relativize(absolute3));
		System.out.println("2: " + relative2.relativize(file2));
		System.out.println("3: " + absolute3.relativize(absolute2));
		System.out.println("4: " + file.relativize(relative2));
		System.out.println("5: " + relative2.relativize(relative3));
		// System.out.println("6: " + absolute.relativize(file2)); BAD not enough info to go off of
	}
	
	/**
	 * Test basic knowledge of creating files and directories using NIO.2
	 * @throws IOException 
	 */
	private void pathBasics() throws IOException{
		String testDirectory = "workstation/java/test/";
		//Create multiple directories
		Path dir1 = Paths.get(UNIX_HOME_PATH + testDirectory + "first/");
		Files.createDirectories(dir1);
		Path dir2 = Paths.get(UNIX_HOME_PATH + testDirectory + "second/");
		if(!Files.exists(dir2)) Files.createDirectory(dir2);
		
		//Place two new files inside each directory
		String fileOne = "/sample.txt";
		String fileTwo = "/other.txt";
		Path file1 = Paths.get(dir1 + fileOne );
		Path file2 = Paths.get(dir1 + fileTwo);
		Path file3 = Paths.get(dir2 + fileOne);
		Path file4 = Paths.get(dir2 + fileTwo);
		
		createIfNotExist(file1);
		createIfNotExist(file2);
		createIfNotExist(file3);
		createIfNotExist(file4);
		
		//Copy a file 
		Path source = Paths.get(dir1 + "/source.txt");
		List<String> lines = Arrays.asList("Sample test data.", "More test data.");
		Files.write(source, lines, Charset.forName("UTF-8"));//will create the file if it doesn't exist
		Path target = Paths.get(dir2 + "/target.txt");
		Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
		
		//Move a file
		Path moveLocation = Paths.get(dir2 + "/movedFile.txt");
		Files.move(source, moveLocation, StandardCopyOption.REPLACE_EXISTING);
		
		//Delete a file from directory One
		Files.deleteIfExists(file1);
		
		System.out.println("Completed path basics!"); System.out.println();
	}
	
	/**
	 * Attempts to create a file, or directory, if doesn't already exist. If file is
	 * created true value is returned. False otherwise.
	 * @param file
	 * @return - Returns true if the file did not already exist.
	 */
	private boolean createIfNotExist(Path file){
		boolean created = false;
		if(!Files.exists(file)){
			try {//create the file or directory
				Files.createFile(file);
				created = true;
			} catch (IOException e) {
				System.err.println("Error occured attempting to create file: " + e);
			}
		}
		return created;
	}
	
	/**
	 * Main method to help test code.
	 * @param args
	 */
	public static void main(String[] args){
		PathCert pc = new PathCert();
		pc.executeLogic();
	}
}

