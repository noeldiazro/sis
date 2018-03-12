package sis.util;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import junit.framework.TestCase;

public class LineWriterTest extends TestCase {
    private StringWriter writer;
    private LineWriter lineWriter;

    @Override protected void setUp() throws Exception {
	super.setUp();
	writer = new StringWriter();
	lineWriter = new LineWriter(writer);
    }
    
    public void testWrite_EmptyRecords() throws IOException {
	lineWriter.write(new String[] {});
	assertEquals("", writer.toString());
    }

    public void testWrite_OneRecord() throws IOException {
	lineWriter.write(new String[] {"a"});
	assertEquals(String.format("a%n"), writer.toString());
    }

    public void testWrite_SeveralRecords() throws IOException {
	lineWriter.write(new String[] {"aaa", "bb", "c", "", "d"});
	assertEquals(String.format("aaa%nbb%nc%n%nd%n"), writer.toString());
    }
	
}
