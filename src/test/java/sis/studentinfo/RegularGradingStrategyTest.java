package sis.studentinfo;

import junit.framework.TestCase;

public class RegularGradingStrategyTest extends TestCase {
    public void testGetGradePointsFor() {
	GradingStrategy strategy = new RegularGradingStrategy();
	assertEquals(4, strategy.getGradePointsFor(Student.Grade.A));
	assertEquals(3, strategy.getGradePointsFor(Student.Grade.B));
	assertEquals(2, strategy.getGradePointsFor(Student.Grade.C));
	assertEquals(1, strategy.getGradePointsFor(Student.Grade.D));
	assertEquals(0, strategy.getGradePointsFor(Student.Grade.F));	
    }
}