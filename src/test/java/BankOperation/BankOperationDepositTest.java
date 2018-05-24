package BankOperation;

import Bank.Client;
import BankProduct.BankProductAccountWithoutDebit;
import BankProduct.Decorators.BankProductAccountWithDebit;
import Interest.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class BankOperationDepositTest {


    private BankOperationDeposit operation;

    BankProductAccountWithoutDebit account1;
    Client client = new Client("John", "Doe");
    Interest interest = new InterestAnnual(10);

    @BeforeEach
    void init() {
        account1 = new BankProductAccountWithoutDebit(client,interest);
        operation = new BankOperationDeposit(account1, 50);

    }



    @Test
    void execute(){
        account1.setBalance(50);
        try {
            Assertions.assertEquals(BankOperationInterface.State.SUCCESS, operation.executeOperation());
            Assertions.assertEquals(100,account1.getBalance());

        } catch (Throwable e){
            Assertions.fail();
        }
    }

    @Test
    void executeDebit(){
        BankProductAccountWithDebit account = new BankProductAccountWithDebit(account1, 50);
        try {
            account.changeBalance(-20.f);
            operation.executeOperation();
        } catch (Throwable e){
            Assertions.fail();
        }
        Assertions.assertEquals(30,account.getBalance());
    }


}
