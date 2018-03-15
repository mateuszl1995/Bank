import java.util.Date;

public class BankProductCredit extends BankProduct {
    BankProductCredit(BankProductAccount linkedAccount, Interest interest){
        super();
        this.linkedAccount = linkedAccount;
        this.interest = interest;

    }

    private BankProductAccount linkedAccount;
    private Interest interest;

}
