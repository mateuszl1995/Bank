package BankProduct;

import Bank.Client;
import Report.ReportVisitorInterface;
import Interest.Interest;
import BankOperation.BankOperation;

public class BankProductAccountWithDebit implements BankProductAccount, BankProductInterface {
    BankProductAccountWithDebit(BankProductAccountWithoutDebit account, float limit){
        this.account = account;
        this.limit = limit;
    }

    private float limit;
    private float debit;
    private BankProductAccountWithoutDebit account;



    public void setLimit(float limit) {
        this.limit = limit;
    }


    @Override
    public long getNumber() {
        return 0;
    }

    @Override
    public Interest getInterest() {
        return account.getInterest();
    }

    @Override
    public Client getClient() {
        return account.getClient();
    }

    public void changeBalance(float amount) throws NotEnoughMoneyException {
        float balance = account.getBalance() - debit;
        balance += amount;
        if (balance < account.getBalance() - limit)
            throw new NotEnoughMoneyException();
        if (balance < 0) {
            debit = -balance;
            account.setBalance(0.0f);
        } else {
            debit = 0;
            account.setBalance(balance);
        }
    }

    public float getBalance() {
        return account.getBalance() - debit;
    }
    public void setBalance(float x) {account.setBalance(x); debit = 0;}

    public void acceptReport(ReportVisitorInterface visitor) {
        visitor.visit(this);
    }

    @Override
    public void historyAdd(BankOperation operation) {
        account.historyAdd(operation);
    }

    @Override
    public BankProductAccount getAccount() {
        return account;
    }

    /* Przekazanie odpowiedzialności do account */
    public void addInvestment(BankProductInvestment investment) {
        account.investments.add(investment);
    }
    public void eraseInvestment(BankProductInvestment investment) {
        account.investments.remove(investment);
    }
    public boolean containsInvestment(BankProductInvestment investment) {
        return account.investments.contains(investment);
    }
    public BankProductInvestment getInvestment(int index) { return account.investments.get(index); }
    public void addCredit(BankProductCredit credit) { account.credits.add(credit); }
    public void removeCredit (BankProductCredit credit) { account.credits.remove(credit); }
    public boolean containsCredit(BankProductCredit credit) {
        return account.credits.contains(credit);
    }
    public void eraseCredit(BankProductCredit credit) {
        account.credits.remove(credit);
    }


    public class NotEnoughMoneyException extends Throwable {  }
}

