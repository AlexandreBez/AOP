package dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    
    public void addAccount() {

        System.out.println(getClass() + ": some stuff");
    }

    public void goToSleep(){
        System.out.println(getClass() + ": some stuff 2");
    }
}