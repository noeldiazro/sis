package sis.studentinfo;

public class Course {
    private String department;
    private String number;
    private int numberOfCredits = 0;
    
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

    int getNumberOfCredits() {
	return numberOfCredits;
    }

    void setNumberOfCredits(int numberOfCredits) {
	this.numberOfCredits = numberOfCredits;
    }
}
