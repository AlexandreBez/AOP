package dao;

import org.springframework.stereotype.Component;

import aop.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println("stuff 2");
	}

	public boolean doWork(){

		System.out.println("stuff 3");
		return false;
	}

    /**
     * @return String return the name
     */
    public String getName() {
		System.out.println(getClass() + ": in getName()");
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    /**
     * @return String return the serviceCode
     */
    public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    /**
     * @param serviceCode the serviceCode to set
     */
    public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode");
        this.serviceCode = serviceCode;
    }



}
