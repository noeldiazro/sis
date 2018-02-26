package sis.studentinfo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

class Account {
    private final List<BigDecimal> transactions = new ArrayList<BigDecimal>();
    
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
}
