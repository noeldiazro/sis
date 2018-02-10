package sis.studentinfo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import junit.framework.TestCase;

public class DateUtilTest extends TestCase {
    private Date date;
    private Calendar calendar;

    public void setUp() {
	date = DateUtil.createDate(2018, 1, 8);
	calendar = new GregorianCalendar();
    }
    
    public void testCreateDate() {
	assertDateParts(date, 2018, Calendar.JANUARY, 8);
    }

    public void testAddDays() {
	Date result = DateUtil.addDays(date, 1);
	assertDateParts(result, 2018, Calendar.JANUARY, 9);
    }

    private void assertDateParts(Date date,
				 int year,
				 int month,
				 int dayOfMonth) {
	calendar.setTime(date);
	assertEquals(year, calendar.get(Calendar.YEAR));
	assertEquals(month, calendar.get(Calendar.MONTH));
	assertEquals(dayOfMonth, calendar.get(Calendar.DAY_OF_MONTH));
    }	
}
