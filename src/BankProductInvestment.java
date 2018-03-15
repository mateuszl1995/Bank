import java.util.Date;

public class BankProductLocate extends BankProduct{
    BankProductLocate(BankProductAccount linkedAccount, Interest interest, Date expires){
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

    
}
