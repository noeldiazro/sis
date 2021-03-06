package sis.studentinfo;

import java.io.Serializable;

public class Course implements Comparable<Course>, Serializable {
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

    @Override public boolean equals(Object obj) {
	if (obj == null)
	    return false;

	if (!(obj instanceof Course))
	    return false;

	Course that = (Course)obj;
	return this.getDepartment() == that.getDepartment() &&
	    this.getNumber() == that.getNumber();
    }

    @Override public int hashCode() {
	final int hashMultiplier = 41;
	int result = 7;
	result = result * hashMultiplier + getDepartment().hashCode();
	result = result * hashMultiplier + getNumber().hashCode();
	return getDepartment().hashCode();
    }

    @Override public String toString() {
	return getDepartment() + " " + getNumber();
    }
}
