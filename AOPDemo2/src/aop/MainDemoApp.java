package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.AccountDAO;
import dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
											new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		Account myAccount = new Account();

		theMembershipDAO.addAccount();
		theMembershipDAO.goToSleep();

		theAccountDAO.setName("Anderson");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		context.close();

	}

}
