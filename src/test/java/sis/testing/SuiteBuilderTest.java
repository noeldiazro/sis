package sis.testing;

import java.util.Enumeration;
import java.util.StringTokenizer;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.runner.TestCollector;

public class SuiteBuilderTest extends TestCase {

    public void testSuite_NoTestsCollected() throws ClassNotFoundException {
	TestCollector collector = getCollector("");
	
	SuiteBuilder builder = new SuiteBuilder(collector);
	TestSuite suite = builder.suite();
	assertEquals(0, suite.countTestCases());
    }

    public void testSuite_OneTestCollected() throws ClassNotFoundException {
	TestCollector collector = getCollector(this.getClass().getName());

	SuiteBuilder builder = new SuiteBuilder(collector);
	TestSuite suite = builder.suite();

	assertEquals(1, suite.testCount());
	Enumeration tests = suite.tests();
	Object test = tests.nextElement();
	System.out.println(test.getClass().getName());
    }
	
    private TestCollector getCollector(String tests) {
	return new TestCollector() {
	    public Enumeration collectTests() {
		return new StringTokenizer(tests);
	    }
	};
    }

}
