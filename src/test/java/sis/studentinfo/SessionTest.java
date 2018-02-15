package sis.studentinfo;

import junit.framework.TestCase;
import java.util.Date;

abstract public class SessionTest extends TestCase {
    protected Session session;
    private Date startDate;
    private static final String DEPARTMENT = "Engl";
    private static final String NUMBER = "200";
    private static final double AVERAGE_GPA_TOLERANCE = 0.001;
    
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

    public void testPartialAverageGpa_NoStudentsEnrolled() {
	assertEquals(0.0, session.getPartialStudentsAverageGpa(), AVERAGE_GPA_TOLERANCE);
    }

    public void testPartialAverageGpa_OneFullTimeEnrolled() {
	session.enroll(new StudentStub(true));
	assertEquals(0.0, session.getPartialStudentsAverageGpa(), AVERAGE_GPA_TOLERANCE);
    }

    public void testPartialAverageGpa_OnePartialEnrolled() {
	session.enroll(new StudentStub(false, 3));

	assertEquals(3.0, session.getPartialStudentsAverageGpa(), AVERAGE_GPA_TOLERANCE);
    }

    public void testPartialAverageGpa_OneOfEachEnrolled() {
	session.enroll(new StudentStub(true, 2));
	session.enroll(new StudentStub(false, 3));

	assertEquals(3.0, session.getPartialStudentsAverageGpa(), AVERAGE_GPA_TOLERANCE);
    }

    public void testPartialAverageGpa_TwoOfEachEnrolled() {
	session.enroll(new StudentStub(true, 1));
	session.enroll(new StudentStub(true, 2));
	session.enroll(new StudentStub(false, 3));
	session.enroll(new StudentStub(false, 4));

	assertEquals(3.5, session.getPartialStudentsAverageGpa(), AVERAGE_GPA_TOLERANCE);
    }
	
    abstract protected Session createSession(Course course, Date startDate);    
}

class StudentStub implements Student {
    private boolean isFullTime = false;
    private double gpa = 0.0;
    
    StudentStub() {
    }

    StudentStub(boolean isFullTime) {
	this.isFullTime = isFullTime;
    }

    StudentStub(boolean isFullTime, double gpa) {
	this(isFullTime);
	this.gpa = gpa;
    }
    
    public String getName() { return ""; }
    public String getFirstName() { return ""; }
    public String getLastName() { return ""; }
    public String getMiddleName() { return ""; }
    public void addCredits(int credits) {}
    public int getCredits() { return 0; }
    public boolean isFullTime() { return isFullTime; }
    public void setState(String state) { }
    public boolean isInState() { return false; }
    public void setGradingStrategy(GradingStrategy strategy) {}
    public void addGrade(Grade grade) {}
    public double getGpa() { return gpa; }
}
