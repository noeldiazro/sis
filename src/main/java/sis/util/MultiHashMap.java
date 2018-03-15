package sis.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

class MultiHashMap<K, V> {
    private final Map<K, Collection<V>> map =
	new HashMap<K, Collection<V>>();
    
    int size() {
	return map.size();
    }

    void put(K key, V value) {
	if (!map.containsKey(key))
	    map.put(key, getEmptyCollection());
	map.get(key).add(value);
    }

    Collection<V> get(K key) {
	if (!map.containsKey(key))
	    return getEmptyCollection();
	return map.get(key);
    }

    private Collection<V> getEmptyCollection() {
	return new ArrayList<V>();
    }

}
