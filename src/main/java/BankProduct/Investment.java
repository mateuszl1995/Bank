package BankProduct;

import Interest.Interest;
import Report.ReportVisitorInterface;

import java.util.Date;

public class Investment implements BankProductInterface{
    private Interest interest;
    private BankProductAccount linkedAccount;
    private float amount;
    private float initialAmount;


    public Investment(BankProductAccount linkedAccount, float amount, Interest interest){
        this.linkedAccount = linkedAccount;
        this.interest = interest;
        this.amount = amount;
        this.initialAmount = amount;
    }

    public void calculateInterest() { interest.calculateInterest(this); }
    public float getBalance() {
        return amount;
    }
    public float getAmount() { return amount + interest.calculateInterest(this);   }
    public float getInitialAmount() { return this.initialAmount; }
    public BankProductAccount getAccount() { return this.linkedAccount; }
    public Interest getInterest() {
        return interest;
    }





}
