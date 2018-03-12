package sis.search;

import java.io.IOException;
import java.net.MalformedURLException;

class URLSearch implements Search {
    private final SearchParameterization params;
    private final Occurrencer occurrencer;
    
    private int matchCount = 0;
    private boolean errored = false;
    private Exception exception;
    
    URLSearch(SearchParameterization params, Occurrencer occurrencer) {
	this.params = params;
	this.occurrencer = occurrencer;
    }

    public void execute() {
	try {
	    tryCountingOccurrences();
	}
	catch (Exception e) {
	    errored = true;
	    exception = e;
	}
	/*
	try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
	    while (true) {
		String line = reader.readLine();
		if (line == null) break;
		matchCount += StringUtil.occurrences(line, params.getSearchString());
	    }
	}
	*/
    }

    public int getMatchCount() {
	return matchCount;
    }

    public boolean isErrored() {
	return errored;
    }

    public Exception getError() {
	return exception;
    }
    
    private void tryCountingOccurrences() throws MalformedURLException, IOException {
	URL url = params.getUrl();

	matchCount = occurrencer.countOccurrences(url.openStream(), params.getSearchString());
    }
	
}
