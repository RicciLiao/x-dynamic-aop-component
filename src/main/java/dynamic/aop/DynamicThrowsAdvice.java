package dynamic.aop;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public interface DynamicThrowsAdvice extends ThrowsAdvice {
    void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable;
}
