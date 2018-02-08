package sis.report;

import junit.framework.TestCase;
import sis.studentinfo.Course;
import static sis.report.ReportConstant.NEWLINE;

public class CourseReportTest extends TestCase {

    private CourseReport report;
    
    public void setUp() {
	report = new CourseReport();
    }
    
    public void testReportWithoutCourses() {
	assertEquals("", report.getText());
    }

    public void testReportWithOneCourse() {
	report.add(new Course("ENGL", "101"));
	assertEquals("ENGL\t101" + NEWLINE, report.getText());
    }

    public void testReportWithSeveralCourses() {
	report.add(new Course("ENGL", "200"));
	report.add(new Course("CZEC", "200"));
	report.add(new Course("ITAL", "410"));
	report.add(new Course("ENGL", "101"));
	assertEquals("CZEC\t200" + NEWLINE +
		     "ENGL\t101" + NEWLINE +
		     "ENGL\t200" + NEWLINE +
		     "ITAL\t410" + NEWLINE, report.getText());
    }
}
