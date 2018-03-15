import java.util.Date;

public class Credit extends BankProduct {
    BankProductInvestment(BankProductAccount linkedAccount, Interest interest){
        super();
        this.linkedAccount = linkedAccount;
        this.interest = interest;
    }

    private BankProductAccount linkedAccount;
    private Interest interest;
    
}
