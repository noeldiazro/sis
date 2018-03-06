package sis.testing;

import junit.framework.TestCase;
import junit.runner.ClassPathTestCollector;

class SisTestCollector extends ClassPathTestCollector {
    @Override protected boolean isTestClass(String filename) {
	return super.isTestClass(filename) &&
	    inheritsFromTestCase(filename);
    }

    private boolean inheritsFromTestCase(String filename) {
	boolean result;
	try {
	    result = tryTestingInheritanceFromTestCase(filename);
	}
	catch (ClassNotFoundException e) {
	    result = false;
	}
	return result;
    }

    private boolean tryTestingInheritanceFromTestCase(String filename) throws ClassNotFoundException {
	Class klass = Class.forName(classNameFromFile(filename));
	return TestCase.class.isAssignableFrom(klass);
    }
}
