package BankProduct;

import Bank.Client;
import BankOperation.BankOperation;
import Interest.Interest;

public interface BankProductAccount extends BankProductInterface {
    
    long getNumber();
    Interest getInterest();
    Client getClient();

    float getBalance();
    void setBalance(float balance);
    void changeBalance(float amount) throws BankProductAccountWithDebit.NotEnoughMoneyException;

    void addInvestment(BankProductInvestment investment);

    void eraseInvestment(BankProductInvestment investment);

    boolean containsInvestment(BankProductInvestment investment);
    BankProductInvestment getInvestment(int index);
    void addCredit(BankProductCredit credit);
    void removeCredit(BankProductCredit credit);
    boolean containsCredit(BankProductCredit credit);
    void eraseCredit(BankProductCredit credit);
    BankProductAccount getAccount();


    void historyAdd(BankOperation bankOperation);
}
