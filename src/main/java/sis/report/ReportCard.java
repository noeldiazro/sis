package sis.report;

import java.util.Map;
import java.util.EnumMap;
import sis.studentinfo.Student;

class ReportCard {
    static final String MESSAGE_A = "Excellent";
    static final String MESSAGE_B = "Very good";
    static final String MESSAGE_C = "Hmmm...";
    static final String MESSAGE_D = "You're not trying";
    static final String MESSAGE_F = "Loser";

    private Map<Student.Grade, String> messages;

    String getMessage(Student.Grade grade) {
	return getMessages().get(grade);
    }

    private Map<Student.Grade, String> getMessages() {
	if (messages == null) {
	    loadMessages();
	}
	return messages;
    }

    private void loadMessages() {
	messages = new EnumMap(Student.Grade.class);
	messages.put(Student.Grade.A, MESSAGE_A);
	messages.put(Student.Grade.B, MESSAGE_B);
	messages.put(Student.Grade.C, MESSAGE_C);
	messages.put(Student.Grade.D, MESSAGE_D);
	messages.put(Student.Grade.F, MESSAGE_F);
    }

}
