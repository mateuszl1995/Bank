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

    void addCredit(BankProduct.BankProductInterface credit);
    void removeCredit(BankProduct.BankProductInterface credit);
    boolean containsCredit(BankProduct.BankProductInterface credit);
    void eraseCredit(BankProduct.BankProductInterface credit);

    BankProductAccount getAccount();

    void acceptReport(ReportVisitorInterface visitor);


    void historyAdd(BankOperation bankOperation);
}
