package sis.studentinfo;

class Name {
    private String firstName = "";
    private String lastName = "";
    private String middleName = "";
    private String fullName = "";
    
    private Name() {
    }
    
    static Name create(String fullName) {
	Name name = new Name();
	name.fullName = fullName;
	String[] parts;
	
	switch (getNumberOfParts(fullName)) {
	case 1:
	    name.lastName = fullName;
	    break;
	case 2:
	    parts = getParts(fullName);
	    name.firstName = parts[0];
	    name.lastName = parts[1];
	    break;
	case 3:
	    parts = getParts(fullName);
	    name.firstName = parts[0];
	    name.lastName = parts[2];
	    name.middleName = parts[1];
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
	return getParts(fullName).length;
    }
    
    private static String[] getParts(String fullName) {
	return fullName.split(" ");
    }
}
