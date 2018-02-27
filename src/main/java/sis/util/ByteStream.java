package sis.util;

import java.util.ArrayList;
import java.util.List;

class ByteStream {

    static final String EMPTY_STREAM_FIRST_MSG = "First byte of an empty stream can not be returned";
    static final String EMPTY_STREAM_TAIL_MSG = "Tail of an empty stream can not be returned";
    
    private List<Byte> bytes = new ArrayList<Byte>();
    
    boolean isEmpty() {
	return bytes.isEmpty();
    }

    int size() {
	return bytes.size();
    }
    
    void add(byte b) {
	bytes.add(b);
    }

    byte first() {
	if (isEmpty())
	    throw new EmptyStreamException(EMPTY_STREAM_FIRST_MSG);
	return bytes.get(0);
    }

    ByteStream tail() {
	if (isEmpty())
	    throw new EmptyStreamException(EMPTY_STREAM_TAIL_MSG);

	ByteStream result = new ByteStream();
	for (byte b: bytes.subList(1, size()))
	    result.add(b);
	return result;
    }
    
}
