import java.util.Date;

public class BankProductInvestment extends BankProduct{
    BankProductInvestment(BankProductAccount linkedAccount, float amount, Interest interest, Date expires){
        super(interest);
        this.linkedAccount = linkedAccount;
        this.interest = interest;
        this.expires = expires;
        this.amount = amount;
        this.initialAmount = amount;
    }

    private BankProductAccount linkedAccount;
    private Date expires;
    private float amount;
    private float initialAmount;

    public float getAmount() { return this.amount;   }
    public float getInitialAmount() { return this.initialAmount; }
    public BankProductAccount getAccount() { return this.linkedAccount; }

    public Interest getInterest() {
        return interest;
    }

    public boolean hasExpired(){
        if (expires.before(new Date())){
            return true;
        }
        else return false;
    }

    @Override
    public void acceptReport(ReportVisitorInterface visitor) {
        visitor.visit(this);
    }
}
