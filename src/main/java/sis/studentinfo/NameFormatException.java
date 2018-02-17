package sis.studentinfo;

class NameFormatException
    extends IllegalArgumentException {

    NameFormatException() {
	super();
    }

    NameFormatException(String message) {
	super(message);
    }
}
