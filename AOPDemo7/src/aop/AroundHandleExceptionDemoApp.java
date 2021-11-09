package aop;

import java.lang.System.Logger;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.AccountDAO;
import service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
											new AnnotationConfigApplicationContext(DemoConfig.class);

		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		boolean tripwire = true;

		String data = theFortuneService.getFortune(tripwire);

		myLogger.info(data);
		
		context.close();
	}

}
