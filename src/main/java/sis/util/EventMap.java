package sis.util;

import java.util.*;

class EventMap<K extends Date, V> extends MultiHashMap<K, V> {

    List<V> getPastEvents() {
	final List<V> result = new ArrayList<V>();
	final Date now = new Date();
	
	for (Map.Entry<K, List<V>> entry: getEntrySet())
	    if (entry.getKey().compareTo(now) < 0)
		result.addAll(entry.getValue());
	
	return result;
    }
    
}
