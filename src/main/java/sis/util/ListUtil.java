package sis.util;

import java.util.List;
import java.util.Date;

class ListUtil {

    static <T> void pad(List<T> list, T element, int count) {
	for (int i=0; i < count; i++)
	    list.add(element);
    }

    static <T> void swap(List<T> list) {
	if (list.size() <= 1) return;
	
	T replacedFirst = firstElementOf(list);
	list.set(0, lastElementOf(list));
	list.set(list.size() - 1, replacedFirst);
	swap(list.subList(1, list.size() - 1));
    }

    private static <T> T firstElementOf(List<T> list) {
	return list.get(0);
    }

    private static <T> T lastElementOf(List<T> list) {
	return list.get(list.size() - 1);
    }
}
