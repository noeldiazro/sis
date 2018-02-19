package sis.studentinfo;

import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.LogRecord;
import junit.framework.TestCase;

public class LoggedNameTest extends NameTest {
    private TestHandler handler;
    
    public void testBadlyFormattedName() {
	final String tooMuchPartsName = getTestName(Name.MAXIMUM_NUMBER_OF_PARTS + 1, "A");
	try {
	    createName(tooMuchPartsName);
	    fail();
	}
	catch (NameFormatException expectedException) {
	    String expectedMessage = String.format(NameFormatException.MESSAGE_FORMAT,
						   tooMuchPartsName,
						   Name.MAXIMUM_NUMBER_OF_PARTS);
	    assertEquals(expectedMessage, handler.getLastPublishedMessage());
	    assertEquals(expectedMessage, expectedException.getMessage());
	}
    }
    
    @Override Name createName(String fullName) {
	Logger logger = Logger.getLogger("a");
	handler = new TestHandler();
	logger.addHandler(handler);
	return LoggedName.create(fullName, logger);
    }

    private class TestHandler extends Handler {
	private String message;

	public void publish(LogRecord record) {
	    this.message = record.getMessage();
	}

	public void flush() {}
	public void close() {}
	
	private String getLastPublishedMessage() {
	    return this.message;
	}

    }
}
