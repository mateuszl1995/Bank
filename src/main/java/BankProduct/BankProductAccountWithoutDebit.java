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
        this.investments = new ArrayList<Investment>();
        this.bankProductInterfaces = new ArrayList<Credit>();
    }

    private Client client;

    List<Investment> investments;
    List<BankProduct.BankProductInterface> credits;

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

    public void addInvestment(Investment investment) {
        investments.add(investment);
    }
    public void eraseInvestment(Investment investment) {
        investments.remove(investment);
    }
    public boolean containsInvestment(Investment investment) {
        return investments.contains(investment);
    }
    public Investment getInvestment(int index) { return investments.get(index); }
    public void addCredit(BankProduct.BankProductInterface credit) { bankProductInterfaces.add(bankProductInterface); }
    public void removeCredit (BankProduct.BankProductInterface credit) { bankProductInterfaces.remove(bankProductInterface); }
    public boolean containsCredit(BankProduct.BankProductInterface credit) {
        return bankProductInterfaces.contains(bankProductInterface);
    }
    public void eraseCredit(BankProduct.BankProductInterface credit) {
        bankProductInterfaces.remove(bankProductInterface);
    }
    public BankProductAccount getAccount() {
        return this;
    }
}
