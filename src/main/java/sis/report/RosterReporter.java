package sis.report;

import sis.studentinfo.Session;
import sis.studentinfo.Student;

class RosterReporter {
    static final String HEADER = "HEADER";
    static final String FOOTER = "FOOTER";
    static final String NEWLINE = System.lineSeparator();

    private Session session;
    
    RosterReporter(Session session) {
	this.session = session;
    }

    String getReport() {
	StringBuilder report = new StringBuilder();

	writeHeader(report);
	writeBody(report);
	writeFooter(report);
	
	return report.toString();
    }

    private String getLine(Student student) {
	return student.getName() + NEWLINE;
    }

    private void writeHeader(StringBuilder report) {
	report.append(HEADER + NEWLINE);
    }

    private void writeBody(StringBuilder report) {
	for (Student student: session) {
	    report.append(getLine(student));
	}
    }

    private void writeFooter(StringBuilder report) {
	report.append(FOOTER + session.getNumberOfStudents() + NEWLINE);
    }
}
