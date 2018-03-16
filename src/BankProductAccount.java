import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankProductAccount extends BankProduct {
    BankProductAccount(int ownerId, Interest interest){
        super();
        this.ownerId = ownerId;
        this.debit = new Debit(0);
        this.interest = interest;
        this.investments = new ArrayList<BankProductInvestment>();
        this.credits = new ArrayList<BankProductCredit>();
    }

    private int ownerId;
    private Interest interest;          //odsetki
    private Debit debit;

    List<BankProductInvestment> investments;
    List<BankProductCredit> credits;

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

    public void addInvestment(BankProductInvestment investment) {
        investments.add(investment);
    }
    public void eraseInvestment(BankProductInvestment investment) {
        investments.remove(investment);
    }
    public boolean containsInvestment(BankProductInvestment investment) {
        return investments.contains(investment);
    }
    public BankProductInvestment getInvestment(int index) { return investments.get(index); }
    public void addCredit(BankProductCredit credit) {
        credits.add(credit);
    }
    public boolean containsCredit(BankProductCredit credit) {
        return credits.contains(credit);
    }
    public void eraseCredit(BankProductCredit credit) {
        credits.remove(credit);
    }
}
