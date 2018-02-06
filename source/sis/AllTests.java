package sis;

import junit.framework.TestSuite;
import sis.studentinfo.*;
import sis.report.RosterReporterTest;

public class AllTests {
    public static TestSuite suite() {
	TestSuite suite = new TestSuite();
	suite.addTestSuite(StudentTest.class);
	suite.addTestSuite(CourseTest.class);
	suite.addTestSuite(SessionTest.class);
	suite.addTestSuite(RosterReporterTest.class);
	suite.addTestSuite(DateUtilTest.class);
	return suite;
    }
}
