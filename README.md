# X-Component

## *Dynamic Advice `🚀️ V1.0.0`*

### 📚 Dependency

Please refer to `dependencies-control-center` for the version number.

| groupId             | artifactId     | scope   |
|---------------------|----------------|---------|
| org.springframework | spring-aspects | compile |
| org.springframework | spring-aop     | compile |

### 📌 Usage

**Dynamic Advice** replaces the traditional definition of aspects,
no longer uses `@Aspect`, `@Before`, `@AfterReturning` and `@Pointcut`...
You can define aspects and their pointcut expression in your bean configuration class.
It makes beans and aspects configuration more clear.

***Dynamic Advice has been integrated with starter, please refer to `x-components-starter`***

### 📝 Coding

* #### DynamicAspect.class

```java
public class DynamicAspect implements MethodBeforeAdvice, AfterReturningAdvice, DynamicThrowsAdvice, MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        return invocation.proceed();
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) {
        //Override
    }

    @Override
    public void before(Method method, Object[] args, Object target) {
        //Override
    }

    @Override
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
        //Override
    }

}
```

Define your aspect class and extends `DynamicAspect.class`.

---

* #### DynamicPointcutAdvisor.class

```java
class DynamicAspectPointcut extends AspectJExpressionPointcut {

    @Serial
    private static final long serialVersionUID = -2288528518258770337L;

    public DynamicAspectPointcut(String expression) {
        super();
        super.setExpression(expression);
    }

}
```

The aspect bean registration class, you can define your aspect by this class.

for example:

```java
class BeanConfiguration {
    @Bean
    public DynamicPointcutAdvisor dynamicPointcutAdvisorPointA() {

        return new DynamicPointcutAdvisor(
                "execution(* com.example..*(..))",
                new YourDynamicAspect()
        );
    }
}
```

---

🤖 Good luck and enjoy it ~~