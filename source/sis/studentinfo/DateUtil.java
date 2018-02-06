package sis.studentinfo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
    public Date createDate(int year, int month, int date) {
	final int january = 1;
	Calendar calendar = new GregorianCalendar(year, month - january, date);
	return calendar.getTime();
    }
}
