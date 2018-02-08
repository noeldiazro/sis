package sis.studentinfo;

import junit.framework.TestCase;

public class GradeTest extends TestCase {
    public void testCreate() {
	Grade grade = new Grade(GradeLetter.A);
	assertEquals(GradeLetter.A, grade.getLetter()); 
    }

    public void testGradePoints() {
	assertEquals(4, new Grade(GradeLetter.A).getPoints());
	assertEquals(3, new Grade(GradeLetter.B).getPoints());
	assertEquals(2, new Grade(GradeLetter.C).getPoints());
	assertEquals(1, new Grade(GradeLetter.D).getPoints());
	assertEquals(0, new Grade(GradeLetter.F).getPoints());
    }
	
}
