import java.util.*;

class Session {
    private Course course;
    private List<Student> students = new ArrayList<Student>();
    
    Session(Course course) {
	this.course = course;
    }

    String getDepartment() {
	return course.getDepartment();
    }

    String getNumber() {
	return course.getNumber();
    }
    
    int getNumberOfStudents() {
	return students.size();
    }

    void enroll(Student student) {
	students.add(student);
    }

    List<Student> getAllStudents() {
	return students;
    }
}
