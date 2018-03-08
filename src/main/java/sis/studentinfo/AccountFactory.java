package sis.studentinfo;

import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import sis.security.Permission;

class AccountFactory {
    static Accountable create(Permission permission) {
	if (permission == Permission.READ_ONLY) {
	    SecureProxy secureProxy = new SecureProxy(new Account(),
						      "credit",
						      "transferFromBank",
						      "associateBankAccount");

	    return (Accountable)Proxy.newProxyInstance(Account.class.getClassLoader(),
						       new Class<?>[] {Accountable.class},
						       secureProxy);
	}
	return new Account();
    }
}
