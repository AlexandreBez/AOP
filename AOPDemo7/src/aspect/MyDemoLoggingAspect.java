package aspect;

import java.lang.System.Logger;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import aop.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Around("execution(* dao.AccountDAO.findAccounts(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{

        String method = theProceedingJoinPoint.getSignature().toShortString();

        System.out.println(method);

        long begin = System.currentTimeMillis();

        Object result = null;
        
        try{ 
            result = theProceedingJoinPoint.proceed();
        }catch(Exception exc){
            myLogger.warning(exc.getMessage());

            throw exc;
        }

        long end = System.currentTimeMillis();

        long duration = end - begin;

        System.out.println(duration / 1000.0 );

        return result;
    }

    @After("execution(* dao.AccountDAO.findAccounts(..))")
    public void AfterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){

        String method = theJoinPoint.getSignature().toShortString();

        System.out.println(method);

    }

    @AfterThrowing(pointcut = "execution(* dao.AccountDAO.findAccounts(..))", throwing = "theExc")
    public void AfterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc){

        String method = theJoinPoint.getSignature().toShortString();

        System.out.println(method);

        System.out.println(theExc);

    }

    @AfterReturning(pointcut = "execution(* dao.AccountDAO.findAccounts(..))", returning = "result")
    public void AfterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){
        
        String method = theJoinPoint.getSignature().toShortString();

        System.out.println(method);

        System.out.println(result);

        covertAccountNamesToUpperCase(result);
    }
    
    private void covertAccountNamesToUpperCase(List<Account> result) {

        for(Account tempAccount : result){
            String theUpperName = tempAccount.getName().toUpperCase();

            tempAccount.setName(theUpperName);
        }
    }

    @Before("aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){

        System.out.println("\n========>> Executing @Before");

        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: "+methodSig);

        Object[] args = theJoinPoint.getArgs();

        for (Object tempArg : args){
            System.out.println(tempArg);

            if (tempArg instanceof Account) {
                Account theAccount = (Account) tempArg;

                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }
    }

}