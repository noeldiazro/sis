package sis.util;

import java.io.Writer;
import java.io.IOException;

class LineWriter {
    private final Writer writer;
    
    LineWriter(Writer writer) {
	this.writer = writer;
    }

    void write(String[] records) throws IOException {
	for (String record: records)
	    writer.write(appendLineSeparator(record));
    }

    private String appendLineSeparator(String record) {
	return String.format("%s%n", record);
    }
}
