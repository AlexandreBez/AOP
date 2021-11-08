package aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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