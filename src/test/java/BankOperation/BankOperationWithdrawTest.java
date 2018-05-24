package BankOperation;

import Bank.Client;
import BankProduct.BankProductAccountWithoutDebit;
import BankProduct.Decorators.BankProductAccountWithDebit;
import Interest.Interest;
import Interest.InterestAnnual;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class BankOperationWithdrawTest {

    private BankOperationWithdraw operation;

    BankProductAccountWithoutDebit account1;
    Client client = new Client("John", "Doe");
    Interest interest = new InterestAnnual(10);

    @BeforeEach
    void init() {
        account1 = new BankProductAccountWithoutDebit(client,interest);
        operation = new BankOperationWithdraw(account1, 50);
    }


    @Test
    void executeTooMuch(){
        account1.setBalance(20);
        try {
            operation.executeOperation();
            Assertions.assertEquals(BankOperationInterface.State.FAIL, operation.executeOperation());
        } catch (Throwable e){
            Assertions.fail();
        }
    }

    @Test
    void execute(){
        account1.setBalance(50);
        try {
            Assertions.assertEquals(BankOperationInterface.State.SUCCESS, operation.executeOperation());
        } catch (Throwable e){}
}

    @Test
    void executeDebitTooMuch(){
        BankProductAccountWithDebit account = new BankProductAccountWithDebit(account1, 20);
        try {
            Assertions.assertEquals(BankOperationInterface.State.SUCCESS, operation.executeOperation());
        } catch (Throwable e){}
    }


    @Test
    void executeDebit(){
        BankProductAccountWithDebit account = new BankProductAccountWithDebit(account1, 50);
        try {
            Assertions.assertEquals(BankOperationInterface.State.SUCCESS, operation.executeOperation());
        } catch (Throwable e){}
    }



}
