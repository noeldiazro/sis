package sis.studentinfo;

class InvalidURLException extends IllegalArgumentException {
    InvalidURLException() {
	super();
    }

    InvalidURLException(String message) {
	super(message);
    }

    InvalidURLException(String message, Throwable cause) {
	super(message, cause);
    }

    InvalidURLException(Throwable cause) {
	super(cause);
    }
}
