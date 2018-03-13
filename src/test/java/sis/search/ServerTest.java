package sis.search;

import junit.framework.TestCase;

public class ServerTest extends TestCase {
    private int numberOfResults = 0;
    private static final int NUMBER_OF_SEARCHES = 3;
    private Server server;
    
    public void testSearch() throws InterruptedException {
	ResultsListener listener = makeListener();
	server = new Server(listener);
	addSearches(NUMBER_OF_SEARCHES);
	waitForSearches();
    }

    private ResultsListener makeListener() {
	return new ResultsListener() {
	    public void executed(Search search) {
		numberOfResults++;
	    }
	};
    }

    private void addSearches(int numberOfSearches) throws InterruptedException{
	for (int i=0; i < numberOfSearches; i++)
	    server.add(createSearch());
    }
    
    private Search createSearch() {
	return new Search() {
	    public void execute() {}
	    public int getMatchCount() { return -1; }
	    public boolean isErrored() { return false; }
	    public Exception getError() { return null; }
	};
    }

    private void waitForSearches() {
	while (numberOfResults < NUMBER_OF_SEARCHES)
	    trySleeping(1);
    }
    
    private void trySleeping(long millis) {
	try {
	    Thread.sleep(1);
	}
	catch (InterruptedException e) {}
    }

    @Override public void tearDown() throws Exception {
	server.shutdown();
	server.join(3000);
	assertFalse(server.isAlive());
    }
}
