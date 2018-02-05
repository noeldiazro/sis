package studentinfo;

import junit.framework.TestCase;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SessionTest extends TestCase {
    private Session session;
    private Date startDate;
    private final static String DEPARTMENT = "Engl";
    private final static String NUMBER = "200";
    
    public void setUp() {
	Course course = new Course(DEPARTMENT, NUMBER);
	startDate = createDate(2018, 1, 8);
	session = new Session(course, startDate);
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
	assertEquals(createDate(2018, 4, 27), session.getEndDate());
    }

    private Date createDate(int year, int month, int day) {
	final int january = 1;
	Calendar calendar = new GregorianCalendar(year, month - january, day);
	return calendar.getTime();
    }
}
