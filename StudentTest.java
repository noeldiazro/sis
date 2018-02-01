public class StudentTest extends junit.framework.TestCase {
    public void testCreate() {
	final String firstStudentName = "Jane Doe";
	final String secondStudentName = "Joe Blow";
	
	Student firstStudent = new Student(firstStudentName);
	Student secondStudent = new Student(secondStudentName);
	
	assertEquals(firstStudentName, firstStudent.getName());
	assertEquals(secondStudentName, secondStudent.getName());
    }
}
