package BankProduct;

import Report.ReportVisitorInterface;
import Interest.Interest;

import java.util.Date;

public class Credit implements BankProductInterface {
    private float amount;
    private Date expires;
    private BankProductAccount linkedAccount;
    private Interest interest;


    public Credit(BankProductAccount linkedAccount, float amount, Interest interest, Date expires){
        this.interest = interest;
        this.linkedAccount = linkedAccount;
        this.amount = amount;
        this.expires = expires;
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
    public boolean hasExpired(){
        if (expires.before(new Date())){
            return true;
        }
        else return false;
    }

    public BankProductAccount getAccount() { return this.linkedAccount; }

    @Override
    public void calculateInterest() { interest.calculateInterest(this); }

}
