package sis.studentinfo;

import junit.framework.TestCase;

public class StudentTest extends TestCase {
    private Student student;

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
	assertEquals(0.0, student.getGpa(), 0.005);
    }

    public void testStudentWithSeveralGrades() {
	student.addGrade(Student.Grade.A);
	student.addGrade(Student.Grade.B);
	assertEquals(3.5, student.getGpa(), 0.005);
    }

    public void testGradePoints() {
	assertEquals(4, student.gradePointsFor(Student.Grade.A));
	assertEquals(3, student.gradePointsFor(Student.Grade.B));
	assertEquals(2, student.gradePointsFor(Student.Grade.C));
	assertEquals(1, student.gradePointsFor(Student.Grade.D));
	assertEquals(0, student.gradePointsFor(Student.Grade.F));	
    }

    public void testStudentIsNotHonorsByDefault() {
	assertFalse(student.isHonors());
    }

    public void testSetHonors() {
	student.setHonors();
	assertTrue(student.isHonors());
    }

    public void testGradePointsForHonorsStudent() {
	student.setHonors();
	assertEquals(5, student.gradePointsFor(Student.Grade.A));
	assertEquals(4, student.gradePointsFor(Student.Grade.B));
	assertEquals(3, student.gradePointsFor(Student.Grade.C));
	assertEquals(2, student.gradePointsFor(Student.Grade.D));
	assertEquals(0, student.gradePointsFor(Student.Grade.F));
    }
}
