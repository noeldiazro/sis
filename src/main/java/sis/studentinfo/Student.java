package sis.studentinfo;

import java.util.ArrayList;
import java.util.List;

public class Student extends Object {
    enum Grade { A, B, C, D, F }
    
    private String name;
    private int credits = 0;
    private String stateOfResidence = "";
    private List<Grade> grades = new ArrayList<Grade>();
    private boolean isHonors = false;
    
    private static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    static final String IN_STATE = "CO";
    
    public Student(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

    boolean isFullTime() {
	return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
    }

    int getCredits() {
	return credits;
    }

    void addCredits(int credits) {
	this.credits += credits;
    }

    boolean isInState() {
	return stateOfResidence.equals(IN_STATE);
    }

    void setState(String state) {
	this.stateOfResidence = state;;
    }

    double getGpa() {
	if (grades.isEmpty()) {
	    return 0;
	}
	double total = 0.0;
	for (Grade grade: grades) {
	    total += gradePointsFor(grade);
	}
	return total / grades.size();
    }

    void addGrade(Grade grade) {
	grades.add(grade);
    }

    int gradePointsFor(Grade grade) {
	if (isHonors()) {
	    int basicPoints = basicGradePointsFor(grade);
	    if (basicPoints == 0) {
		return basicPoints;
	    } 
	    return basicPoints + 1;
	} else {
	    return basicGradePointsFor(grade);
	}
    }

    private int basicGradePointsFor(Grade grade) {
	if (grade == Grade.A) return 4;
	if (grade == Grade.B) return 3;
	if (grade == Grade.C) return 2;
	if (grade == Grade.D) return 1;
	return 0;
    }
    
    boolean isHonors() {
	return isHonors;
    }

    void setHonors() {
	isHonors = true;
    }
}
