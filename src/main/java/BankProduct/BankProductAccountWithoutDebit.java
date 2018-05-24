package BankProduct;

import Bank.Client;
import Interest.Interest;
import Report.ReportVisitorInterface;

import java.util.ArrayList;
import java.util.List;

public class BankProductAccountWithoutDebit extends BankProduct {
    public BankProductAccountWithoutDebit(Client client, Interest interest){
        super(interest);
        this.client = client;
        this.investments = new ArrayList<BankProduct.Investment>();
        this.credits = new ArrayList<BankProduct.Credit>();
    }

    private Client client;

    List<BankProduct.Investment> investments;
    List<BankProduct.Credit> credits;

    public Interest getInterest() {
        return interest;
    }

    public Client getClient() {
        return client;
    }

    public void acceptReport(ReportVisitorInterface visitor) {
        visitor.visit(this);
    }

    @Override
    public void changeBalance(float amount) {                      //todo: uwzglednić debit
        super.changeBalance(amount);
    }

    public void addInvestment(BankProduct.Investment investment) {
        investments.add(investment);
    }
    public void eraseInvestment(BankProduct.Investment investment) {
        investments.remove(investment);
    }
    public boolean containsInvestment(BankProduct.Investment investment) {
        return investments.contains(investment);
    }
    public BankProduct.Investment getInvestment(int index) { return investments.get(index); }
    public void addCredit(BankProduct.Credit credit) { credits.add(credit); }
    public void removeCredit (BankProduct.Credit credit) { credits.remove(credit); }
    public boolean containsCredit(BankProduct.Credit credit) {
        return credits.contains(credit);
    }
    public void eraseCredit(BankProduct.Credit credit) {
        credits.remove(credit);
    }
    public BankProductAccount getAccount() {
        return this;
    }
}
