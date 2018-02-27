package sis.util;

import junit.framework.TestCase;

public class ParityCheckerTest extends TestCase {

    private ByteStream stream;
    private ParityChecker checker;

    @Override public void setUp() throws Exception {
	super.setUp();
	stream = new ByteStream();
	checker = new ParityChecker();
    }
    
    public void testChecksum_EmptyStream() {
	try {
	    checker.checksum(stream);
	    fail();
	}
	catch (EmptyStreamException e) {
	    assertEquals(ParityChecker.EMPTY_STREAM_MSG, e.getMessage());
	}
    }

    public void testChecksum_OneElementStream() {
	final byte element = (byte)13;
	stream.add(element);
	
	assertEquals(element, checker.checksum(stream));
    }

    public void testChecksum_TwoElementStream() {
	stream.add((byte)13);          // 1101
	stream.add((byte)10);          // 1010

	byte expected = (byte)7;       // 0111
	assertEquals(expected, checker.checksum(stream));
    }

    public void testChecksum_ThreeElementStream() {
	stream.add((byte)13);    // 1101
	stream.add((byte)10);    // 1010
	stream.add((byte)2);     // 0010

	byte expected = (byte)5; // 0101
	assertEquals(expected, checker.checksum(stream));
    }

}
