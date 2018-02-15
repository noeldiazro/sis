package sis.performance;

import junit.framework.TestCase;

public class PerformanceTest extends TestCase {
    private Performance performance;
    private static final int NUMBER_OF_TESTS = 4;

    @Override public void setUp() {
	performance = new Performance(NUMBER_OF_TESTS);
    }

    public void testAverage() {
	performance.set(0, 98);
	performance.set(1, 92);
	performance.set(2, 81);
	performance.set(3, 72);
	
	assertEquals(92, performance.get(1));

	final double tolerance = 0.005;
	assertEquals(85.75, performance.average(), tolerance);
    }

    public void testInitialization() {
	performance.setScores(75, 72, 90, 60);
	final double tolerance = 0.005;
	assertEquals(74.25, performance.average(), tolerance);
    }
}
