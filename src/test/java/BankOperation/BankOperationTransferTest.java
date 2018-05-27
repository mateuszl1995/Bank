package BankOperation;

import Bank.Client;
import BankProduct.BankProductAccountWithoutDebit;
import BankProduct.Decorators.BankProductAccountWithDebit;
import Interest.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankOperationTransferTest {

    private BankOperationTransfer operation;

    int destinationNumber;
    BankProductAccountWithoutDebit account1;
    BankProductAccountWithoutDebit account2;    Client client = new Client("John", "Doe");
    Interest interest = new InterestAnnual(10);


    @BeforeEach
    void init() {
        operation = new BankOperationTransfer(account1, destinationNumber, 50);
        account1 = new BankProductAccountWithoutDebit(client,interest);
        account2 = new BankProductAccountWithoutDebit(client,interest);


    }

    @Test
    void executen(){
        account1.setBalance(100);
        account2.setBalance(100);
        try {
            Assertions.assertEquals(BankOperationInterface.State.SUCCESS, operation.executeOperation());
        } catch (Throwable e){}
    }


}
