package sis.studentinfo;

import java.io.Serializable;
import java.util.Date;

public class RegularSession extends Session {
    private static int count;
    static {
	count = 0;
    }

    private RegularSession(Course course, Date startDate) {
	super(course, startDate);
    }

    public static RegularSession create(Course course, Date startDate) {
        RegularSession.incrementCount();
	return new RegularSession(course, startDate);
    }

    @Override protected int getDurationInWeeks() {
	return 16;
    }

    static int getCount() {
	return count;
    }

    static void resetCount() {
	count = 0;
    }

    private static void incrementCount() {
	count++;
    }    
}
