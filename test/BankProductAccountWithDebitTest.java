import Bank.Client;
import BankOperation.BankOperation;
import BankOperation.BankOperationWithdraw;
import BankProduct.BankProductAccount;
import BankProduct.BankProductAccountWithDebit;
import BankProduct.BankProductAccountWithoutDebit;
import Interest.InterestZero;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class BankProductAccountWithDebitTest {
    BankProductAccount account;
    BankOperation operation;

    @Before
    void initAll() {
        account = new BankProductAccountWithDebit(new BankProductAccountWithoutDebit(new Client("Mateusz", "Lewandowski"), new InterestZero()), 100.0f);
        account.setBalance(300.0f);
    }

    @Test
    public void testWithdrawSimple () throws BankOperation.BankOperationInterface.DoubleExecutionException, BankProductAccountWithDebit.NotEnoughMoneyException {
        account = new BankProductAccountWithDebit(new BankProductAccountWithoutDebit(new Client("Mateusz", "Lewandowski"), new InterestZero()), 100.0f);
        account.setBalance(300.0f);
        operation = new BankOperationWithdraw(account, 30.0f);
        operation.execute();
        assertEquals(account.getBalance(), 270.0f);

        operation = new BankOperationWithdraw(account, 300.0f);
        operation.execute();
        assertEquals(account.getBalance(), -30.0f);
    }

    @Test
    public void testWithdrawException () throws BankOperation.BankOperationInterface.DoubleExecutionException, BankProductAccountWithDebit.NotEnoughMoneyException {
        account = new BankProductAccountWithDebit(new BankProductAccountWithoutDebit(new Client("Mateusz", "Lewandowski"), new InterestZero()), 100.0f);
        account.setBalance(300.0f);
        Executable closureContainingCodeToTest = () -> {
            operation = new BankOperationWithdraw(account, 300.0f);
            operation.execute();
            assertEquals(account.getBalance(), 0.0f);

            operation = new BankOperationWithdraw(account, 1.0f);
            operation.execute();
        };
        assertThrows(BankProductAccountWithDebit.NotEnoughMoneyException.class, closureContainingCodeToTest);
    }

}
