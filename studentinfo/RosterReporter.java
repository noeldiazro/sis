package studentinfo;

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
	report.append(HEADER + NEWLINE);
	for (Student student: session) {
	    report.append(getLine(student));
	}
	report.append(FOOTER + session.getNumberOfStudents() + NEWLINE);
	return report.toString();
    }

    private String getLine(Student student) {
	return student.getName() + NEWLINE;
    }
}
