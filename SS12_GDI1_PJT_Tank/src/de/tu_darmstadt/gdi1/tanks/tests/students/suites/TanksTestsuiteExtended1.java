package de.tu_darmstadt.gdi1.tanks.tests.students.suites;

import de.tu_darmstadt.gdi1.tanks.tests.students.testcases.HighscoreTest;
import de.tu_darmstadt.gdi1.tanks.tests.students.testcases.LoadGameTest;
import de.tu_darmstadt.gdi1.tanks.tests.students.testcases.ParseMapExtended1;
import de.tu_darmstadt.gdi1.tanks.tests.students.testcases.SaveGameTest;
import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;

public class TanksTestsuiteExtended1 {
	
	public static Test suite() {
		
		TestSuite suite = new TestSuite("Student tests for Tanks - Extended 1");
		suite.addTest(new JUnit4TestAdapter(HighscoreTest.class));
		suite.addTest(new JUnit4TestAdapter(LoadGameTest.class));
		suite.addTest(new JUnit4TestAdapter(SaveGameTest.class));
		suite.addTest(new JUnit4TestAdapter(ParseMapExtended1.class));
		return suite;
	}
	
}
