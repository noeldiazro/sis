package sis.studentinfo;

import java.math.BigDecimal;
import sis.security.Permission;
import sis.security.PermissionException;

class AccountFactory {
    static Accountable create(Permission permission) {
	if (permission == Permission.READ_ONLY)
	    return new Account() {
		@Override public void credit(BigDecimal amount) {
		    throw new PermissionException();
		}

		@Override public void transferFromBank(BigDecimal amount) {
		    throw new PermissionException();
		}

		@Override public void associateBankAccount(BankAccount account) {
		    throw new PermissionException();
		}
	    };
	return new Account();
    }
}
