package BankProduct;

import Bank.*;
import BankOperation.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankProductAccountTest {
    BankProductAccount account;
    BankOperationInterface operation;
    Bank bank;

    @BeforeEach
    void init() {
        account = new BankProductAccountWithoutDebit(new Client("Jan", "Kowalski"));
        account.setBalance(100.0f);
        bank = new Bank();
        bank.addAccount(account);
    }

    @Test
    void checkBalance() {
        Assertions.assertEquals(100.0f, account.getBalance());
    }

    @Test
    void withdraw() {
        operation = new BankOperationWithdraw(account, 70.0f);
        try {
            bank.execute(operation);
        } catch (Throwable t) {
            Assertions.fail("withdraw");
        }
        Assertions.assertEquals(30.0f, account.getBalance());
    }

    @Test
    void withdraw2() {
        operation = new BankOperationWithdraw(account, 170.0f);
        try {
            bank.execute(operation);
            Assertions.fail("withdraw2");
        } catch (Throwable t) {
            Assertions.assertEquals(100.0f, account.getBalance());
        }

    }

    @Test
    void deposit() {
        operation = new BankOperationDeposit(account, 40.0f);
        try {
            bank.execute(operation);
        } catch (Throwable t) {
            Assertions.fail("deposit");
        }
        Assertions.assertEquals(140.0f, account.getBalance());
    }

    @Test
    void transfer() {
        BankProductAccount account2 = new BankProductAccountWithoutDebit(new Client("Marek", "Nowak"));
        bank.addAccount(account2);
        operation = new BankOperationTransfer(account, account2.getNumber(), 30.0f);
        try {
            bank.execute(operation);
        } catch (Throwable t) {
            Assertions.fail("deposit");
        }
        Assertions.assertEquals(70.0f, account.getBalance());
        Assertions.assertEquals(30.0f, account2.getBalance());
    }

    @Test
    void operationsAndHistory() {
        try {
            operation = new BankOperationWithdraw(account, 70.0f);
            bank.execute(operation);
            BankProductAccount account2 = new BankProductAccountWithoutDebit(new Client("Marek", "Nowak"));
            bank.addAccount(account2);
            operation = new BankOperationTransfer(account, account2.getNumber(), 30.0f);
            bank.execute(operation);
            operation = new BankOperationDeposit(account, 40.0f);
            bank.execute(operation);
        } catch (Throwable t) {
            Assertions.fail("withdraw");
        }
        Assertions.assertEquals(40.0f, account.getBalance());

        String[] expected = new String[]{ "WITHDRAW", "TRANSFER", "DEPOSIT"};
        for (int i = 0; i < 3; i++) {
            String description = account.getHistory().get(i).getDescription();
            Assertions.assertTrue(description.contains(expected[i]));
        }
    }
}
