package sis.search;

import java.io.IOException;
import java.net.MalformedURLException;
import junit.framework.TestCase;

public class SearchTest extends TestCase {
    private static final String URL = "http://langrsoft.com";
    
    public void testNegativeSearch() throws IOException, MalformedURLException {
	final String searchString = "mama cass elliott";
	Search search = new Search(URL, searchString);
	search.execute();
	assertEquals(0, search.getMatchCount());
	assertFalse(search.isErrored());
    }

    public void testPositiveSearch() throws IOException, MalformedURLException {
	final String searchString = "Jeff Langr";
	Search search = new Search(URL, searchString);
	search.execute();
	assertTrue(search.getMatchCount() >= 1);
    }
}
