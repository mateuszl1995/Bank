package BankProduct;

import Bank.Client;
import BankOperation.BankOperation;
import BankProduct.Decorators.BankProductAccountWithDebit;
import Interest.Interest;
import Report.ReportVisitorInterface;

public interface BankProductAccount extends BankProductInterface{
    
    long getNumber();
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

    BankProductAccount getAccount();

    void acceptReport(ReportVisitorInterface visitor);


    void historyAdd(BankOperation bankOperation);
}
