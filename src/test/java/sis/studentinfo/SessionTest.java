package sis.studentinfo;

import junit.framework.TestCase;
import java.util.Date;

abstract public class SessionTest extends TestCase {
    protected Session session;
    private Date startDate;
    private static final String DEPARTMENT = "Engl";
    private static final String NUMBER = "200";
    
    public void setUp() {
	Course course = new Course(DEPARTMENT, NUMBER);
	course.setNumberOfCredits(3);
	startDate = DateUtil.createDate(2018, 1, 8);
	session = createSession(course, startDate);
    }

    public void testCreateAnAdvancedEnglishCourseSession() {
	assertEquals(DEPARTMENT, session.getDepartment());
	assertEquals(NUMBER, session.getNumber());
	assertEquals(0, session.getNumberOfStudents());
    }

    public void testEnrollAStudent() {
	Student student = new StudentImpl("Cain DiVoe");

	session.enroll(student);
	
	assertEquals(1, session.getNumberOfStudents());
	assertEquals(student, session.get(0));
	assertEquals(3, student.getCredits());
    }

    public void testEnrollSeveralStudents() {
	Student student1 = new StudentImpl("Cain DiVoe");
	Student student2 = new StudentImpl("Coralee DeVaughn");
	
	session.enroll(student1);
	session.enroll(student2);
	
	assertEquals(2, session.getNumberOfStudents());
	assertEquals(student1, session.get(0));
	assertEquals(student2, session.get(1));
    }

    public void testStartDate() {
	assertEquals(startDate, session.getStartDate());
    }

    abstract protected Session createSession(Course course, Date startDate);    
}
