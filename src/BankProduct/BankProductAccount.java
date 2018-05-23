package BankProduct;

import Bank.Client;
import BankOperation.BankOperation;
import Interest.Interest;

public interface BankProductAccount extends BankProductInterface {
    

    public Interest getInterest();
    public Client getClient();

    public float getBalance();
    public void setBalance(float balance);
    public void changeBalance(float amount) throws BankProductAccountWithDebit.NotEnoughMoneyException;

    public void addInvestment(BankProductInvestment investment);

    public void eraseInvestment(BankProductInvestment investment);

    public boolean containsInvestment(BankProductInvestment investment);
    public BankProductInvestment getInvestment(int index);
    public void addCredit(BankProductCredit credit);
    public void removeCredit (BankProductCredit credit);
    public boolean containsCredit(BankProductCredit credit);
    public void eraseCredit(BankProductCredit credit);
    public BankProductAccount getAccount();


    void historyAdd(BankOperation bankOperation);
}
