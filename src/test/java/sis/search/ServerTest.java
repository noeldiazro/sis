package sis.search;

import junit.framework.TestCase;

public class ServerTest extends TestCase {
    private int numberOfResults = 0;
    private static final int NUMBER_OF_SEARCHES = 3;
    
    public void testSearch() {
	ResultsListener listener = new ResultsListener() {
		public void executed(Search search) {
		    System.out.println("Search executed");
		    numberOfResults++;
		}
	    };
	
	Server server = new Server(listener);
	for (int i=0; i < NUMBER_OF_SEARCHES; i++)
	    server.add(createSearch());

	while (numberOfResults < NUMBER_OF_SEARCHES)
	    trySleeping(1);

    }

    private Search createSearch() {
	return new Search() {
	    public void execute() {}
	    public int getMatchCount() { return -1; }
	    public boolean isErrored() { return false; }
	    public Exception getError() { return null; }
	};
    }

    private void trySleeping(long millis) {
	try {
	    Thread.sleep(1);
	}
	catch (InterruptedException e) {}
    }
}
