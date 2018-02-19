package sis.studentinfo;

import junit.framework.TestCase;

public class NameImplTest extends NameTest {
    
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
	    assertEquals(expectedMessage, expectedException.getMessage());
	}
    }

    @Override Name createName(String fullName) {
	return NameImpl.create(fullName);
    }
}
