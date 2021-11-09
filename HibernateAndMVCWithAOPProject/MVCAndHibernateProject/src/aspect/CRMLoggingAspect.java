package aspect;

import java.util.Iterator;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* Controller.*.*(..)")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* service.*.*(..)")
	private void forServicePackage() {}
	
	@Pointcut("execution(* dao.*.*(..)")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	@Before("forAppFlow")
	public void before(JoinPoint theJoinPoint) {
		String theMethod = theJoinPoint.getSignature().toShortString();
		System.out.println(theMethod);
		
		Object[] args = theJoinPoint.getArgs();
		
		for(Object tempArg : args) {
			myLogger.info("argument: " + tempArg);
		}
	}
	
	@AfterReturning(pointcut = "forAppFlow", returning = "theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("method: " + theMethod);
		myLogger.info("result: " + theResult);
	}
}
