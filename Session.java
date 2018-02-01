class Session {
    private Course course;
    private int numberOfStudents = 0;
    
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
	return numberOfStudents;
    }

    void enroll(Student student) {
	numberOfStudents += 1;
    }
}
