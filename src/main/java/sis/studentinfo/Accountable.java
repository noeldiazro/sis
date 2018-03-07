package sis.studentinfo;

import java.math.BigDecimal;

interface Accountable {
    void credit(BigDecimal amount);
    void transferFromBank(BigDecimal amount);
    void associateBankAccount(BankAccount account);
    BigDecimal getBalance();
    BigDecimal getAverageTransaction();
}
