package sis.studentinfo;

import junit.framework.TestCase;
import java.util.Date;

public class SessionTest extends TestCase {
    private Session session;
    private Date startDate;
    private static final String DEPARTMENT = "Engl";
    private static final String NUMBER = "200";
    
    public void setUp() {
	Course course = new Course(DEPARTMENT, NUMBER);
	course.setNumberOfCredits(3);
	startDate = DateUtil.createDate(2018, 1, 8);
	session = Session.create(course, startDate);
    }
    
    public void testCreateAnAdvancedEnglishCourseSession() {
	assertEquals(DEPARTMENT, session.getDepartment());
	assertEquals(NUMBER, session.getNumber());
	assertEquals(0, session.getNumberOfStudents());
    }

    public void testEnrollAStudent() {
	Student student = new Student("Cain DiVoe");

	session.enroll(student);
	
	assertEquals(1, session.getNumberOfStudents());
	assertEquals(student, session.get(0));
	assertEquals(3, student.getCredits());
    }

    public void testEnrollSeveralStudents() {
	Student student1 = new Student("Cain DiVoe");
	Student student2 = new Student("Coralee DeVaughn");
	
	session.enroll(student1);
	session.enroll(student2);
	
	assertEquals(2, session.getNumberOfStudents());
	assertEquals(student1, session.get(0));
	assertEquals(student2, session.get(1));
    }

    public void testSessionStartDate() {
	assertEquals(startDate, session.getStartDate());
    }

    public void testSessionEndDate() {
	assertEquals(DateUtil.createDate(2018, 4, 27), session.getEndDate());
    }

    public void testCount() {
	Session.resetCount();;
	assertEquals(0, Session.getCount());

	Session engl101 = Session.create(new Course("Engl", "101"),
				      DateUtil.createDate(2018, 1, 8));
	assertEquals(1, Session.getCount());

	Session math200 = Session.create(new Course("Math", "200"),
				      DateUtil.createDate(2018, 1, 8));
	assertEquals(2, Session.getCount());
    }
}
