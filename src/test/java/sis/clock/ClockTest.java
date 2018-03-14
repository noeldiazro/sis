package sis.clock;

import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import junit.framework.TestCase;

public class ClockTest extends TestCase {
    private static final int NUMBER_OF_SECONDS = 5;
    private Clock clock;
    private Lock lock;
    private Condition monitor;
    
    public void testClock() throws InterruptedException {
	lock = new ReentrantLock();
	monitor = lock.newCondition();
	
	clock = new Clock(makeListener());

	lock.lock();
	try {
	    monitor.await();
	}
	finally {
	    lock.unlock();
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
		if (count == NUMBER_OF_SECONDS) {
		    lock.lock();
		    try {
			monitor.signalAll();
		    }
		    finally {
			lock.unlock();
		    }
		}
	    }

	    private String getMessage(Date date) {
		return String.format("%d - %s", count, date.toString());
	    }
	};
    }
    
}
