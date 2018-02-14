package sis.studentinfo;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

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
	return tokenize(fullName);
    }

    private static List<String> tokenize(String fullName) {
	List<String> words = new ArrayList<String>();

	if (fullName.isEmpty()) {
	    words.add(fullName);
	    return words;
	}
	
	StringBuilder word = new StringBuilder();
	for(int i = 0; i < fullName.length(); i++) {
	    char letter = fullName.charAt(i);
	    if (letter == ' ') {
		words.add(word.toString());
		word = new StringBuilder();
	    } else {
		word.append(letter);
	    }
	}
	words.add(word.toString());
	return words;
    }
}
