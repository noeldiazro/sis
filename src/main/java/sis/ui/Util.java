package sis.ui;

import java.awt.Component;
import java.awt.Container;
import java.util.HashSet;
import java.util.Set;

class Util {
    static Set<String> getNames(Container container) {
	Set<String> result = new HashSet<String>();
	for (Component component: container.getComponents())
	    result.add(component.getName());
	return result;
    }
}
