package sis.studentinfo;

import java.io.*;
import junit.framework.TestCase;

public class PersistentStudentDirectoryTest extends TestCase {
    private static final String PATHNAME = "StudentDirectory.dat";
    
    public void testStudentAddition() throws FileNotFoundException, IOException, ClassNotFoundException {
	Student student1 = createStudent("ID-1", "NAME-1");
	Student student2 = createStudent("ID-2", "NAME-2");
	addStudents(student1, student2);

	PersistentStudentDirectory directory =
	    new PersistentStudentDirectory(PATHNAME);
	
	Student retrievedStudent1 = directory.findById("ID-1");
	Student retrievedStudent2 = directory.findById("ID-2");

	assertEquals("ID-1", retrievedStudent1.getId());
	assertEquals("ID-2", retrievedStudent2.getId());
    }

    private Student createStudent(String id, String name) {
	Student student = new StudentImpl(name);
	student.setId(id);
	return student;
    }

    private void addStudents(Student... students) throws FileNotFoundException, IOException {
	// Using a different directory object for adding
	// students as a way of testing persistence.
	PersistentStudentDirectory directory =
	    new PersistentStudentDirectory(PATHNAME);
	for (Student s: students)
	    directory.add(s);
    }
}
