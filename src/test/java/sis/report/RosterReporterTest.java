package sis.report;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
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
    
    public void setUp() {
	Course course = new Course("Engl", "200");
	Date startDate = DateUtil.createDate(2018, 1, 8);
	session = RegularSession.create(course, startDate);
    }
    
    public void testRosterReportForASessionWithoutStudents() throws IOException {
	Writer writer = new StringWriter();	
	RosterReporter report = new RosterReporter(session, writer);

	report.write();
	
	assertEquals(String.format(RosterReporter.HEADER) +
		     String.format(RosterReporter.FOOTER, 0), writer.toString()); 
    }

    public void testRosterReportForASessionWithSeveralStudents() throws IOException {
	populateSession();
	Writer writer = new StringWriter();
	RosterReporter reporter = new RosterReporter(session, writer);

	reporter.write();

	assertContents(writer.toString());
    }

    public void testFiledReport() throws IOException {
	populateSession();
	final String filename = "rosterReport.txt";
	Writer fileWriter = new FileWriter(filename);
	RosterReporter reporter = new RosterReporter(session, fileWriter);

	reporter.write();

	assertContents(getReportContent(filename));
    }
    
    private void populateSession() {
	session.enroll(new StudentImpl("FirstnameA LastnameA"));
	session.enroll(new StudentImpl("FirstnameB LastnameB"));
    }

    private String getReportContent(String filename) throws IOException {
	Reader reader = new FileReader(filename);
	final String content;
	try {
	    content = readToTheEnd(reader);
	}
	finally {
	    reader.close();
	}
	return content.toString();
    }

    private String readToTheEnd(Reader reader) throws IOException {
	StringBuilder content = new StringBuilder();

	while (true) {
	    int codepoint = reader.read();
	    if (isEndReached(codepoint))
		break;
	    content.append((char)codepoint);
	}
	return content.toString();
    }

    private boolean isEndReached(int codepoint) {
	return codepoint == -1;
    }

    private void assertContents(String actual) {
	assertEquals(String.format(RosterReporter.HEADER) +
		     String.format(RosterReporter.LINE, "FirstnameA LastnameA") +
		     String.format(RosterReporter.LINE, "FirstnameB LastnameB") +
		     String.format(RosterReporter.FOOTER, 2), actual);
    }
}
