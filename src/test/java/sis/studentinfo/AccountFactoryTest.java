package sis.studentinfo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import junit.framework.TestCase;
import sis.security.Permission;
import sis.security.PermissionException;

public class AccountFactoryTest extends TestCase {
    private List<Method> updateMethods;
    private List<Method> readOnlyMethods;

    @Override public void setUp() throws NoSuchMethodException {
	populateUpdateMethods();
	populateReadOnlyMethods();
    }

    private void populateUpdateMethods() throws NoSuchMethodException {
	updateMethods = new ArrayList<Method>();
	updateMethods.add(Accountable.class.getDeclaredMethod("credit", BigDecimal.class));
	updateMethods.add(Accountable.class.getDeclaredMethod("transferFromBank", BigDecimal.class));
	updateMethods.add(Accountable.class.getDeclaredMethod("associateBankAccount", BankAccount.class));
    }

    private void populateReadOnlyMethods() throws NoSuchMethodException {
	readOnlyMethods = new ArrayList<Method>();
	readOnlyMethods.add(Accountable.class.getDeclaredMethod("getBalance"));
	readOnlyMethods.add(Accountable.class.getDeclaredMethod("getAverageTransaction"));
    }	
    
    public void testUpdateAccess() throws IllegalAccessException,
					  IllegalArgumentException
    {
	Accountable account = AccountFactory.create(Permission.UPDATE);

	for (Method method: readOnlyMethods)
	    assertInvokesWithoutThrowingPermissionException(account, method);

	for (Method method: updateMethods)
	    assertInvokesWithoutThrowingPermissionException(account, method);	    
    }

    public void testReadOnlyAccess() throws IllegalAccessException,
					    IllegalArgumentException
    {
	Accountable account = AccountFactory.create(Permission.READ_ONLY);

	for (Method method: readOnlyMethods)
	    assertInvokesWithoutThrowingPermissionException(account, method);

	for (Method method: updateMethods)
	    assertThrowsPermissionExceptionWhenInvoked(account, method);
    }

    private void assertInvokesWithoutThrowingPermissionException(Accountable account,
								 Method method) throws IllegalAccessException,
										       IllegalArgumentException
    {
	try {
	    method.invoke(account, makeNullArguments(method));
	}
	catch (InvocationTargetException e) {
	    assertFalse(e.getCause().getClass() == PermissionException.class);
	}
    }

    private void assertThrowsPermissionExceptionWhenInvoked(Accountable account,
							    Method method) throws IllegalAccessException,
										  IllegalArgumentException
    {
	try {
	    method.invoke(account, makeNullArguments(method));
	    fail();
	}
	catch (InvocationTargetException e) {
	    assertTrue(e.getCause().getClass() == PermissionException.class);
	}
    }
    
    private Object[] makeNullArguments(Method method) {
	return new Object[method.getParameterCount()];
    }
}
