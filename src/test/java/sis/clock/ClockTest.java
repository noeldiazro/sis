package sis.clock;

import java.util.Date;
import junit.framework.TestCase;

public class ClockTest extends TestCase {
    private static final int NUMBER_OF_SECONDS = 5;
    private Clock clock;
    private Object monitor = new Object();
    
    public void testClock() throws InterruptedException {
	clock = new Clock(makeListener());
	synchronized (monitor) {
	    monitor.wait();
	}
	clock.shutdown();

	clock.join(3000);
	assertFalse(clock.isAlive());
    }

    private ClockListener makeListener() {
	return new ClockListener() {
	    private int count = 0;
	    
	    public void update(Date date) {
		count++;
		System.out.println(getMessage(date));
		if (count == NUMBER_OF_SECONDS)
		    synchronized (monitor) {
			monitor.notifyAll();
		    }
	    }

	    private String getMessage(Date date) {
		return String.format("%d - %s", count, date.toString());
	    }
	};
    }
    
}
