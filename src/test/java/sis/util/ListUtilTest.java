package sis.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import junit.framework.TestCase;

public class ListUtilTest extends TestCase {

    public void testPad() {
	final int count = 5;
	final List<Date> list = new ArrayList<Date>();
	final Date element = new Date();

	ListUtil.pad(list, element, count);

	assertEquals(count, list.size());
    }

    public void testSwap_EmptyList() {
	List<String> names = new ArrayList<String>();
	ListUtil.swap(names);
	assertEquals(0, names.size());
    }

    public void testSwap_OneElement() {
	List<String> names = new ArrayList<String>();
	names.add("alpha");
	ListUtil.swap(names);
	assertEquals(1, names.size());
	assertEquals("alpha", names.get(0));
    }

    public void testSwap_TwoElements() {
	List<String> names = new ArrayList<String>();
	names.add("alpha");
	names.add("beta");
	ListUtil.swap(names);
	assertEquals(2, names.size());
	assertEquals("beta", names.get(0));
	assertEquals("alpha", names.get(1));
    }

    public void testSwap_ThreeElements() {
	List<String> names = new ArrayList<String>();
	names.add("alpha");
	names.add("beta");
	names.add("gamma");
	ListUtil.swap(names);
	assertEquals(3, names.size());
	assertEquals("gamma", names.get(0));
	assertEquals("beta", names.get(1));
	assertEquals("alpha", names.get(2));
    }

    public void testSwap_FourElements() {
	List<String> names = new ArrayList<String>();
	names.add("alpha");
	names.add("beta");
	names.add("gamma");
	names.add("delta");
	ListUtil.swap(names);
	assertEquals(4, names.size());
	assertEquals("delta", names.get(0));
	assertEquals("gamma", names.get(1));
	assertEquals("beta", names.get(2));
	assertEquals("alpha", names.get(3));
    }

    public void testSwap_FiveIntegers() {
	List<Integer> numbers = new ArrayList<Integer>();
	numbers.add(1);
	numbers.add(2);
	numbers.add(3);
	numbers.add(4);
	numbers.add(5);
	ListUtil.swap(numbers);
	assertEquals(5, numbers.size());
	assertEquals(Integer.valueOf(5), numbers.get(0));
	assertEquals(Integer.valueOf(4), numbers.get(1));
	assertEquals(Integer.valueOf(3), numbers.get(2));
	assertEquals(Integer.valueOf(2), numbers.get(3));
	assertEquals(Integer.valueOf(1), numbers.get(4));
    }
    
}
