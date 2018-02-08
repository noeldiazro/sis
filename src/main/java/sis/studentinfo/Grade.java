package sis.studentinfo;

class Grade {
    private GradeLetter letter;
    
    Grade(GradeLetter letter) {
	this.letter = letter;
    }

    GradeLetter getLetter() {
	return letter;
    }

    int getPoints() {
	int points = 0;
	switch (letter) {
 	    case A:
		points = 4;
		break;
	    case B:
		points = 3;
		break;
	    case C:
		points = 2;
		break;
	    case D:
		points = 1;
		break;
	    case F:
		points = 0;
	}
	return points;
    }
}
