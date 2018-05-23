package BankProduct;

import Bank.Client;
import BankOperation.BankOperation;
import BankProduct.Decorators.BankProductAccountWithDebit;
import Interest.Interest;
import Report.ReportVisitorInterface;

public interface BankProductAccount{
    
    long getNumber();
    Interest getInterest();
    Client getClient();

    float getBalance();
    void setBalance(float balance);
    void changeBalance(float amount) throws BankProductAccountWithDebit.NotEnoughMoneyException;

    void addInvestment(BankProduct.Investment investment);
    void eraseInvestment(BankProduct.Investment investment);
    boolean containsInvestment(BankProduct.Investment investment);
    BankProduct.Investment getInvestment(int index);

    void addCredit(BankProduct.Credit credit);
    void removeCredit(BankProduct.Credit credit);
    boolean containsCredit(BankProduct.Credit credit);
    void eraseCredit(BankProduct.Credit credit);

    BankProductAccount getAccount();

    void acceptReport(ReportVisitorInterface visitor);


    void historyAdd(BankOperation bankOperation);
}
