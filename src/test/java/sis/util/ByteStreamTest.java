package sis.util;

import junit.framework.TestCase;

public class ByteStreamTest extends TestCase {

    private ByteStream stream;
    
    @Override public void setUp() throws Exception {
	super.setUp();
	stream = new ByteStream();
    }
    
    public void testStreamIsEmptyOnCreation() {
	assertTrue(stream.isEmpty());
	assertEquals(0, stream.size());
    }

    public void testAdd() {
	stream.add((byte)13);
	stream.add((byte)10);
	stream.add((byte)2);
	
	assertFalse(stream.isEmpty());
	assertEquals(3, stream.size());
    }

    public void testFirst_EmptyStream() {
	try {
	    stream.first();
	    fail();
	}
	catch (EmptyStreamException e) {
	    assertEquals(ByteStream.EMPTY_STREAM_FIRST_MSG,
			 e.getMessage());
	}
    }

    public void testTail_EmptyStream() {
	try {
	    stream.tail();
	    fail();
	}
	catch (EmptyStreamException e) {
	    assertEquals(ByteStream.EMPTY_STREAM_TAIL_MSG,
			 e.getMessage());
	}
    }

    public void testFirst_OneElementStream() {
	final byte first = (byte)13;
	stream.add(first);
	
	assertEquals(first, stream.first());
    }

    public void testLast_OneElementStream() {
	stream.add((byte)13);

	ByteStream rest = stream.tail();
	assertTrue(rest.isEmpty());
    }

    public void testLast_TwoElementStream() {
	stream.add((byte) 10);
	stream.add((byte) 13);
	stream.add((byte) 2);

	ByteStream result = stream.tail();

	assertEquals(13, result.first());
	assertEquals(2, result.tail().first());
    }
}
