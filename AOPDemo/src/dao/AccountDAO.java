package dao;

import org.springframework.stereotype.Component;

import aop.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println("stuff 2");
	}

	public boolean doWork(){

		System.out.println("stuff 3");
		return false;
	}
}
