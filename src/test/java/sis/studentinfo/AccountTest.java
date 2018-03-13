package sis.studentinfo;

import com.jimbob.ach.Ach;
import com.jimbob.ach.AchCredentials;
import com.jimbob.ach.AchResponse;
import com.jimbob.ach.AchStatus;
import com.jimbob.ach.AchTransactionData;
import java.math.BigDecimal;
import junit.framework.TestCase;

public class AccountTest extends TestCase {
    private static final String BANK_ACCOUNT_ABA = "102000012";
    private static final String BANK_ACCOUNT_NUMBER = "194431518811";
    private static final BigDecimal BANK_TRANSFER_AMOUNT;
    static {
	BANK_TRANSFER_AMOUNT = new BigDecimal("50.00");
    }
    
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

    public void testTransferFromBank_Success() {
	account.associateBankAccount(new BankAccount(new Bank(BANK_ACCOUNT_ABA),
						     BANK_ACCOUNT_NUMBER,
						     BankAccount.Type.CHECKING));
	account.setAch(createMockAch(AchStatus.SUCCESS));
	account.transferFromBank(BANK_TRANSFER_AMOUNT);
	assertEquals(BANK_TRANSFER_AMOUNT, account.getBalance());
    }


    public void testTransferFromBank_Failure() {
	account.associateBankAccount(new BankAccount(new Bank(BANK_ACCOUNT_ABA),
						     BANK_ACCOUNT_NUMBER,
						     BankAccount.Type.CHECKING));
	account.setAch(createMockAch(AchStatus.FAILURE));
	account.transferFromBank(BANK_TRANSFER_AMOUNT);
	assertEquals(new BigDecimal("0.00"), account.getBalance());
    }

    private Ach createMockAch(AchStatus status) {
	return new MockAch() {
		@Override public AchResponse issueDebit(AchCredentials credentials,
					      AchTransactionData data) {

		    assertData(data);
		    AchResponse response = new AchResponse();
		    response.status = status;
		    return response;
		}

	    private void assertData(AchTransactionData data) {
		assertEquals(BANK_TRANSFER_AMOUNT, data.amount);
		assertEquals(BANK_ACCOUNT_ABA, data.aba);
		assertEquals(BANK_ACCOUNT_NUMBER, data.account);
		assertEquals("CHECKING", data.accountType);
	    }
	};
    }

    
    private class MockAch implements Ach {
	public AchResponse issueDebit(AchCredentials credentials,
				      AchTransactionData data) {
	    throw new UnsupportedOperationException();
	}
	
	public AchResponse markTransactionAsNSF(AchCredentials credentials,
						AchTransactionData data,
						String traceCode) {
	    throw new UnsupportedOperationException();
	}

	public AchResponse refundTransaction(AchCredentials credentials,
					     AchTransactionData data,
					     String traceCode) {
	    throw new UnsupportedOperationException();
	}

	public AchResponse issueCredit(AchCredentials credentials,
				       AchTransactionData data) {
	    throw new UnsupportedOperationException();
	}

	public AchResponse voidSameDayTransaction(AchCredentials credentials,
						  AchTransactionData data,
						  String traceCode) {
	    throw new UnsupportedOperationException();
	}

	public AchResponse queryTransactionStatus(AchCredentials credentials,
						  AchTransactionData data,
						  String traceCode) {
	    throw new UnsupportedOperationException();
	}
    }

    public void testWithdraw_InsufficientFunds() {
	account.credit(new BigDecimal("100.00"));
	try {
	    account.withdraw(new BigDecimal("140.00"));
	    fail("InsufficientFundsException should have been thrown");
	}
	catch (InsufficientFundsException e) {}
    }

    public void testWithdraw_SufficientFunds() {
	account.credit(new BigDecimal("100.00"));
	account.withdraw(new BigDecimal("60.00"));
	assertEquals(new BigDecimal("40.00"), account.getBalance());
    }
	    
}
