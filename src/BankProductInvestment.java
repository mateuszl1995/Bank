import java.util.Date;

public class BankProductInvestment extends BankProduct{
    BankProductInvestment(BankProductAccount linkedAccount, Interest interest, Date expires){
        super();
        this.linkedAccount = linkedAccount;
        this.interest = interest;
        this.expires = expires;
    }

    private BankProductAccount linkedAccount;
    private Interest interest;
    private Date expires;

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
