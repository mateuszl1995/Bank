package Bank;

import BankOperation.BankOperationDeposit;
import BankOperation.BankOperationInterface;
import BankOperation.BankOperationTransfer;
import BankProduct.BankProductAccount;
import BankProduct.BankProductAccountWithoutDebit;
import BankProduct.Decorators.BankProductAccountWithDebit;
import Interest.Interest;
import Interest.InterestZero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


public class BankTest {

    private BankInterface bank;
    private Client client = new Client("asdasf","asdasdqw");
    private Interest interest = new InterestZero();
    private BankProductAccount account1;
    private BankProductAccount account2;
    private BankMediatorInterface mediator;

    @BeforeEach
    void init(){
        mediator = new BankMediator();
        bank = new Bank(mediator);
        account1 = new BankProductAccountWithoutDebit(client, interest);
        account2 = new BankProductAccountWithoutDebit(client, interest);
    }

    @Test
    void accountsList(){
        bank.addAccount(account1);
        bank.addAccount(account2);
        Assertions.assertEquals(account1, bank.getAccountsList().get(0));
        Assertions.assertEquals(account2, bank.getAccountsList().get(1));
    }

    @Test
    void history(){
        BankOperationInterface operation = new BankOperationTransfer(account1, account2.getNumber(), 0);
        bank.addToHistory(operation);
        Assertions.assertTrue(bank.getHistory().getList().contains(operation));
    }


    @Test
    void acceptOperationDepositForeignAccount(){
        BankOperationInterface operation = new BankOperationDeposit(account1, 10);
        Assertions.assertFalse(bank.acceptOperation(operation));
    }

    @Test
    void acceptOperationDepositNullAccount(){
        BankOperationInterface operation = new BankOperationDeposit(null, 10);
        Assertions.assertFalse(bank.acceptOperation(operation));
    }

    @Test
    void acceptOperationDeposit(){
        bank.addAccount(account1);
        BankOperationInterface operation = new BankOperationDeposit(account1, 10);
        Assertions.assertTrue(bank.acceptOperation(operation));
    }

    @Test
    void acceptOperationTransfer(){
        bank.addAccount(account2);
        BankOperationInterface operation = new BankOperationTransfer(account1, account2.getNumber(), 0);
        Assertions.assertTrue(bank.acceptOperation(operation));
    }

    @Test
    void acceptOperationNumberNotFound(){
        bank.addAccount(account1);
        BankOperationInterface operation = new BankOperationTransfer(account1, account2.getNumber(), 0);
        Assertions.assertFalse(bank.acceptOperation(operation));
    }

    @Test
    void acceptOperationTransferWrongNumber(){
        BankOperationInterface operation = new BankOperationTransfer(account1, 1234, 0);
        Assertions.assertFalse(bank.acceptOperation(operation));
    }

    @Test
    void executeTransferLocal(){
        bank.addAccount(account1);
        bank.addAccount(account2);
        BankOperationInterface operation = new BankOperationTransfer(account1, account2.getNumber(), 0);
        try {
            bank.execute(operation);
        } catch (Throwable t) {
            Assertions.fail("executeTransferLocal");
        }
    }

    @Test
    void executeTransferAnotherBank(){
        bank.addAccount(account1);
        BankInterface bank2 = new Bank(mediator);
        mediator.addBank(bank2);
        bank2.addAccount(account2);
        BankOperationInterface operation = new BankOperationTransfer(account1, account2.getNumber(), 0);
        try {
            bank.execute(operation);
        } catch (Throwable t) {
            Assertions.fail("executeTransferAnotherBank");
        }
    }

    @Test
    void executeTransferUnknownAccount(){
        bank.addAccount(account1);
        BankOperationInterface operation = new BankOperationTransfer(account1, account2.getNumber(), 0);
        Executable executable = () -> bank.execute(operation);
        Assertions.assertThrows(BankInterface.AccountNumberNotFoundException.class, executable);
    }

    @Test
    void executeTransferWrongHostLocal(){
        bank.addAccount(account2);
        BankOperationInterface operation = new BankOperationTransfer(account1, account2.getNumber(), 0);
        Executable executable = () -> bank.execute(operation);
        Assertions.assertThrows(BankInterface.AccountNumberNotFoundException.class, executable);
    }

    @Test
    void executeTransferWrongHost(){
        BankInterface bank2 = new Bank(mediator);
        mediator.addBank(bank2);
        bank2.addAccount(account1);
        bank2.addAccount(account2);
        BankOperationInterface operation = new BankOperationTransfer(account1, account2.getNumber(), 0);
        Executable executable = () -> bank.execute(operation);
        Assertions.assertThrows(BankInterface.AccountNumberNotFoundException.class, executable);

    }

    @Test
    void executeDeposit(){
        bank.addAccount(account1);
        BankOperationInterface operation = new BankOperationDeposit(account1, 0.f);
        try {
            bank.execute(operation);
        } catch (Throwable t) {
            Assertions.fail("execute Deposit");
        }
    }


    @Test
    void executeDepositForeignAccount(){
        BankOperationInterface operation = new BankOperationDeposit(account1, 0.f);
        Executable executable = () -> bank.execute(operation);
        Assertions.assertThrows(BankInterface.AccountNumberNotFoundException.class, executable);

    }


    @Test
    void executeDepositNullAccount(){
        BankOperationInterface operation = new BankOperationDeposit(null, 0.f);
        Executable executable = () -> bank.execute(operation);
        Assertions.assertThrows(BankInterface.AccountNumberNotFoundException.class, executable);

    }

}
