package sis.studentinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class NameImpl implements Name {
    private String firstName = "";
    private String lastName = "";
    private String middleName = "";
    private String fullName = "";
    
    private NameImpl(String fullName) {
	this.fullName = fullName;
    }

    static final int MAXIMUM_NUMBER_OF_PARTS = 3;
    
    static NameImpl create(String fullName) {
	if (getNumberOfParts(fullName) > MAXIMUM_NUMBER_OF_PARTS) {
	    throw new NameFormatException(fullName, MAXIMUM_NUMBER_OF_PARTS);
	}
	
	NameImpl name = new NameImpl(fullName);

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

    public String getFirstName() {
	return firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public String getMiddleName() {
	return middleName;
    }

    public String getFullName() {
	return fullName;
    }

    private static int getNumberOfParts(String fullName) {
	return getParts(fullName).size();
    }
    
    private static List<String> getParts(String fullName) {
	return Arrays.asList(fullName.split(" "));
    }
}
