package sis.studentinfo;

import java.util.ArrayList;
import java.util.List;

public class StudentImpl implements Student {
    
    private Name name;
    private int credits = 0;
    private String stateOfResidence = "";
    private List<Grade> grades = new ArrayList<Grade>();
    private GradingStrategy gradingStrategy = new BasicGradingStrategy();
    
    private static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    //static final String IN_STATE = "CO";
    
    public StudentImpl(String name) {
	this.name = Name.create(name);
    }

    public String getName() {
	return name.getFullName();
    }

    public String getFirstName() {
	return name.getFirstName();
    }

    public String getLastName() {
	return name.getLastName();
    }

    public String getMiddleName() {
	return name.getMiddleName();
    }

    public boolean isFullTime() {
	return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
    }

    public int getCredits() {
	return credits;
    }

    public void addCredits(int credits) {
	this.credits += credits;
    }

    public boolean isInState() {
	return stateOfResidence.equals(IN_STATE);
    }

    public void setState(String state) {
	this.stateOfResidence = state;
    }

    public double getGpa() {
	if (grades.isEmpty()) {
	    return 0;
	}
	double total = 0.0;
	for (Grade grade: grades) {
	    total += gradingStrategy.getGradePointsFor(grade);
	}
	return total / grades.size();
    }

    public void addGrade(Grade grade) {
	grades.add(grade);
    }

    public void setGradingStrategy(GradingStrategy strategy) {
	gradingStrategy = strategy;
    }
}
