package sis.report;

import java.util.Date;
import junit.framework.TestCase;
import sis.studentinfo.Course;
import sis.studentinfo.DateUtil;
import sis.studentinfo.Session;
import sis.studentinfo.Student;


public class RosterReporterTest extends TestCase {
    private Session session;

    public void setUp() {
	Course course = new Course("Engl", "200");
	Date startDate = new DateUtil().createDate(2018, 1, 8);
	session = new Session(course, startDate);
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
}
