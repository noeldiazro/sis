package sis.testing;

import java.util.Enumeration;
import junit.framework.TestCase;
import junit.runner.TestCollector;

public class SisTestCollectorTest extends TestCase {
    private EnumerationContainer tests;

    @Override public void setUp() throws Exception {
	TestCollector collector = new SisTestCollector();
	tests = new EnumerationContainer(collector.collectTests());
    }
    
    public void testCollectsThisTestCase() {
	String thisTestClassName = this.getClass().getName();
	assertTrue(tests.contains(thisTestClassName));
    }

    public void testDoesntCollectNotATest() {
	assertFalse(tests.contains("sis.testing.util.NotATest"));
    }

    public void testDoesntCollectNotExistingClass() {
	assertFalse(tests.contains("sis.testing.util.NonExistingTestClass"));
    }

    private class EnumerationContainer<E> implements Enumeration {
	private final Enumeration<E> baseEnumeration;
	
	EnumerationContainer(Enumeration<E> baseEnumeration) {
	    this.baseEnumeration = baseEnumeration;
	}

	@Override public boolean hasMoreElements() {
	    return baseEnumeration.hasMoreElements();
	}

	@Override public E nextElement() {
	    return baseEnumeration.nextElement();
	}

	private boolean contains(Object o) {
	    while (hasMoreElements())
		if (nextElement().equals(o))
		    return true;
	    return false;
	}
    }
}
