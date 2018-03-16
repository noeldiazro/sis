package sis.util;

import java.util.Date;
import java.util.List;
import junit.framework.TestCase;

public class EventMapTest extends TestCase {

    public void testSingleElement() {
	EventMap<java.sql.Date, String> map =
	    new EventMap<java.sql.Date, String>();
	final java.sql.Date date =
	    new java.sql.Date(new Date().getTime());
	final String value = "abc";
	map.put(date, value);

	List<String> values = map.get(date);
	assertEquals(value, values.get(0));
    }

    public void testGetPastEvents() {
	final EventMap<Date, String> events = new EventMap<Date, String>();
	final Date today = new Date();
	final Date yesterday = new Date(today.getTime() - 86400000);
	events.put(today, "sleep");
	final String descriptionA = "birthday";
	final String descriptionB = "drink";
	events.put(yesterday, descriptionA);
	events.put(yesterday, descriptionB);

	List<String> descriptions = events.getPastEvents();

	assertEquals(2, descriptions.size());
	assertTrue(descriptions.contains(descriptionA));
	assertTrue(descriptions.contains(descriptionB));
    }

}
