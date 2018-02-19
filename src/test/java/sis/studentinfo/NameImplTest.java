package sis.studentinfo;

import java.util.List;
import junit.framework.TestCase;

public class NameImplTest extends TestCase {
    private Name name;
    
    public void testCreateFromEmptyName() {
	name = NameImpl.create("");
	assertNameSplitting("", "", "", "");
    }

    public void testCreateFromOnePartName() {
	name = NameImpl.create("Blow");
	assertNameSplitting("Blow",
			    "",
			    "Blow",
			    "");
    }

    public void testCreateFromTwoPartName() {
	name = NameImpl.create("Jane Doe");
	assertNameSplitting("Jane Doe",
			    "Jane",
			    "Doe",
			    "");
    }

    public void testCreateFromThreePartName() {
	name = NameImpl.create("Raymond Douglas Davies");
	assertNameSplitting("Raymond Douglas Davies",
			    "Raymond",
			    "Davies",
			    "Douglas");
    }

    public void testBadlyFormattedName() {
	final String tooMuchPartsName = getTestName(NameImpl.MAXIMUM_NUMBER_OF_PARTS + 1, "A");
	try {
	    NameImpl.create(tooMuchPartsName);
	    fail();
	}
	catch (NameFormatException expectedException) {
	    String expectedMessage = String.format(NameFormatException.MESSAGE_FORMAT,
						   tooMuchPartsName,
						   NameImpl.MAXIMUM_NUMBER_OF_PARTS);
	    assertEquals(expectedMessage, expectedException.getMessage());
	}
    }

    private void assertNameSplitting(String expectedFullName,
				     String expectedFirstName,
				     String expectedLastName,
				     String expectedMiddleName) {
	assertEquals(expectedFullName, name.getFullName());
	assertEquals(expectedFirstName, name.getFirstName());
	assertEquals(expectedLastName, name.getLastName());
	assertEquals(expectedMiddleName, name.getMiddleName());
    }
    
    private String getTestName(int numberOfParts, String part) {
	if (numberOfParts == 0)
	    return "";

	if (numberOfParts == 1)
	    return part;

	return part + " " + getTestName(numberOfParts - 1, part);
    }
}
