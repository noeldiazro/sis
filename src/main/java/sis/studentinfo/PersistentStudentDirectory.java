package sis.studentinfo;

import java.io.*;

class PersistentStudentDirectory {
    private ObjectOutputStream output;
    private final String pathname;

    PersistentStudentDirectory(String pathname) {
	this.pathname = pathname;
    }

    void add(Student student) throws FileNotFoundException, IOException {
	ObjectOutputStream output = getOutput();
	output.writeObject(student);
    }
    
    Student findById(String id) throws FileNotFoundException, IOException, ClassNotFoundException {
	Student result = null;
	try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(pathname))) {
	    while (true) {
		Student student = (Student)input.readObject();
		if (id.equals(student.getId())) {
		    result = student;
		    break;
		}
	    }
	}
	return result;
    }

    private ObjectOutputStream getOutput() throws FileNotFoundException, IOException {
	if (output == null)
	    output = new ObjectOutputStream(new FileOutputStream(pathname, true));
	return output;
    }
}
