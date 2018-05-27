package BankProduct;

import Report.ReportVisitorInterface;
import Interest.Interest;

import java.util.Date;

public class Credit implements BankProductInterface {
    private float amount;
    private BankProductAccount linkedAccount;
    private Interest interest;


    public Credit(BankProductAccount linkedAccount, float amount, Interest interest){
        this.interest = interest;
        this.linkedAccount = linkedAccount;
        this.amount = amount;
    }

    @Override
    public Interest getInterest() {
        return interest;
    }

    @Override
    public float getBalance() {
        return amount;
    }

    public BankProductAccount getLinkedAccount() {
        return linkedAccount;
    }

    public BankProductAccount getAccount() { return this.linkedAccount; }

    @Override
    public void calculateInterest() { interest.calculateInterest(this); }

    public float getAmount() {
        return amount + interest.calculateInterest(this);
    }
}
