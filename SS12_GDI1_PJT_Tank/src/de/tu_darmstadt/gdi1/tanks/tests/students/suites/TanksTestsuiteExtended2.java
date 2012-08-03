package de.tu_darmstadt.gdi1.tanks.tests.students.suites;

import de.tu_darmstadt.gdi1.tanks.tests.students.testcases.LimitedAmmoTest;
import de.tu_darmstadt.gdi1.tanks.tests.students.testcases.ParseMapExtended2;
import de.tu_darmstadt.gdi1.tanks.tests.students.testcases.TimeLimitTest;
import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;

public class TanksTestsuiteExtended2 {
	
	public static Test suite() {
		
		TestSuite suite = new TestSuite("Student tests for Tanks - Extended 2");
		suite.addTest(new JUnit4TestAdapter(ParseMapExtended2.class));
		suite.addTest(new JUnit4TestAdapter(TimeLimitTest.class));
		suite.addTest(new JUnit4TestAdapter(LimitedAmmoTest.class));
		return suite;
	}
	
}
