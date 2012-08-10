package de.tu_darmstadt.gdi1.tanks.tests.students.suites;

import de.tu_darmstadt.gdi1.tanks.tests.students.testcases.MultiplayerTest;
import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;

public class TanksTestsuiteExtended3 {
	
	public static Test suite() {
		
		TestSuite suite = new TestSuite("Student tests for Tanks - Extended 3");
		suite.addTest(new JUnit4TestAdapter(MultiplayerTest.class));
		return suite;
	}
	
}
