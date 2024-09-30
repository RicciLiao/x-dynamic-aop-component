package ricciliao.dynamic.aop;

import org.springframework.aop.support.DefaultPointcutAdvisor;

public class DynamicPointcutAdvisor extends DefaultPointcutAdvisor {

    public DynamicPointcutAdvisor(String expression, DynamicAspect aspect) {
        super(new DynamicAspectPointcut(expression), aspect);
    }

}
