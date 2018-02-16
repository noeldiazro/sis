package sis.studentinfo;

import junit.framework.TestCase;

public class ScorerTest extends TestCase {
    private Scorer scorer;
    
    @Override public void setUp() {
	scorer = new Scorer();
    }
    
    public void testScoreValidInput() {
	assertEquals(75, scorer.score("75"));
    }

    public void testScoreBadInput() {
	try {
	    scorer.score("abc");
	    fail();
	}
	catch (NumberFormatException success) {
	}
    }

    public void testValidInputChecking() {
	assertTrue(scorer.isValid("75"));
	assertFalse(scorer.isValid("abc"));
    }
}

