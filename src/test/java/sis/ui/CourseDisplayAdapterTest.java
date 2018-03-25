package sis.ui;

import junit.framework.TestCase;
import sis.studentinfo.Course;

public class CourseDisplayAdapterTest extends TestCase {

    public void testDisplay() {
	Course course = new Course("ENGL", "101");
	CourseDisplayAdapter adapter = new CourseDisplayAdapter(course);
	assertEquals("ENGL-101", adapter.toString());
    }
}
