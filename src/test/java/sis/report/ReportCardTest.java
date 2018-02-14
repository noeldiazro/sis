package sis.report;

import junit.framework.TestCase;
import sis.studentinfo.Grade;

public class ReportCardTest extends TestCase {
    public void testMessage() {
	ReportCard card = new ReportCard();
	assertEquals(ReportCard.MESSAGE_A, card.getMessage(Grade.A));
	assertEquals(ReportCard.MESSAGE_B, card.getMessage(Grade.B));
	assertEquals(ReportCard.MESSAGE_C, card.getMessage(Grade.C));
	assertEquals(ReportCard.MESSAGE_D, card.getMessage(Grade.D));
	assertEquals(ReportCard.MESSAGE_F, card.getMessage(Grade.F));	
    }
}
