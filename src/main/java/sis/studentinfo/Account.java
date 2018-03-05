package sis.studentinfo;

import com.jimbob.ach.Ach;
import com.jimbob.ach.AchResponse;
import com.jimbob.ach.AchStatus;
import com.jimbob.ach.AchTransactionData;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

class Account {
    private final List<BigDecimal> transactions = new ArrayList<BigDecimal>();
    private Ach ach;
    private BankAccount associatedBankAccount;
    
    void setAch(Ach ach) {
	this.ach = ach;
    }
    
    BigDecimal getBalance() {
	BigDecimal balance = new BigDecimal("0.00");
	for (BigDecimal transaction: transactions)
	    balance = balance.add(transaction);
	return balance;
    }

    void credit(BigDecimal amount) {
	transactions.add(amount);
    }

    BigDecimal getAverageTransaction() {
	if (transactions.isEmpty())
	    throw new NoRegisteredTransactionsException();
	
	BigDecimal numberOfTransactions = new BigDecimal(transactions.size());
	return getBalance().divide(numberOfTransactions, 4, RoundingMode.HALF_UP);
    }

    void transferFromBank(BigDecimal amount) {
	AchResponse response = ach.issueDebit(null, makeTransactionData(amount));
	if (isSuccessful(response))
	    credit(amount);
    }

    private boolean isSuccessful(AchResponse response) {
	return response.status == AchStatus.SUCCESS;
    }

    private AchTransactionData makeTransactionData(BigDecimal amount) {
	AchTransactionData data = new AchTransactionData();
	data.amount = amount;
	data.aba = associatedBankAccount.getAba();
	data.account = associatedBankAccount.getNumber();
	data.accountType = associatedBankAccount.getType().toString();
	return data;
    }

    void associateBankAccount(BankAccount account) {
	associatedBankAccount = account;
    }
}
