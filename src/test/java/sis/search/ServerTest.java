package sis.search;

import java.util.List;
import junit.framework.TestCase;

public class ServerTest extends TestCase {
    private int numberOfResults = 0;
    private static final int NUMBER_OF_SEARCHES = 3;
    private Server server;

    @Override public void setUp() throws Exception {
	super.setUp();
	ResultsListener listener = makeListener();
	server = new Server(listener);
    }
    
    public void testSearch() throws InterruptedException {
	addSearches(NUMBER_OF_SEARCHES);
	waitForSearches();
    }

    public void testLogs() throws InterruptedException {
	addSearches(NUMBER_OF_SEARCHES);
	waitForSearches();
	List<String> logs = server.getLogs();
	assertEquals(2 * NUMBER_OF_SEARCHES, logs.size());
	for (int i=0; i < NUMBER_OF_SEARCHES; i+=2) {
	    assertEquals(Server.START_MSG, logs.get(i));
	    assertEquals(Server.STOP_MSG, logs.get(i + 1));
	}
	    
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
	    public void execute() { trySleeping(1); }

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
