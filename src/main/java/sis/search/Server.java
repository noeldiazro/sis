package sis.search;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Server extends Thread {
    static final String START_MSG = "started";
    static final String STOP_MSG = "finished";
    
    private BlockingQueue<Search> queue = new LinkedBlockingQueue<Search>();
    private ResultsListener listener;
    private final List<String> logs = Collections.synchronizedList(new ArrayList<String>());
	
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
	new Thread(new Runnable() {
		private List log = new ArrayList();
		
		public void run() {
		    log.add(START_MSG);
		    search.execute();
		    log.add(STOP_MSG);
		    logs.addAll(log);
		    listener.executed(search);
		}
	    }).start();
    }

    void shutdown() {
	this.interrupt();
    }

    List<String> getLogs() {
	return logs;
    }
}
