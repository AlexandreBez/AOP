package aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
    
    @Pointcut("execution(* dao.*.(..))")
    public void forDaoPackage() {};

    @Pointcut("execution(* dao.*.(..))")
    public void getter() {}

    @Pointcut("execution(* dao.*.(..))")
    public void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}

}