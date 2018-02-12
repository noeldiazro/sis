package sis.summer;

import java.util.Date;
import sis.studentinfo.Course;
import sis.studentinfo.DateUtil;
import sis.studentinfo.Session;
import sis.studentinfo.SessionTest;

public class SummerSessionTest extends SessionTest {
    @Override protected Session createSession(Course course, Date startDate) {
	return SummerSession.create(course, startDate);
    }
	
    public void testEndDate() {
	Date eightWeeksOut = DateUtil.createDate(2018, 3, 2);
	assertEquals(eightWeeksOut, session.getEndDate());
    }
}
