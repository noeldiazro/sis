package sis.studentinfo;

import java.util.Map;
import java.util.HashMap;

class StudentDirectory {
    static final String STUDENT_NOT_FOUND_MESSAGE = "Student not found";
    
    private Map<String, Student> students = new HashMap<String, Student>();
    
    void add(Student student) {
	students.put(student.getId(), student);
    }

    Student findById(String id) throws StudentNotFoundException {
	if (!students.containsKey(id))
	    throw new StudentNotFoundException(STUDENT_NOT_FOUND_MESSAGE);

	return students.get(id);
    }
}
