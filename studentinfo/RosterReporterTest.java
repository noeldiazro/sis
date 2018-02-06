package studentinfo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import junit.framework.TestCase;

public class RosterReporterTest extends TestCase {
    private Session session;

    public void setUp() {
	Course course = new Course("Engl", "200");
	session = new Session(course, createDate(2018, 1, 8));
    }
    
    public void testRosterReportForASessionWithoutStudents() {
	String report = new RosterReporter(session).getReport();
	assertEquals(RosterReporter.HEADER + RosterReporter.NEWLINE +
		     RosterReporter.FOOTER + "0" + RosterReporter.NEWLINE, report); 
    }

    public void testRosterReportForASessionWithSeveralStudents() {
	session.enroll(new Student("FirstnameA LastnameA"));
	session.enroll(new Student("FirstnameB LastnameB"));

	String report = new RosterReporter(session).getReport();
	
	assertEquals(RosterReporter.HEADER + RosterReporter.NEWLINE +
		     "FirstnameA LastnameA" + RosterReporter.NEWLINE +
		     "FirstnameB LastnameB" + RosterReporter.NEWLINE +
		     RosterReporter.FOOTER + "2" + RosterReporter.NEWLINE, report);
    }
    
    private Date createDate(int year, int month, int day) {
	final int january = 1;
	Calendar calendar = new GregorianCalendar(year, month - january, day);
	return calendar.getTime();
    }    
}
