package studentinfo;

import java.lang.String;
import java.lang.Object;

class Student extends Object {
    private String name;
    
    Student(String name) {
	this.name = name;
    }

    String getName() {
	return name;
    }
}
