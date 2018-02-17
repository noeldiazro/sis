package sis.studentinfo;

class NameFormatException
    extends IllegalArgumentException {

    static final String MESSAGE_FORMAT = "Name '%s' contains more than %d parts";

    NameFormatException(String fullName, int maximumNumberOfParts) {
	super(String.format(MESSAGE_FORMAT, fullName, maximumNumberOfParts));
    }
}
