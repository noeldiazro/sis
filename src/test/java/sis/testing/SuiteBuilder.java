package sis.testing;

import java.util.Enumeration;
import junit.framework.TestSuite;
import junit.runner.TestCollector;

class SuiteBuilder {
    private final TestCollector collector;
    
    SuiteBuilder(TestCollector collector) {
	this.collector = collector;
    }
    
    TestSuite suite() throws ClassNotFoundException {
	TestSuite suite = new TestSuite();
	Enumeration tests = collector.collectTests();

	while (tests.hasMoreElements()) {
	    Class testClass = Class.forName(tests.nextElement().toString());
	    suite.addTestSuite(testClass);
	}
	return suite;
    }
}
