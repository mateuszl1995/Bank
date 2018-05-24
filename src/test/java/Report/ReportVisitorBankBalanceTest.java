package Report;

import Bank.Bank;
import Bank.BankMediator;
import Bank.Client;
import BankProduct.BankProductAccount;
import BankProduct.BankProductAccountWithoutDebit;
import BankProduct.Decorators.BankProductAccountWithDebit;
import Interest.Interest;
import Interest.InterestAnnual;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ReportVisitorBankBalanceTest {

    Bank bank;
    BankProductAccountWithoutDebit account1;
    BankProductAccountWithoutDebit account2;
    BankProductAccountWithDebit account3;
    Client client = new Client("John","Doe");
    Interest interest = new InterestAnnual(10);

    @BeforeEach
    void init(){
        bank = new Bank(new BankMediator());
        account1 = new BankProductAccountWithoutDebit(client, interest);
        account2 = new BankProductAccountWithoutDebit(client, interest);
        account3 = new BankProductAccountWithDebit(new BankProductAccountWithoutDebit(client, interest), 1000);
        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);
    }
    private ReportVisitorBankBalance report;

    @Nested
    public class BankBalanceTest {


        @BeforeEach
        void initBankBalanceTest(){
            report = new ReportVisitorBankBalance();
        }

        @Test
        void getReport(){
            account1.setBalance(10);
            account3.setBalance(15);
            account2.setBalance(50);
            Assertions.assertEquals(75, report.getReport(bank.getAccountsList()));
        }
        void getReportNoBalanceSet(){
            Assertions.assertEquals(75, report.getReport(bank.getAccountsList()));
        }
    }

    @Nested
    public class BelowZero{

        BankProductAccountWithDebit account4;
        BankProductAccountWithDebit account5;
        ReportVisitorBelowZero report;
        List<BankProductAccount> belowZeroList = new ArrayList<>();

        @BeforeEach
        void initBelowZero(){
            account4 = new BankProductAccountWithDebit(account1, 200);
            account5 = new BankProductAccountWithDebit(account1, 200);
            try {
                account4.changeBalance(-10);
                account3.changeBalance(-30);
            } catch (Throwable e){e.printStackTrace();}
            bank.addAccount(account4);
            bank.addAccount(account5);
            belowZeroList.add(account3);
            belowZeroList.add(account4);
            report = new ReportVisitorBelowZero();

        }

        @Test
        void getReport(){
            Assertions.assertEquals(belowZeroList, report.getReport(bank.getAccountsList()));
        }

        @Test
        void getReportContainsAll(){
            Assertions.assertTrue(report.getReport(bank.getAccountsList()).containsAll(belowZeroList));
        }

        @Test
        void getReportTooBigList(){
            belowZeroList.add(account1);
            Assertions.assertFalse(report.getReport(bank.getAccountsList()).containsAll(belowZeroList));
        }
    }

    @Nested
    public class OverAmmount{

        List<BankProductAccount> belowZeroList = new ArrayList<>();
        ReportVisitorOverAmmount report;

        @BeforeEach
        void initOverAmmount(){
            account1.setBalance(10);
            account2.setBalance(50);
            account3.setBalance(30);

        }

        @Test
        void getReportOver30(){
            report = new ReportVisitorOverAmmount(30);
            belowZeroList.add(account2);
            Assertions.assertEquals(belowZeroList, report.getReport(bank.getAccountsList()));
        }

        @Test
        void getReportOver29(){
            report = new ReportVisitorOverAmmount(29);
            belowZeroList.add(account2);
            belowZeroList.add(account3);
            Assertions.assertEquals(belowZeroList, report.getReport(bank.getAccountsList()));
        }

    }



}
