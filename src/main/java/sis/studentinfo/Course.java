package sis.studentinfo;

public class Course implements Comparable<Course> {
    private String department;
    private String number;
    private int numberOfCredits = 0;
    
    public Course(String department, String number) {
	this.department = department;
	this.number = number;
    }

    public String getDepartment() {
	return department;
    }

    public String getNumber() {
	return number;
    }

    int getNumberOfCredits() {
	return numberOfCredits;
    }

    void setNumberOfCredits(int numberOfCredits) {
	this.numberOfCredits = numberOfCredits;
    }

    @Override public int compareTo(Course that) {
	int compareDepartment = this.getDepartment().compareTo(that.getDepartment());
	if (compareDepartment != 0) {
	    return compareDepartment;
	}
	else {
	    return this.getNumber().compareTo(that.getNumber());
	}
    }
}
