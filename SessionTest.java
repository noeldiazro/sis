import junit.framework.TestCase;
import java.util.List;

public class SessionTest extends TestCase {
    
    public void testCreateABasicMathCourseSession() {
	final String department = "Math";
	final String number = "101";
	Course course = new Course(department, number);
	Session session = new Session(course);
	assertEquals(department, session.getDepartment());
	assertEquals(number, session.getNumber());
	assertEquals(0, session.getNumberOfStudents());
    }

    public void testCreateAnAdvancedEnglishCourseSession() {
	final String department = "Engl";
	final String number = "200";
	Course course = new Course(department, number);
	Session session = new Session(course);
	assertEquals(department, session.getDepartment());
	assertEquals(number, session.getNumber());
	assertEquals(0, session.getNumberOfStudents());
    }

    public void testEnrollAStudent() {
	Course course = new Course("Engl", "200");
	Session session = new Session(course);
	Student student = new Student("Cain DiVoe");

	session.enroll(student);
	List<Student> students = session.getAllStudents();
	
	assertEquals(1, session.getNumberOfStudents());
	assertEquals(1, students.size());
	assertEquals(student, students.get(0));
    }

    public void testEnrollSeveralStudents() {
	Course course = new Course("Engl", "200");
	Session session = new Session(course);
	Student student1 = new Student("Cain DiVoe");
	Student student2 = new Student("Coralee DeVaughn");
	
	session.enroll(student1);
	session.enroll(student2);
	List<Student> students = session.getAllStudents();
	
	assertEquals(2, session.getNumberOfStudents());
	assertEquals(2, students.size());
	assertEquals(student1, students.get(0));
	assertEquals(student2, students.get(1));
    }
}
