package sis.search;

interface Search {
    void execute();
    int getMatchCount();
    boolean isErrored();
    Exception getError();
}
