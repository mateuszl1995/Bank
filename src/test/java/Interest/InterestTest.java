package Interest;

import Bank.Client;
import BankProduct.BankProductAccount;
import BankProduct.BankProductAccountWithoutDebit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class InterestTest {

    private Interest interest;
    private BankProductAccount account;
    private Client client = new Client("John","Doe");


    @Test
    void interestAnnual(){
        interest = new InterestAnnual(10);
        account = new BankProductAccountWithoutDebit(client, interest);
        account.setBalance(100);
        Assertions.assertEquals(10,interest.calculateInterest(account));
    }

    @Test void interestZero(){
        interest = new InterestZero();
        account = new BankProductAccountWithoutDebit(client, interest);
        account.setBalance(100);
        Assertions.assertEquals(0,interest.calculateInterest(account));
    }
}
