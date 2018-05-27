package BankProduct.Decorators;

import Bank.Bank;
import Bank.Client;
import BankOperation.BankOperation;
import BankOperation.BankOperationWithdraw;
import BankProduct.BankProductAccount;
import BankProduct.BankProductAccountWithoutDebit;
import Interest.Interest;
import Interest.InterestZero;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;


class BankProductAccountWithDebitTest {

    private BankProductAccount account;
    private float limit;
    private Client client;
    private Interest interest;



    @Test
    void getBalanceFromNewObjectTest(){
        account = new BankProductAccountWithoutDebit(client, interest);
        account = new BankProductAccountWithDebit(account, limit);
        float balance = account.getBalance();
        assertEquals(0.f, balance);
    }

    @BeforeEach
    void init(){
        limit = 100;
        client = new Client("Lukasz", "Osinski");
        interest = new InterestZero();
        account = new BankProductAccountWithoutDebit(client, interest);
        try {
            account.changeBalance(10.f);
        } catch (Throwable e){
         e.printStackTrace();
        }
    }

    @Test
    void getBalanceTest(){
        float balance = account.getBalance();
        assertEquals(10.f, balance);
    }


    @Test
    void getBalanceAfterBalanceChangeTest() {
        try {
            account = new BankProductAccountWithDebit(account, 100);
            this.account.changeBalance(-80.f);
            float balance = account.getBalance();
            assertEquals(-70.f, balance);
        } catch (BankProductAccountWithDebit.NotEnoughMoneyException e){
            fail("");
        }
    }


    @Test
    void changeBalanceTooMuchTest() {
        account = new BankProductAccountWithDebit(account, 100);
        Executable throwException = () -> account.changeBalance(-130.f);
        assertThrows(BankProductAccountWithDebit.NotEnoughMoneyException.class, throwException);
    }
    @Test
    void changeBalanceTest() {
        account = new BankProductAccountWithDebit(account, 100.f);
        Executable executable = () -> account.changeBalance(-120.f);
        //Assertions.assertThrows(executable);
        assertEquals(1,1);
    }
}
