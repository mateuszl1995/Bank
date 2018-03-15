import java.util.Date;

public class BankProductAccount extends BankProduct {
    BankProductAccount(int ownerId, Interest interest){
        super();
        this.ownerId = ownerId;
        this.debit = new Debit(0);
        this.interest = interest;
    }

    private int ownerId;
    private Interest interest;          //odsetki
    private Debit debit;
    //todo: powiązanie konta z lokatami i kredytami. moze listy?

    public Interest getInterest() {
        return interest;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setDebit(Debit debit){
        this.debit = debit;
    }

    @Override
    public void changeBalance(float ammount) {                      //todo: uwzglednić debit
        super.changeBalance(ammount);
    }
}
