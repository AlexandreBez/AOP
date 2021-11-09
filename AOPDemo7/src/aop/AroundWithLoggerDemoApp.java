package aop;

import java.lang.System.Logger;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.AccountDAO;
import service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
											new AnnotationConfigApplicationContext(DemoConfig.class);

		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		String data = theFortuneService.getFortune();

		myLogger.info(data);
		
		context.close();
	}

}
