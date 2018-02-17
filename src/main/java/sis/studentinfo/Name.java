package sis.studentinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Name {
    private String firstName = "";
    private String lastName = "";
    private String middleName = "";
    private String fullName = "";
    
    private Name() {
    }
    
    static Name create(String fullName) {
	final int maximumNumberOfParts = 3;
	if (getNumberOfParts(fullName) > maximumNumberOfParts) {
	    String message = "Name '" + fullName +
		"' contains more than " +
		maximumNumberOfParts + " parts";
	    throw new NameFormatException(message);
	}
	
	Name name = new Name();
	name.fullName = fullName;
	List<String> parts;
	
	switch (getNumberOfParts(fullName)) {
	case 1:
	    name.lastName = fullName;
	    break;
	case 2:
	    parts = getParts(fullName);
	    name.firstName = parts.get(0);
	    name.lastName = parts.get(1);
	    break;
	case 3:
	    parts = getParts(fullName);
	    name.firstName = parts.get(0);
	    name.lastName = parts.get(2);
	    name.middleName = parts.get(1);
	    break;
	}
	return name;
    }

    String getFirstName() {
	return firstName;
    }

    String getLastName() {
	return lastName;
    }

    String getMiddleName() {
	return middleName;
    }

    String getFullName() {
	return fullName;
    }

    private static int getNumberOfParts(String fullName) {
	return getParts(fullName).size();
    }
    
    private static List<String> getParts(String fullName) {
	return Arrays.asList(fullName.split(" "));
    }
}
