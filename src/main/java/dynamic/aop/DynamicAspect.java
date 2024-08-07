package dynamic.aop;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class DynamicAspect implements MethodInterceptor, AfterReturningAdvice, ThrowsAdvice, MethodBeforeAdvice {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        //do something
        return invocation.proceed();
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        //do something
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        //do something
    }

    public void afterThrowing(Method method, Object[] args, Object target, Exception exception) {
        //do something
    }

}
