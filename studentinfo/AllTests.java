package studentinfo;

import junit.framework.TestSuite;

public class AllTests {
    public static TestSuite suite() {
	TestSuite suite = new TestSuite();
	suite.addTestSuite(StudentTest.class);
	suite.addTestSuite(CourseTest.class);
	suite.addTestSuite(SessionTest.class);
	return suite;
    }
}
