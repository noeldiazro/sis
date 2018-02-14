package sis.studentinfo;

import junit.framework.TestCase;

public class BasicGradingStrategyTest extends TestCase {
    public void testGetGradePointsFor() {
	GradingStrategy strategy = new BasicGradingStrategy();
	assertEquals(4, strategy.getGradePointsFor(Grade.A));
	assertEquals(3, strategy.getGradePointsFor(Grade.B));
	assertEquals(2, strategy.getGradePointsFor(Grade.C));
	assertEquals(1, strategy.getGradePointsFor(Grade.D));
	assertEquals(0, strategy.getGradePointsFor(Grade.F));	
    }
}
