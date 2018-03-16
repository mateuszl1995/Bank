import java.util.Date;

public class BankProductCredit extends BankProduct {
    private float amount;
    private float amountToPay;
    private Date expires;
    private BankProductAccount linkedAccount;
    private Interest interest;

    BankProductCredit(BankProductAccount linkedAccount, float amount, Interest interest, Date expires){
        super();
        this.linkedAccount = linkedAccount;
        this.interest = interest;
        this.amount = amount;
        this.amountToPay = amount;
        this.expires = expires;
    }

    public void payCreditRate() {
        this.amountToPay -= getCreditRate();
    }
    public float getAmountToPay() {
        return this.amountToPay;
    }
    public float getCreditRate() {
        return this.amount / 12;
    }

}
