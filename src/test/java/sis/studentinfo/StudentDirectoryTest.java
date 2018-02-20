package sis.studentinfo;

import junit.framework.TestCase;

public class StudentDirectoryTest extends TestCase {
    private StudentDirectory directory;
    
    @Override public void setUp() {
	directory = new StudentDirectory();
    }
    
    public void testRetrieveAddedStudent() {
	final String name = "Student Name";
	final String id = "1";

	directory.add(makeStudent(name, id));
	Student retrievedStudent = directory.findById(id);
	
	assertEquals(name, retrievedStudent.getName());
	assertEquals(id, retrievedStudent.getId());
    }

    public void testTryingToRetrieveNonAddedStudent() {
	try {
	    directory.findById("1");
	    fail();
	}
	catch (StudentNotFoundException e) {
	    assertEquals(StudentDirectory.STUDENT_NOT_FOUND_MESSAGE,
			 e.getMessage());
	}
    }

    private Student makeStudent(String name, String id) {
	Student student = new StudentImpl(name);
	student.setId(id);
	return student;
    }
}
