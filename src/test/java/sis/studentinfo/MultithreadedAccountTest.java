package sis.studentinfo;

import java.math.BigDecimal;
import junit.framework.TestCase;

public class MultithreadedAccountTest extends TestCase {
    private Account account;

    @Override public void setUp() {
	account = new Account();
	account.credit(new BigDecimal("100.00"));	
    }
	    
    public void testConcurrency() throws InterruptedException {
	BigDecimal amount0 = new BigDecimal("80.00");
	Thread t0 = new Thread(getWithdrawer(amount0));
	BigDecimal amount1 = new BigDecimal("60.00");
	Thread t1 = new Thread(getWithdrawer(amount1));

	t0.start();
	t1.start();

	t0.join();
	t1.join();

	assertEquals(new BigDecimal("20.00"), account.getBalance());
    }

    private Runnable getWithdrawer(BigDecimal amount) {
	return new Runnable() {
	    public void run() {
		try {
		    account.withdraw(amount);
		}
		catch (InsufficientFundsException e) {}
	    }
	};
    }
}
