package sis.util;

import java.util.Collection;
import java.util.Date;
import junit.framework.TestCase;

public class MultiHashMapTest extends TestCase {
    private static final Date TODAY;
    private static final Date TOMORROW;
    static {
	TODAY = new Date();
	TOMORROW = new Date(TODAY.getTime() + getMillisecondsInADay());
    }

    private static long getMillisecondsInADay() { return 24 * 60 * 60 * 1000; }

    private MultiHashMap<Date, String> events;
    
    @Override protected void setUp() throws Exception {
	super.setUp();
	events = new MultiHashMap<Date, String>();
    }
    
    public void testMapIsCreatedEmpty() {
	assertEquals(0, events.size());
	assertEquals(0, events.get(TODAY).size());
	assertEquals(0, events.get(TOMORROW).size());
    }

    public void testSingleEntry() {
	final String todayEvent = "wake up";
	events.put(TODAY, todayEvent);

	assertEquals(1, events.size());
	assertEventsOn(TODAY, todayEvent);
	assertEventsOn(TOMORROW);
    }
    
    public void testMultipleEntriesOnSameDay() {
	final String firstEvent = "wake up";
	final String secondEvent = "have breakfast";
	events.put(TODAY, firstEvent);
	events.put(TODAY, secondEvent);
	events.put(TOMORROW, firstEvent);
	
	assertEquals(2, events.size());
	assertEventsOn(TODAY, firstEvent, secondEvent);
	assertEventsOn(TOMORROW, firstEvent);
    }

    private void assertEventsOn(Date date, String... expectedEvents) {
	Collection<String> retrievedEvents = events.get(date);
	assertEquals(expectedEvents.length, retrievedEvents.size());
	for (String expectedEvent: expectedEvents)
	    assertTrue(retrievedEvents.contains(expectedEvent));
    }
    
}
