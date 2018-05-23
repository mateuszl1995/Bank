package BankProduct;

import Report.ReportVisitorInterface;
import Interest.Interest;

import java.util.Date;

public class Credit {
    private float amount;
    private Date expires;
    private BankProductAccount linkedAccount;
    private Interest interest;


    Credit(BankProductAccount linkedAccount, float amount, Interest interest, Date expires){
        this.interest = interest;
        this.linkedAccount = linkedAccount;
        this.amount = amount;
        this.expires = expires;
    }

    public Interest getInterest() {
        return interest;
    }

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

    public void acceptReport(ReportVisitorInterface visitor) {
        visitor.visit(this);
    }
}
