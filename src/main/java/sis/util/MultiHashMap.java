package sis.util;

import java.util.*;

class MultiHashMap<K, V> {
    private final Map<K, List<V>> map =
	new HashMap<K, List<V>>();
    
    int size() {
	return map.size();
    }

    void put(K key, V value) {
	if (!map.containsKey(key))
	    map.put(key, getEmptyList());
	map.get(key).add(value);
    }

    List<V> get(K key) {
	if (!map.containsKey(key))
	    return getEmptyList();
	return map.get(key);
    }

    private List<V> getEmptyList() {
	return new ArrayList<V>();
    }

    protected Set<Map.Entry<K, List<V>>> getEntrySet() {
	return map.entrySet();
    }

}
