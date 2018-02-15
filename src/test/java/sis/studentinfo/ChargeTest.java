package sis.studentinfo;

import junit.framework.TestCase;

public class ChargeTest extends TestCase {

    private Charge charge;

    public void setUp() {
	charge = new Charge(100);
    }
    
    public void testChargeSum() {
	Charge result = charge.sum(new Charge(200));
	assertEquals(new Charge(300), result);
    }

    public void testChargeEquality() {
	assertEquals(new Charge(100), charge);
	assertFalse(charge.equals(new Charge(200)));
    }
}
