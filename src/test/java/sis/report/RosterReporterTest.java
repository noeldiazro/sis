package sis.report;

import java.util.Date;
import junit.framework.TestCase;
import sis.studentinfo.Course;
import sis.studentinfo.DateUtil;
import sis.studentinfo.RegularSession;
import sis.studentinfo.Session;
import sis.studentinfo.StudentImpl;
import static sis.report.ReportConstant.NEWLINE;

public class RosterReporterTest extends TestCase {
    private Session session;

    public void setUp() {
	Course course = new Course("Engl", "200");
	Date startDate = DateUtil.createDate(2018, 1, 8);
	session = RegularSession.create(course, startDate);
    }
    
    public void testRosterReportForASessionWithoutStudents() {
	String report = new RosterReporter(session).getReport();
	assertEquals(RosterReporter.HEADER + NEWLINE +
		     RosterReporter.FOOTER + "0" + NEWLINE, report); 
    }

    public void testRosterReportForASessionWithSeveralStudents() {
	session.enroll(new StudentImpl("FirstnameA LastnameA"));
	session.enroll(new StudentImpl("FirstnameB LastnameB"));

	String report = new RosterReporter(session).getReport();

	assertEquals(RosterReporter.HEADER + NEWLINE +
		     "FirstnameA LastnameA" + NEWLINE +
		     "FirstnameB LastnameB" + NEWLINE +
		     RosterReporter.FOOTER + "2" + NEWLINE, report);
    }
}
