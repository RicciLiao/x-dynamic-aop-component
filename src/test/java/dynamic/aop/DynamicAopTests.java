package dynamic.aop;

import dynamic.DynamicAopApplication;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ricciliao.dynamic.aop.DynamicAspect;
import ricciliao.dynamic.aop.DynamicPointcutAdvisor;

import java.lang.reflect.Method;

@ExtendWith(value = {MockitoExtension.class, SpringExtension.class})
@SpringBootTest(classes = DynamicAopApplication.class)
@ContextConfiguration(classes = {DynamicAopTests.Config.class})
class DynamicAopTests {

    @Autowired
    private Component component;
    @Autowired
    private DynamicPointcutAdvisor dynamicPointcutAdvisorPointA;
    @Autowired
    private DynamicPointcutAdvisor dynamicPointcutAdvisorPointB;

    @BeforeEach
    public void setUp() {

    }

    @Test
    void dynamicPointcutAdvisorPointA() throws Throwable {
        boolean arg = true;
        Object[] args = new Object[]{arg};
        Component stComponent = (Component) AopProxyUtils.getSingletonTarget(component);
        Method method = stComponent.getClass().getMethod("pointA", boolean.class);
        DynamicAspect dynamicAspect = (DynamicAspect) dynamicPointcutAdvisorPointA.getAdvice();
        MockitoException ex = new MockitoException("");
        component.pointA(arg);
        InOrder inOrder = Mockito.inOrder(dynamicAspect);
        inOrder.verify(dynamicAspect).invoke(ArgumentMatchers.any(MethodInvocation.class));
        inOrder.verify(dynamicAspect).before(method, args, stComponent);
        inOrder.verify(dynamicAspect).afterReturning(arg, method, args, stComponent);
        Mockito.verify(dynamicAspect, VerificationModeFactory.times(0)).afterThrowing(method, args, stComponent, ex);
        Mockito.reset(dynamicAspect);
        Mockito.when(stComponent.pointA(true)).thenThrow(ex);
        Assertions.assertThrows(MockitoException.class, () -> component.pointA(arg));
        inOrder = Mockito.inOrder(dynamicAspect);
        inOrder.verify(dynamicAspect).invoke(ArgumentMatchers.any(MethodInvocation.class));
        inOrder.verify(dynamicAspect).before(method, args, stComponent);
        inOrder.verify(dynamicAspect).afterThrowing(method, args, stComponent, ex);
        Mockito.verify(dynamicAspect, VerificationModeFactory.times(0)).afterReturning(arg, method, args, stComponent);
    }

    @Test
    void dynamicPointcutAdvisorPointB() throws Throwable {
        boolean arg = true;
        Object[] args = new Object[]{arg};
        Component stComponent = (Component) AopProxyUtils.getSingletonTarget(component);
        Method method = stComponent.getClass().getMethod("pointB", boolean.class);
        DynamicAspect dynamicAspect = (DynamicAspect) dynamicPointcutAdvisorPointB.getAdvice();
        MockitoException ex = new MockitoException("");
        component.pointB(arg);
        InOrder inOrder = Mockito.inOrder(dynamicAspect);
        inOrder.verify(dynamicAspect).invoke(ArgumentMatchers.any(MethodInvocation.class));
        inOrder.verify(dynamicAspect).before(method, args, stComponent);
        inOrder.verify(dynamicAspect).afterReturning(arg, method, args, stComponent);
        Mockito.verify(dynamicAspect, VerificationModeFactory.times(0)).afterThrowing(method, args, stComponent, ex);
        Mockito.reset(dynamicAspect);
        Mockito.when(stComponent.pointB(true)).thenThrow(ex);
        Assertions.assertThrows(MockitoException.class, () -> component.pointB(arg));
        inOrder = Mockito.inOrder(dynamicAspect);
        inOrder.verify(dynamicAspect).invoke(ArgumentMatchers.any(MethodInvocation.class));
        inOrder.verify(dynamicAspect).before(method, args, stComponent);
        inOrder.verify(dynamicAspect).afterThrowing(method, args, stComponent, ex);
        Mockito.verify(dynamicAspect, VerificationModeFactory.times(0)).afterReturning(arg, method, args, stComponent);
    }

    static class Component {

        public boolean pointA(boolean b) {

            return b;
        }

        public boolean pointB(boolean b) {

            return b;
        }

    }

    static class Config {
        @Bean
        public DynamicAopTests.Component component() {

            return Mockito.spy(new DynamicAopTests.Component());
        }

        @Bean
        public DynamicPointcutAdvisor dynamicPointcutAdvisorPointA() {

            return new DynamicPointcutAdvisor(
                    "execution(public boolean dynamic.aop.DynamicAopTests.Component.pointA(boolean))",
                    Mockito.spy(new DynamicAspect())
            );
        }

        @Bean
        public DynamicPointcutAdvisor dynamicPointcutAdvisorPointB() {

            return new DynamicPointcutAdvisor(
                    "execution(public boolean dynamic.aop.DynamicAopTests.Component.pointB(boolean))",
                    Mockito.spy(new DynamicAspect())
            );
        }
    }

}