package sis.search;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Server extends Thread {
    private BlockingQueue<Search> queue = new LinkedBlockingQueue<Search>();
    private ResultsListener listener;
    
    Server(ResultsListener listener) {
	this.listener = listener;
	start();
    }
    
    void add(Search search) throws InterruptedException {
	queue.put(search);
    }

    @Override public void run() {
	while (true) {
	    try {
		execute(queue.take());
	    }
	    catch (InterruptedException e) {
		break;
	    }
	}
    }

    private void execute(Search search) {
	search.execute();
	listener.executed(search);
    }

    void shutdown() {
	this.interrupt();
    }
}
