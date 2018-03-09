package sis.util;

import junit.framework.TestCase;

public class StringUtilTest extends TestCase {

    public void testOccurrences_EmptyString() {
	assertEquals(0, StringUtil.occurrences("", "ABC"));
    }

    public void testOccurrences_EmptySubstring() {
	try {
	    StringUtil.occurrences("ABC", "");
	    fail("Expected IllegalArgumentException was not thrown");
	}
	catch (IllegalArgumentException expected) {
	    assertEquals(StringUtil.SUBSTRING_CANNOT_BE_EMPTY,
			 expected.getMessage());
	}
    }

    public void testOcurrences_SubstringOccursOnce() {
	assertEquals(1, StringUtil.occurrences("ABCD EFGH", "D"));
    }

    public void testOccurrences_SubstringOccursTwice() {
	assertEquals(2, StringUtil.occurrences("ABCD ABCD", "CD"));
    }

    public void testOccurrences_SubstringConcat() {
	assertEquals(4, StringUtil.occurrences("ABCABCABCABC", "ABC"));
    }

}
