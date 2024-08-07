package dynamic.aop;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;

class DynamicAspectPointcut extends AspectJExpressionPointcut {

    public DynamicAspectPointcut(String expression) {
        super();
        super.setExpression(expression);
    }

}
