package com.java.cert.chapter.tester;

import com.java.cert.TesterInterface;
//cert libs
import com.java.cert.chapter11.AutoBoxing;

/**************************************************************************
 * <b>Title:</b> Chapter11Tester.java
 * <b>Project:</b>JavaCertSandbox
 * <b>Description: Demonstrates general knowledge gained 
 * throughout chapter 11</b>
 * @author Devon Franklin
 * @version: 1.0
 * @since Mar 5, 2017
 ****************************************************/

public class Chapter11Tester implements TesterInterface {

	/* (non-Javadoc)
	 * @see com.java.cert.chapter.testers.ChapterTester#testChapterKnowledge()
	 */
	@Override
	public void runTest() throws Exception {
		//test knowledge for auto-boxing
		AutoBoxing auto = new AutoBoxing();
		auto.executeLogic();
	}

}

