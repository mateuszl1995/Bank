import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankProductAccount extends BankProduct {
    BankProductAccount(Client client, Interest interest){
        super(interest);
        this.client = client;
        this.debit = new Debit(0.0f, this, new InterestZero());
        this.investments = new ArrayList<BankProductInvestment>();
        this.credits = new ArrayList<BankProductCredit>();
    }

    private Client client;
    private Debit debit;

    List<BankProductInvestment> investments;
    List<BankProductCredit> credits;

    public Interest getInterest() {
        return interest;
    }

    public Client getClient() {
        return client;
    }

    public void setDebit(Debit debit){
        this.debit = debit;
    }

    @Override
    public void changeBalance(float amount) {                      //todo: uwzglednić debit
        super.changeBalance(amount);
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
    public void addCredit(BankProductCredit credit) { credits.add(credit); }
    public void removeCredit (BankProductCredit credit) { credits.remove(credit); }
    public boolean containsCredit(BankProductCredit credit) {
        return credits.contains(credit);
    }
    public void eraseCredit(BankProductCredit credit) {
        credits.remove(credit);
    }
    public BankProductAccount getAccount() {
        return this;
    }
}
