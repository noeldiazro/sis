package sis.studentinfo;

import junit.framework.TestCase;

public class StudentTest extends TestCase {
    private Student student;

    private static final double GPA_TOLERANCE = 0.005;
    
    public void setUp() {
	student = new Student("Name");
    }
    
    public void testCreate() {
	assertEquals("Name", student.getName());
    }

    public void testStudentStatus() {
	assertEquals(0, student.getCredits());
	assertFalse(student.isFullTime());

	student.addCredits(3);
	assertEquals(3, student.getCredits());
	assertFalse(student.isFullTime());

	student.addCredits(6);
	assertEquals(9, student.getCredits());
	assertFalse(student.isFullTime());

	student.addCredits(3);
	assertEquals(12, student.getCredits());
	assertTrue(student.isFullTime());
    }

    public void testStudentWithoutResidenceDataIsOutOfState() {
	assertFalse(student.isInState());
    }

    public void testStudentThatResidesInSchoolsStateIsInState() {
	student.setState(Student.IN_STATE);
	assertTrue(student.isInState());
    }

    public void testStudentThatDoesNotResideInSchoolsStateIsOutOfState() {
	student.setState(Student.IN_STATE);
	student.setState("MD");
	assertFalse(student.isInState());
    }

    public void testGpaIsZeroBeforeAnyGradesHaveBeenAddedToTheStudent() {
	assertEquals(0.0, student.getGpa(), GPA_TOLERANCE);
    }

    public void testStudentWithSeveralGradesGpa() {
	student.addGrade(Student.Grade.A);
	student.addGrade(Student.Grade.B);
	assertEquals(3.5, student.getGpa(), GPA_TOLERANCE);
    }

    public void testHonorsStudentGpa() {
	student.setGradingStrategy(new HonorsGradingStrategy());
	student.addGrade(Student.Grade.A);
	student.addGrade(Student.Grade.B);
	assertEquals(4.5, student.getGpa(), GPA_TOLERANCE);
    }
}
