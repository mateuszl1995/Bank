import java.util.Date;

public class BankProductInvestment extends BankProduct{
    BankProductInvestment(BankProduct linkedAccount, float amount, Interest interest, Date expires){
        super();
        this.linkedAccount = linkedAccount;
        this.interest = interest;
        this.expires = expires;
        this.amount = amount;
    }

    private BankProduct linkedAccount;
    private Interest interest;
    private Date expires;
    private float amount;

    public Interest getInterest() {
        return interest;
    }

    public boolean hasExpired(){
        if (expires.before(new Date())){
            return true;
        }
        else return false;
    }

}
