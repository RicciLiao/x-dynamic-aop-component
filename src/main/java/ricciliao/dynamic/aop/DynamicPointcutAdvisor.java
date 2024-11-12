package ricciliao.dynamic.aop;

import org.springframework.aop.support.DefaultPointcutAdvisor;

import java.io.Serial;

public class DynamicPointcutAdvisor extends DefaultPointcutAdvisor {

    @Serial
    private static final long serialVersionUID = 6245608012886563104L;

    public DynamicPointcutAdvisor(String expression, DynamicAspect aspect) {
        super(new DynamicAspectPointcut(expression), aspect);
    }

}
