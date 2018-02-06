package sis.studentinfo;

import java.lang.String;
import java.lang.Object;

public class Student extends Object {
    private String name;
    
    public Student(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }
}
