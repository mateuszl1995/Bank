import java.util.Date;

public class BankProductCredit extends BankProduct {
    private Date expires;
    private BankProductAccount linkedAccount;


    BankProductCredit(BankProductAccount linkedAccount, float amount, Interest interest, Date expires){
        super(interest);
        this.linkedAccount = linkedAccount;
        this.balance = amount;
        this.expires = expires;
    }

    public BankProductAccount getAccount() { return this.linkedAccount; }

    public void acceptReport(ReportVisitorInterface visitor) {
        visitor.visit(this);
    }
}
