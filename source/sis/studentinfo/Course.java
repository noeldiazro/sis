package sis.studentinfo;

public class Course {
    private String department;
    private String number;
    
    public Course(String department, String number) {
	this.department = department;
	this.number = number;
    }

    String getDepartment() {
	return department;
    }

    String getNumber() {
	return number;
    }
}
