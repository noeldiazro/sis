package sis.report;

import junit.framework.TestCase;
import sis.studentinfo.Student;

public class ReportCardTest extends TestCase {
    public void testMessage() {
	ReportCard card = new ReportCard();
	assertEquals(ReportCard.MESSAGE_A, card.getMessage(Student.Grade.A));
	assertEquals(ReportCard.MESSAGE_B, card.getMessage(Student.Grade.B));
	assertEquals(ReportCard.MESSAGE_C, card.getMessage(Student.Grade.C));
	assertEquals(ReportCard.MESSAGE_D, card.getMessage(Student.Grade.D));
	assertEquals(ReportCard.MESSAGE_F, card.getMessage(Student.Grade.F));	
    }
}
