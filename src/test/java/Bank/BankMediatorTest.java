package Bank;

import BankOperation.BankOperation;
import BankOperation.BankOperationTransfer;
import BankProduct.BankProductAccount;
import BankProduct.BankProductAccountWithoutDebit;
import Interest.Interest;
import Interest.InterestZero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;

public class BankMediatorTest {

    private BankMediatorInterface mediator;
    private BankInterface bank1;
    private BankInterface bank2;
    private Client client = new Client("asd","asd");
    private Interest interest = new InterestZero();
    private BankProductAccount account1;
    private BankProductAccount account2;
    private BankProductAccount account3;
    private BankProductAccount account4;
    private BankOperation operation;


    @BeforeEach
    void init() {
        mediator = new BankMediator();
        bank1 = new Bank(mediator);
        bank2 = new Bank(mediator);
        mediator.addBank(bank1);
        mediator.addBank(bank2);
        account1 = new BankProductAccountWithoutDebit(client, interest);
        account1.setBalance(20);
        account2 = new BankProductAccountWithoutDebit(client, interest);
        account3 = new BankProductAccountWithoutDebit(client, interest);
        account4 = new BankProductAccountWithoutDebit(client, interest);
        bank1.addAccount(account1);
        bank1.addAccount(account2);
        bank2.addAccount(account3);
        bank2.addAccount(account4);
    }

    @Test
    void executeOperation() {
        operation = new BankOperationTransfer(account1, account3.getNumber(), 10);
        Assertions.assertTrue(mediator.acceptOperation(operation, bank1));
    }

    @Test
    void addBank() {
        BankInterface bank3 = new Bank(mediator);
        mediator.addBank(bank3);
        BankProductAccount account5 = new BankProductAccountWithoutDebit(client, interest);
        bank3.addAccount(account5);
        operation = new BankOperationTransfer(account2, account5.getNumber(), 0);
        Assertions.assertTrue( mediator.acceptOperation(operation, bank1));
    }


    @Test
    void acceptOperationTheSameBank() {
        operation = new BankOperationTransfer(account1, account2.getNumber(), 0);
        Assertions.assertFalse(mediator.acceptOperation(operation, bank1));

    }

    @Test
    void acceptOperationWrongNumber() {
        operation = new BankOperationTransfer(account1, 123, 0);
        Assertions.assertFalse(mediator.acceptOperation(operation, bank1));
    }



}


