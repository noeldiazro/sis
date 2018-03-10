package sis.search;

class SearchParameterization {
    private final URL url;
    private final String searchString;
	
    SearchParameterization(URL url, String searchString) {
	this.url = url;
	this.searchString = searchString;
    }

    URL getUrl() {
	return url;
    }

    String getSearchString() {
	return searchString;
    }

}
