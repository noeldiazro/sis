package sis.util;

class ParityChecker {
    static final String EMPTY_STREAM_MSG = "Checksum of empty stream can not be calculated";
    
    byte checksum(ByteStream stream) {
	if (stream.isEmpty())
	    throw new EmptyStreamException(EMPTY_STREAM_MSG);
	if (stream.size() == 1)
	    return stream.first();
	return (byte)(stream.first() ^ checksum(stream.tail()));
    }
}
