package sis.studentinfo;

import java.util.ArrayList;
import java.util.List;

public class Student extends Object {
    enum Grade { A, B, C, D, F }
    
    private String name;
    private int credits = 0;
    private String stateOfResidence = "";
    private List<Grade> grades = new ArrayList<Grade>();
    private GradingStrategy gradingStrategy = new RegularGradingStrategy();
    
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
	    total += gradingStrategy.getGradePointsFor(grade);
	}
	return total / grades.size();
    }

    void addGrade(Grade grade) {
	grades.add(grade);
    }

    void setGradingStrategy(GradingStrategy strategy) {
	gradingStrategy = strategy;
    }
}
