package BankProduct;

import Bank.*;
import BankOperation.*;
import BankProduct.Decorators.BankProductAccountWithDebit;
import Interest.InterestAnnual;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankProductTest {
    BankProductAccount account;
    BankOperationInterface operation;
    Bank bank;

    @BeforeEach
    void init() {
        account = new BankProductAccountWithoutDebit(new Client("Adam", "Kowalczyk"));
        bank = new Bank();
        account.setBalance(100.0f);
        bank.addAccount(account);
    }

    @Test
    void breakInvestment() {
        try {
            operation = new BankOperationCreateInvestment(account, 50.0f, new InterestAnnual(3.0f));
            bank.execute(operation);
            Assertions.assertEquals(50.0f, account.getBalance());
            Investment investment = account.getInvestment(0);
            operation = new BankOperationBreakInvestment(investment);
            bank.execute(operation);
            Assertions.assertEquals(100.0f, account.getBalance());
        } catch (Throwable t) {
            Assertions.fail("investment");
        }

    }

    @Test
    void endInvestment() {
        try {
            operation = new BankOperationCreateInvestment(account, 50.0f, new InterestAnnual(3.0f));
            bank.execute(operation);
            Assertions.assertEquals(50.0f, account.getBalance());
            Investment investment = account.getInvestment(0);
            operation = new BankOperationEndInvestment(investment);
            bank.execute(operation);
            Assertions.assertEquals(101.5f, account.getBalance());
        } catch (Throwable t) {
            Assertions.fail("investment");
        }
    }

    @Test
    void payCredit() {
        try {
            operation = new BankOperationCreateCredit(account, 50.0f, new InterestAnnual(10.0f));
            bank.execute(operation);
            Assertions.assertEquals(150.0f, account.getBalance());
            Credit credit = account.getCredit(0);
            operation = new BankOperationCreditPay(credit);
            bank.execute(operation);
            Assertions.assertEquals(95.0f, account.getBalance());
        } catch (Throwable t) {
            Assertions.fail("investment");
        }
    }

    @Test
    void payCreditException() {
        Credit credit = null;
        try {
            operation = new BankOperationCreateCredit(account, 1000.0f, new InterestAnnual(15.0f));
            bank.execute(operation);
            Assertions.assertEquals(1100.0f, account.getBalance());
            credit = account.getCredit(0);
            operation = new BankOperationCreditPay(credit);
            bank.execute(operation);
            Assertions.fail("Cannot pay credit if not enough money on account.");
        } catch (Throwable t) {
            Assertions.assertEquals(1100.0f, account.getBalance());
            Assertions.assertSame(credit, account.getCredit(0));
            operation = new BankOperationDeposit(account, 50.0f);
            try {
                bank.execute(operation);
                operation = new BankOperationCreditPay(credit);
                bank.execute(operation);
                Assertions.assertEquals(0.0f, account.getBalance());
                Assertions.assertEquals(false, account.containsCredit(credit));
            } catch (Throwable tt) {
                Assertions.fail("payCreditException");
            }
        }
    }
}
