package sis.studentinfo;

import junit.framework.TestCase;

public class BankAccountTest extends TestCase {

    public void testCreateBankAccount() {
	final String aba = "102000012";
	Bank bank = new Bank(aba);
	final String number = "194431518811";
	BankAccount.Type type = BankAccount.Type.CHECKING;
	BankAccount account =
	    new BankAccount(bank, number, type);

	assertEquals(aba, account.getAba());
	assertEquals(number, account.getNumber());
	assertEquals(type, account.getType());
    }

}
