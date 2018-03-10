package sis.search;

import java.io.InputStream;
import java.io.IOException;

interface Occurrencer {
    int countOccurrences(InputStream input, String searchString) throws IOException;
}
