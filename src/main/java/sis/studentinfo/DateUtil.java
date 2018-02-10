package sis.studentinfo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
    private DateUtil() {
    }
    
    public static Date createDate(int year, int month, int date) {
	final int january = 1;
	Calendar calendar = new GregorianCalendar(year, month - january, date);
	return calendar.getTime();
    }

    static Date addDays(Date date, int numberOfDays) {
	Calendar calendar = new GregorianCalendar();
	calendar.setTime(date);
	calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);	
	return calendar.getTime();
    }
}
