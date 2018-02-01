public class SessionTest extends junit.framework.TestCase {
    
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
	session.enroll(new Student("Cain DiVoe"));
	assertEquals(1, session.getNumberOfStudents());
    }

    public void testEnrollSeveralStudents() {
	Course course = new Course("Engl", "200");
	Session session = new Session(course);
	session.enroll(new Student("Cain DiVoe"));
	session.enroll(new Student("Coralee DeVaughn"));
	assertEquals(2, session.getNumberOfStudents());
    }
}
