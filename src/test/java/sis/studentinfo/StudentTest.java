package sis.studentinfo;

import junit.framework.TestCase;

public class StudentTest extends TestCase {
    public void testCreate() {
	final String firstStudentName = "Jane Doe";
	final String secondStudentName = "Joe Blow";
	
	Student firstStudent = new Student(firstStudentName);
	Student secondStudent = new Student(secondStudentName);
	
	assertEquals(firstStudentName, firstStudent.getName());
	assertEquals(secondStudentName, secondStudent.getName());
    }

    public void testStudentStatus() {
	Student student = new Student("Name");
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
}
