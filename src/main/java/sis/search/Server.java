package sis.search;

import java.util.LinkedList;
import java.util.List;

class Server extends Thread {
    private List<Search> queue = new LinkedList<Search>(); // flaw!
    private ResultsListener listener;
    
    Server(ResultsListener listener) {
	this.listener = listener;
	start();
    }
    
    void add(Search search) {
	queue.add(search);
    }

    @Override public void run() {
	while (true) {
	    if (!queue.isEmpty())
		execute(queue.remove(0));
	    Thread.yield();
	}
    }

    private void execute(Search search) {
	search.execute();
	listener.executed(search);
    }
}
