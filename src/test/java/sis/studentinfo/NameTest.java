package sis.studentinfo;

import java.util.List;
import junit.framework.TestCase;

public class NameTest extends TestCase {
    private Name name;
    
    public void testCreateFromEmptyName() {
	name = Name.create("");
	assertNameSplitting("", "", "", "");
    }

    public void testCreateFromOnePartName() {
	name = Name.create("Blow");
	assertNameSplitting("Blow",
			    "",
			    "Blow",
			    "");
    }

    public void testCreateFromTwoPartName() {
	name = Name.create("Jane Doe");
	assertNameSplitting("Jane Doe",
			    "Jane",
			    "Doe",
			    "");
    }

    public void testCreateFromThreePartName() {
	name = Name.create("Raymond Douglas Davies");
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
}
