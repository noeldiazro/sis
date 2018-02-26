package sis.studentinfo;

import java.math.BigDecimal;
import junit.framework.TestCase;

public class AccountTest extends TestCase {
    private Account account;

    @Override public void setUp() throws Exception {
	super.setUp();
	account = new Account();
    }
    
    public void testAccountHasZeroBalanceOnCreation() {
	BigDecimal expectedBalance = new BigDecimal("0.00");
	assertEquals(expectedBalance, account.getBalance());
    }

    public void testCreditAccount() {
	account.credit(new BigDecimal("0.10"));
	account.credit(new BigDecimal("11.00"));

	BigDecimal expectedBalance = new BigDecimal("11.10");
	assertEquals(expectedBalance, account.getBalance());
    }

    public void testTransactionAverage_NoTransactions() {
	try {
	    account.getAverageTransaction();
	    fail();
	}
	catch (NoRegisteredTransactionsException e) {
	}
    }

    public void testTransactionAverage_HasTransactions() {
	account.credit(new BigDecimal("0.10"));
	account.credit(new BigDecimal("11.00"));
	account.credit(new BigDecimal("5.00"));

	assertEquals(new BigDecimal("5.3667"), account.getAverageTransaction());
    }
}

