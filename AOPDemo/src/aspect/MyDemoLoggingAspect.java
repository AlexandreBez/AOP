package aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    
    @Before("execution(* dao.*.(..))")
    public void beforeAddAccountAdvice(){

        System.out.println("\n========>> Executing @Before");


    }
}