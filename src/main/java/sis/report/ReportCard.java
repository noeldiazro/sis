package sis.report;

import java.util.Map;
import java.util.EnumMap;
import sis.studentinfo.Grade;

class ReportCard {
    static final String MESSAGE_A = "Excellent";
    static final String MESSAGE_B = "Very good";
    static final String MESSAGE_C = "Hmmm...";
    static final String MESSAGE_D = "You're not trying";
    static final String MESSAGE_F = "Loser";

    private Map<Grade, String> messages;

    String getMessage(Grade grade) {
	return getMessages().get(grade);
    }

    private Map<Grade, String> getMessages() {
	if (messages == null) {
	    loadMessages();
	}
	return messages;
    }

    private void loadMessages() {
	messages = new EnumMap(Grade.class);
	messages.put(Grade.A, MESSAGE_A);
	messages.put(Grade.B, MESSAGE_B);
	messages.put(Grade.C, MESSAGE_C);
	messages.put(Grade.D, MESSAGE_D);
	messages.put(Grade.F, MESSAGE_F);
    }

}
