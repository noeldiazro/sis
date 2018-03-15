package sis.search;

class SearchScheduler {
    private final ResultsListener listener;
    private Timer timer;
    
    SearchScheduler(ResultsListener listener) {
	this.listener = listener;
    }

    void repeat(Search search, long intervalInMs) {
	
	listener.executed(search);
    }
}
