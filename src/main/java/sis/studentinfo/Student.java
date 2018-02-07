package sis.studentinfo;

import java.lang.String;
import java.lang.Object;

public class Student extends Object {
    private String name;
    private int credits = 0;
    private static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    
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
}
