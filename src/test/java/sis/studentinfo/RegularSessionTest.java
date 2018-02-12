package sis.studentinfo;

import java.util.Date;

public class RegularSessionTest extends SessionTest {
    @Override protected Session createSession(Course course, Date startDate) {
	return RegularSession.create(course, startDate);
    }

    public void testEndDate() {
	assertEquals(DateUtil.createDate(2018, 4, 27), session.getEndDate());
    }

    public void testCount() {
	RegularSession.resetCount();;
	assertEquals(0, RegularSession.getCount());

	createSession(new Course("Engl", "101"), DateUtil.createDate(2018, 1, 8));
	assertEquals(1, RegularSession.getCount());

	createSession(new Course("Math", "200"), DateUtil.createDate(2018, 1, 8));
	assertEquals(2, RegularSession.getCount());
    }    
}
