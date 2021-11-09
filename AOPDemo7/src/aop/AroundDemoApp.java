package aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.AccountDAO;
import service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
											new AnnotationConfigApplicationContext(DemoConfig.class);

		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		String data = theFortuneService.getFortune();

		System.out.println(data);
		
		context.close();
	}

}
