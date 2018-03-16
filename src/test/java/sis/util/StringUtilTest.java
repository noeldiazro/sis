package sis.util;

import java.util.ArrayList;
import java.util.List;
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

    public void testConcatenateList_Null() {
	List<String> list = null;
	assertEquals("", StringUtil.concatenate(list));
    }

    public void testConcatenateList_Empty() {
	List<String> list = new ArrayList<String>();
	assertEquals("", StringUtil.concatenate(list));
    }

    public void testConcatenateList_OneString() {
	List<String> list = new ArrayList<String>();
	list.add("a");
	assertEquals(String.format("a%n"), StringUtil.concatenate(list));
    }

    public void testConcatenateList_TwoStrings() {
	List<String> list = new ArrayList<String>();
	list.add("a");
	list.add("b");
	assertEquals(String.format("a%nb%n"), StringUtil.concatenate(list));
    }

    public void testConcatenateList_TwoIntegers() {
	List<Integer> list = new ArrayList<Integer>();
	list.add(Integer.valueOf(1));
	list.add(Integer.valueOf(2));
	assertEquals(String.format("1%n2%n"), StringUtil.concatenate(list));
    }
}
