package sis.studentinfo;

class Scorer {
    int score(String input) {
	return Integer.parseInt(input);
    }

    boolean isValid(String input) {
	try {
	    score(input);
	    return true;
	}
	catch (NumberFormatException e) {
	    return false;
	}
    }
}
