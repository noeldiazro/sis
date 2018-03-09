package sis.search;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import sis.util.StringUtil;

class Search {
    private final String urlSpec;
    private int matchCount = 0;
    private final String searchString;
    
    Search(String urlSpec, String searchString) {
	this.urlSpec = urlSpec;
	this.searchString = searchString;
    }

    void execute() throws MalformedURLException, IOException {

	try (URLReader reader = new URLReader()) {
	    while (true) {
		String line = reader.readLine();
		if (line == null) break;
		matchCount += StringUtil.occurrences(line, searchString);
	    }
	}
    }

    int getMatchCount() {
	return matchCount;
    }

    boolean isErrored() {
	return false;
    }

    private class URLReader implements AutoCloseable {
	private BufferedReader reader = null;
	
	private String readLine() throws MalformedURLException, IOException {
	    if (reader == null)
		reader = getReader();
	    return reader.readLine();
	}

	private BufferedReader getReader() throws MalformedURLException, IOException {
	    URL url = new URL(urlSpec);
	    URLConnection connection = url.openConnection();
	    InputStream input = connection.getInputStream();
	    return new BufferedReader(new InputStreamReader(input));
	}

	public void close() throws IOException {
	    reader.close();
	}
    }
}
