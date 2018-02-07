package sis.studentinfo;

import junit.framework.TestCase;

public class CourseTest extends TestCase {
    public void testCreateBasicMathCourse() {
	final String department = "Math";
	final String number = "101";
	Course course = new Course(department, number);
	assertEquals(department, course.getDepartment());
	assertEquals(number, course.getNumber());
    }

    public void testCreateAdvancedEnglishCourse() {
	final String department = "Engl";
	final String number = "200";
	Course course = new Course(department, number);
	assertEquals(department, course.getDepartment());
	assertEquals(number, course.getNumber());
    }

    public void testNumberOfCredits() {
	final int numberOfCredits = 3;
	
	Course course = new Course("Engl", "200");
	assertEquals(0, course.getNumberOfCredits());

	course.setNumberOfCredits(numberOfCredits);
	assertEquals(numberOfCredits, course.getNumberOfCredits());
    }
}
