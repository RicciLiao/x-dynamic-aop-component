package ricciliao.dynamic.aop;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import java.io.Serial;

class DynamicAspectPointcut extends AspectJExpressionPointcut {

    @Serial
    private static final long serialVersionUID = -2288528518258770337L;

    public DynamicAspectPointcut(String expression) {
        super();
        super.setExpression(expression);
    }

}
