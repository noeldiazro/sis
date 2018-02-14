package sis.studentinfo;

import junit.framework.TestCase;

public class HonorsGradingStrategyTest extends TestCase {
    public void testGetGradePoints() {
	GradingStrategy strategy = new HonorsGradingStrategy();
	assertEquals(5, strategy.getGradePointsFor(Grade.A));
	assertEquals(4, strategy.getGradePointsFor(Grade.B));
	assertEquals(3, strategy.getGradePointsFor(Grade.C));
	assertEquals(2, strategy.getGradePointsFor(Grade.D));
	assertEquals(0, strategy.getGradePointsFor(Grade.F));
    }
}
