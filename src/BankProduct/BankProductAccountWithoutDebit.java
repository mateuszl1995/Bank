package BankProduct;

import Bank.Client;
import Interest.Interest;
import Report.ReportVisitorInterface;

import java.util.ArrayList;
import java.util.List;

public class BankProductAccountWithoutDebit extends BankProduct implements BankProductAccount {
    BankProductAccountWithoutDebit(Client client, Interest interest){
        super(interest);
        this.client = client;
        this.investments = new ArrayList<BankProductInvestment>();
        this.credits = new ArrayList<BankProductCredit>();
    }

    private Client client;

    List<BankProductInvestment> investments;
    List<BankProductCredit> credits;

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
