package sis.search;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import junit.framework.TestCase;

public class SearchSchedulerTest extends TestCase {
    private List<Date> dates;
    
    public void testCreation() {
	final long searchDurationInMs = 10;
	final long intervalInMs = 1000;

	SearchScheduler scheduler = new SearchScheduler(makeListener());
	scheduler.repeat(makeSearch(searchDurationInMs), intervalInMs);
	assertEquals(1, dates.size());
    }

    private ResultsListener makeListener() {
	return new ResultsListener() {
	    public void executed(Search search) {
		if (dates == null)
		    dates = new ArrayList<Date>();
		dates.add(new Date());
	    }
	};
    }
    
    private Search makeSearch(long duration) {
	return new Search() {
	    public void execute() {
		trySleeping();
	    }

	    public int getMatchCount() { return 0; }
	    public boolean isErrored() { return false; }
	    public Exception getError() { return null; }

	    private void trySleeping() {
		try {
		    Thread.sleep(duration);
		}
		catch (InterruptedException e) {}
	    }
	};
    }
}
