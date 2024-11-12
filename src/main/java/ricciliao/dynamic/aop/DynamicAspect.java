package ricciliao.dynamic.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class DynamicAspect implements MethodBeforeAdvice, AfterReturningAdvice, DynamicThrowsAdvice, MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        return invocation.proceed();
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target){
        //Override
    }

    @Override
    public void before(Method method, Object[] args, Object target){
        //Override
    }

    @Override
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex){
        //Override
    }

}
