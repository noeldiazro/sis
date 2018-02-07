package sis.studentinfo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import junit.framework.TestCase;

public class DateUtilTest extends TestCase {
    public void testCreateDate() {
	Date date = DateUtil.createDate(2018, 1, 8);
	Calendar calendar = new GregorianCalendar();
	calendar.setTime(date);
	assertEquals(2018, calendar.get(Calendar.YEAR));
	assertEquals(Calendar.JANUARY, calendar.get(Calendar.MONTH));
	assertEquals(8, calendar.get(Calendar.DAY_OF_MONTH));
    }
}
