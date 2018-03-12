package sis.search;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;
import junit.framework.TestCase;

public class URLSearchTest extends TestCase {
    private static final String URL_SPEC = "http://www.langrsoft.com";
    private SearchParameterization params;
    
    @Override public void setUp() throws Exception {
	super.setUp();
	params = new SearchParameterization(new URL() {
		@Override public InputStream openStream() {
		    return new ByteArrayInputStream(new byte[]{});
		}
	    }, "Search String");
    }	

    public void testNegativeSearch() {
	Occurrencer occurrencer = getOccurrencer(0);
	Search search = new URLSearch(params, occurrencer);
	search.execute();
	assertEquals(0, search.getMatchCount());
	assertFalse(search.isErrored());
    }

    public void testPositiveSearch() {
	Occurrencer occurrencer = getOccurrencer(1);
	Search search = new URLSearch(params, occurrencer);
	search.execute();
	assertEquals(1, search.getMatchCount());
	assertFalse(search.isErrored());
    }

    public void testErroredSearch() {
	Occurrencer occurrencer = getErroredOccurrencer();
	Search search = new URLSearch(params, occurrencer);
	search.execute();
	assertTrue(search.isErrored());
	assertEquals(IOException.class, search.getError().getClass());
    }

    private Occurrencer getOccurrencer(int expectedOccurrences) {
	return new Occurrencer() {
	    @Override public int countOccurrences(InputStream input, String searchString) {
		return expectedOccurrences;
	    }
	};
    }

    private Occurrencer getErroredOccurrencer() {
	return new Occurrencer() {
	    @Override public int countOccurrences(InputStream input, String searchString) throws IOException {
		throw new IOException();
	    }
	};
    }

}
