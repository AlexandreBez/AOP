package aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
											new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> theAccounts = null;

		try{ 
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);


		}catch(Exception exc){
			System.out.println(exc);
		}
			System.out.println(theAccounts);
		
			context.close();
		
			
	}

}
