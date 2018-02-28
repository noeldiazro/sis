package sis.report;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
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
    private Writer writer;
    
    public void setUp() {
	Course course = new Course("Engl", "200");
	Date startDate = DateUtil.createDate(2018, 1, 8);
	session = RegularSession.create(course, startDate);
	writer = new StringWriter();
    }
    
    public void testRosterReportForASessionWithoutStudents() throws IOException {
	RosterReporter report = new RosterReporter(session, writer);

	report.write();
	
	assertEquals(String.format(RosterReporter.HEADER) +
		     String.format(RosterReporter.FOOTER, 0), writer.toString()); 
    }

    public void testRosterReportForASessionWithSeveralStudents() throws IOException {
	session.enroll(new StudentImpl("FirstnameA LastnameA"));
	session.enroll(new StudentImpl("FirstnameB LastnameB"));
	RosterReporter reporter = new RosterReporter(session, writer);

	reporter.write();

	assertEquals(String.format(RosterReporter.HEADER) +
		     String.format(RosterReporter.LINE, "FirstnameA LastnameA") +
		     String.format(RosterReporter.LINE, "FirstnameB LastnameB") +
		     String.format(RosterReporter.FOOTER, 2), writer.toString());
    }
}
