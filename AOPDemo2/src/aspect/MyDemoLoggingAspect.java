package aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    
    @Pointcut("execution(* dao.*.(..))")
    private void forDaoPackage() {};

    @Pointcut("execution(* dao.*.(..))")
    private void getter() {}

    @Pointcut("execution(* dao.*.(..))")
    private void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter(){}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){

        System.out.println("\n========>> Executing @Before");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n============> stuff 5");
    }
}