package sis.clock;

import java.util.Date;

class Clock extends Thread {
    private static final long ONE_SECOND = 1000;

    private boolean run = true;
    private final ClockListener listener;
    
    Clock(ClockListener listener) {
	this.listener = listener;
	this.start();
    }
    
    @Override public void run() {
	while (run) {
	    trySleeping(ONE_SECOND);
	    listener.update(new Date());
	}
    }

    private void trySleeping(long millis) {
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    void shutdown() {
	run = false;
    }

}
