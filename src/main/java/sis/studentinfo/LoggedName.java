package sis.studentinfo;

import java.util.logging.Logger;

class LoggedName implements Name {
    private Name name;

    private LoggedName(Name name) {
	this.name = name;
    }
    
    static LoggedName create(String fullName, Logger logger) {
	LoggedName result;
	try {
	    result = new LoggedName(NameImpl.create(fullName));
	}
	catch (NameFormatException e) {
	    logger.warning(e.getMessage());
	    throw e;
	}
	return result;
    }

    public String getFirstName() {
	return name.getFirstName();
    }

    public String getLastName() {
	return name.getLastName();
    }

    public String getMiddleName() {
	return name.getMiddleName();
    }

    public String getFullName() {
	return name.getFullName();
    }
}

