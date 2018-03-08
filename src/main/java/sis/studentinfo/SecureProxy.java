package sis.studentinfo;

import sis.security.PermissionException;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;

class SecureProxy implements InvocationHandler {
    private final Object target;
    private final String[] secureMethodNames;
    
    SecureProxy(Object target, String... secureMethodNames) {
	this.target = target;
	this.secureMethodNames = secureMethodNames;
    }

    public Object invoke(Object proxy, Method method, Object... args) throws Throwable {
	return invoke(method, args);
    }
    
    Object invoke(Method method, Object... args) throws Throwable {
	if (isSecure(method))
	    throw new PermissionException();

	return invokeMethodOnTarget(method, args);
    }

    private boolean isSecure(Method method) {
	for (String secureMethodName: secureMethodNames)
	    if (method.getName().equals(secureMethodName))
		return true;
	return false;
    }

    private Object invokeMethodOnTarget(Method method, Object... args) throws Throwable {
	try {
	    return method.invoke(target, args);
	}
	catch (InvocationTargetException e) {
	    throw e.getTargetException();
	}
    }
}
