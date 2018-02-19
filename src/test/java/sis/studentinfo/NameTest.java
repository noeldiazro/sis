package sis.studentinfo;

import junit.framework.TestCase;

public abstract class NameTest extends TestCase {
    private Name name;

    public void testCreateFromEmptyName() {
	name = createName("");
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
	name = createName("Jane Doe");
	assertNameSplitting("Jane Doe",
			    "Jane",
			    "Doe",
			    "");
    }

    public void testCreateFromThreePartName() {
	name = createName("Raymond Douglas Davies");
	assertNameSplitting("Raymond Douglas Davies",
			    "Raymond",
			    "Davies",
			    "Douglas");
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

    String getTestName(int numberOfParts, String part) {
	if (numberOfParts == 0)
	    return "";

	if (numberOfParts == 1)
	    return part;

	return part + " " + getTestName(numberOfParts - 1, part);
    }
    
    abstract Name createName(String fullNume);
}
