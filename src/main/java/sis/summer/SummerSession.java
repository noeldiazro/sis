package sis.summer;

import java.util.Date;
import sis.studentinfo.Course;
import sis.studentinfo.DateUtil;
import sis.studentinfo.Session;

public class SummerSession extends Session {
    private SummerSession(Course course, Date startDate) {
	super(course, startDate);
    }

    public static SummerSession create(Course course, Date startDate) {
	return new SummerSession(course, startDate);
    }

    @Override protected int getDurationInWeeks() {
	return 8;
    }
}
