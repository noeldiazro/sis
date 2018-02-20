package sis.studentinfo;

class StudentNotFoundException extends RuntimeException {
    StudentNotFoundException(String message) {
	super(message);
    }
}
