package sis.studentinfo;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import junit.framework.TestCase;
import sis.security.PermissionException;

public class SecureProxyTest extends TestCase {
    private Object object;
    private SecureProxy proxy;
    private boolean secureMethodCalled = false;
    private boolean insecureMethodCalled = false; 
	
    @Override public void setUp() throws Exception {
	super.setUp();
	object = getMockObject();
	proxy = new SecureProxy(object, "secure");
    }

    private Object getMockObject() {
	return new Object() {
	    String secure() {
		secureMethodCalled = true;
		return "SECURE";
	    }

	    String insecure() {
		insecureMethodCalled = true;
		return "INSECURE";
	    }

	    void secure(String param) {
		secureMethodCalled = true;
	    }

	    void insecure(String param) {
		insecureMethodCalled = true;
	    }
	};
    }

    @Override public void tearDown() throws Exception {
	super.tearDown();
	resetCalledFlags();
    }

    private void resetCalledFlags() {
	secureMethodCalled = false;
	insecureMethodCalled = false;
    }
    
    public void testSecureMethod() throws Throwable {
	Method secureMethod = object.getClass().getDeclaredMethod("secure");
	assertPermissionExceptionThrownWithoutMethodBeingCalled(secureMethod);
    }

    public void testSecureMethodWithParam() throws Throwable {
	Method secureMethodWithParam = object.getClass().getDeclaredMethod("secure", String.class);
	assertPermissionExceptionThrownWithoutMethodBeingCalled(secureMethodWithParam, "");
    }

    private void assertPermissionExceptionThrownWithoutMethodBeingCalled(Method method, Object... args)
	throws Throwable
    {
	try {
	    proxy.invoke(method, args);
	    fail("PermissionException was expected and was not thrown");
	}
	catch (PermissionException expected) {
	    assertFalse(secureMethodCalled);
	}
    }
    
    public void testInsecureMethod() throws Throwable {
	Method insecureMethod = object.getClass().getDeclaredMethod("insecure");
	Object result = proxy.invoke(insecureMethod);
	assertTrue(insecureMethodCalled);
	assertEquals("INSECURE", (String)result);
    }

    public void testInsecureMethodWithParam() throws Throwable {
	Method insecureMethod = object.getClass().getDeclaredMethod("insecure", String.class);
	Object result = proxy.invoke(insecureMethod, "");
	assertTrue(insecureMethodCalled);
	assertNull(result);
    }
}
