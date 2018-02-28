package sis.report;

import java.io.IOException;
import java.io.Writer;
import sis.studentinfo.Session;
import sis.studentinfo.Student;

class RosterReporter {
    static final String HEADER = "Student%n-------%n";
    static final String FOOTER = "# students = %d%n";
    static final String LINE = "%s%n";
    
    private Session session;
    private Writer writer;
    
    RosterReporter(Session session, Writer writer) {
	this.session = session;
	this.writer = writer;
    }

    void write() throws IOException {
	writeHeader();
	writeBody();
	writeFooter();
    }

    private void writeHeader() throws IOException {
	writer.write(String.format(HEADER));
    }

    private void writeBody() throws IOException {
	for (Student student: session) {
	    writer.write(getLine(student));
	}
    }

    private String getLine(Student student) {
	return String.format(LINE, student.getName());
    }

    private void writeFooter() throws IOException {
        writer.write(String.format(FOOTER, session.getNumberOfStudents()));
    }
}
