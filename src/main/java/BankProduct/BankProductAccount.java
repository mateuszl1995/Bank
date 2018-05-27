package BankProduct;

import Bank.Client;
import Bank.History;
import BankOperation.BankOperation;
import BankProduct.Decorators.BankProductAccountWithDebit;
import Interest.Interest;
import Report.ReportVisitorInterface;

import java.util.Date;

public interface BankProductAccount extends BankProductInterface{
    
    long getNumber();
    Date getCreateDate();
    Interest getInterest();
    Client getClient();

    float getBalance();
    void setBalance(float balance);
    void changeBalance(float amount) throws BankProductAccountWithDebit.NotEnoughMoneyException;

    void addInvestment(Investment investment);
    void eraseInvestment(Investment investment);
    boolean containsInvestment(Investment investment);
    Investment getInvestment(int index);

    void addCredit(Credit credit);
    void removeCredit(Credit credit);
    boolean containsCredit(Credit credit);
    void eraseCredit(Credit credit);
    Credit getCredit(int index);

    BankProductAccount getAccount();

    void acceptReport(ReportVisitorInterface visitor);


    void historyAdd(BankOperation bankOperation);

    History getHistory();
}
