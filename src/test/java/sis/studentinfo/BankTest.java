package sis.studentinfo;

import junit.framework.TestCase;

public class BankTest extends TestCase {
    private static final String ABA = "102000012";
    
    public void testCreateBank() {
	createBankAssertingAba(ABA);
    }

    public void testCreateAnotherBank() {
	createBankAssertingAba("213111123");
    }

    private void createBankAssertingAba(String aba) {
	Bank bank = new Bank(aba);
	assertEquals(aba, bank.getAba());
    }
}
