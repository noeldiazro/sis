package sis.summer;

import java.util.Date;
import junit.framework.TestCase;
import sis.studentinfo.Course;
import sis.studentinfo.DateUtil;
import sis.studentinfo.Session;


public class SummerSessionTest extends TestCase {
    public void testEndDate() {
	Course course = new Course("ENGL", "200");
	Date startDate = DateUtil.createDate(2018, 6, 4);
	Session session = SummerSession.create(course, startDate);
	Date eightWeeksOut = DateUtil.createDate(2018, 7, 27);
	assertEquals(eightWeeksOut, session.getEndDate());
    }
}
